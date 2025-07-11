package com.example.Backend.controller;

import com.example.Backend.service.FerramentaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ferramenta")
public class FerramentaController {

    private FerramentaService ferramentaService;

    public FerramentaController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }


}
