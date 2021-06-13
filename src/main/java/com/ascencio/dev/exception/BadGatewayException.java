package com.ascencio.dev.exception;

public class BadGatewayException extends RuntimeException {

    private static final String DESCRIPTION = "Bad Gateway Exception";

    public BadGatewayException(String detail) {
        super(String.format("%s - %s", DESCRIPTION, detail));
    }
}
