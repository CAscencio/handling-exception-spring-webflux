package com.ascencio.dev.exception;

public class ForbiddenException extends RuntimeException {
    private static final String DESCRIPTION = "Forbidden Exception";

    public ForbiddenException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
