package org.taohansen.tp2product.service;

import org.springframework.stereotype.Service;
import org.taohansen.tp2product.model.Category;
import org.taohansen.tp2product.model.Product;
import org.taohansen.tp2product.service.exceptions.ResourceErrorException;
import org.taohansen.tp2product.service.exceptions.ResourceNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    private void initializeProducts() {
        products.add(new Product(1L, "Cadeira Gamer", "Cadeira gamer de última geração.", 1500.00, new Category(1L, "Cadeiras")));
        products.add(new Product(2L, "Monitor Ultrawide", "Monitor para você substituir outros 2.", 1450.99, new Category(2, "Monitores")));
        products.add(new Product(3L, "AMD Ryzen 9", "Processador moderno.", 4500.68, new Category(3, "Processadores")));
    }

    public ProductService() {
        initializeProducts();
    }

    public List<Product> findAll() {
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Nenhum produto encontrado.");
        }
        return products;
    }

    public Product getById(Long id) {
        Optional<Product> obj = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        Product product = obj.orElseThrow(() -> new ResourceNotFoundException("Produto Id " + id + " não encontrado."));
        return product;
    }

    public Product insert(Product product) {
        Product entity = new Product(products.size() + 1L, product.getName(), product.getDescription(),
                product.getPrice(), product.getCategory());
        if (entity.getName() == null || entity.getName().isEmpty() || entity.getDescription().isEmpty() || entity.getPrice() <= 0) {
            throw new ResourceErrorException("Algo está inválido. Falha ao inserir produto.");
        }
        products.add(entity);
        return entity;
    }

    public Product update(Long id, Product product) {
        Product entity = getById(id);
        try {
            entity.setName(product.getName());
            entity.setDescription(product.getDescription());
            entity.setPrice(product.getPrice());
            entity.setCategory(product.getCategory());
        } catch (Exception e) {
            throw new ResourceErrorException("Algo está inválido. Falha ao atualizar produto id " + id + ".");
        }
        if (entity.getName() == null || entity.getName().isEmpty() || entity.getDescription().isEmpty() || entity.getPrice() <= 0) {
            throw new ResourceErrorException("Algo está inválido. Falha ao atualizar o produto.");
        }
        return entity;
    }

    public boolean delete(Long id) {
        return products.removeIf(product -> product.getId().equals(id));
    }
}
