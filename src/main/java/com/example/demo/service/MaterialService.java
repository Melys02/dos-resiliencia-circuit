package com.example.demo.service;


import org.springframework.stereotype.Service;
@Service

public class MaterialService {

    public String checkDisponibility(Long id) {
        // Simulación de llamada a servicio externo
        if (Math.random() > 0.5) {
            throw new RuntimeException("Error en el servicio de inventario");
        }
        return "Material disponible";
    }
}