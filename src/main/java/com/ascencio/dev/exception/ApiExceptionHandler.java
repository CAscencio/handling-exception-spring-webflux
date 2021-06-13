package com.ascencio.dev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseBody
    public ErrorMessage unauthorizedRequest(Exception e){
        return new ErrorMessage(e, HttpStatus.UNAUTHORIZED.value());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception e) {
        return new ErrorMessage(e, HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            DateTimeParseException.class,
            WebExchangeBindException.class,
            HttpMessageNotReadableException.class,
            ServerWebInputException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(Exception e) {
        return new ErrorMessage(e, HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ConflictException.class})
    @ResponseBody
    public ErrorMessage conflict(Exception e) {
        return new ErrorMessage(e, HttpStatus.CONFLICT.value());
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    @ResponseBody
    public ErrorMessage forbidden(Exception e){
        return new ErrorMessage(e, HttpStatus.FORBIDDEN.value());
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(BadGatewayException.class)
    @ResponseBody
    public ErrorMessage badGateway(Exception e){
        return new ErrorMessage(e, HttpStatus.BAD_GATEWAY.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorMessage exception(Exception e){
        return new ErrorMessage(e, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
