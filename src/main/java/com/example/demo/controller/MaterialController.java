package com.example.demo.controller;

import com.example.demo.service.MaterialService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/material")
public class MaterialController {


    private final MaterialService materialService;

    @GetMapping
    @CircuitBreaker(name = "myservice", fallbackMethod = "fallbackDisponibility")
    public String checkDisponibilidad(Long id) {
        return materialService.checkDisponibility(id);
    }

    public String fallbackDisponibility(Long id, Throwable throwable) {
        // Retorna una respuesta predeterminada en caso de fallo
        return "No disponible temporalmente. Por favor intente más tarde.";
    }
}