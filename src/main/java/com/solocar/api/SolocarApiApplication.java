package com.solocar.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolocarApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SolocarApiApplication.class, args);
        System.out.println("========================================");
        System.out.println("   API SOLOCAR - Servicio corriendo");
        System.out.println("   http://localhost:8080/api/cotizaciones");
        System.out.println("========================================");
    }
}