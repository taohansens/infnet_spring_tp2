package org.taohansen.tp2product.service.exceptions;

public class ResourceErrorException extends RuntimeException {
    public ResourceErrorException(String msg) {
        super(msg);
    }
}