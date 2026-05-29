package com.estudiante.proyecto.examenedusmart.controller;

import com.estudiante.proyecto.examenedusmart.service.EduSmartAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/edusmart")
public class MarketingController {

    @Autowired
    private EduSmartAIService aiService;

    @GetMapping("/publicidad")
    public String obtenerPublicidad(@RequestParam String tema, @RequestParam String audiencia) {
        return aiService.generarPublicidad(tema, audiencia);
    }
}

