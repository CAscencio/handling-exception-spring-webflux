package com.ascencio.dev.exception;

public class NotFoundException extends RuntimeException {

    private static final String DESCRIPTION = "Not Found Exception";

    public NotFoundException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
