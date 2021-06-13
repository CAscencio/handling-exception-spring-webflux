package com.ascencio.dev.exception;

public class UnauthorizedException extends RuntimeException {

    private static final String DESCRIPTION = "Unauthorize Exception";

    public UnauthorizedException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
