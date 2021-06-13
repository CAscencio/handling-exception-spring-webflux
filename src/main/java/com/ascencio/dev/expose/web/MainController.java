package com.ascencio.dev.expose.web;

import com.ascencio.dev.exception.BadRequestException;
import com.ascencio.dev.exception.NotFoundException;
import com.ascencio.dev.exception.UnauthorizedException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Map;

@RestController
@RequestMapping("/exception")
public class MainController {

    @GetMapping("/unauthorized/{age}")
    public Map<String, String> unauthorized(@PathVariable Integer age) {
        if (age < 18) throw new UnauthorizedException("Eres menor de edad");
        return Map.of("message", "Welcome !!");
    }

    @GetMapping("/notFound/{id}")
    public Mono<Map<String, Integer>> notFound(@PathVariable Integer id) {
        if (id < 14) {
            return Mono.error(new NotFoundException("El id : " + id + " no fue encontrado"));
        }
        return Mono.just(Map.of("value", id));
    }

    @GetMapping("/badRequest")
    public Flux<String> badRequest(@RequestBody Map<String, String> date) {
        try {
            return Flux.just(OffsetDateTime.parse(date.get("date")).toString());
        } catch (DateTimeParseException e) {
            return Flux.error(new BadRequestException("La fecha no es valida"));
        }
    }
}
