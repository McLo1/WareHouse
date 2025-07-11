package com.example.Backend.controller;

import com.example.Backend.dto.FerramentaDTO;
import com.example.Backend.dto.FerramentaResponseDTO;
import com.example.Backend.service.FerramentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ferramenta")
public class FerramentaController {

    private FerramentaService ferramentaService;

    public FerramentaController(FerramentaService ferramentaService) {
        this.ferramentaService = ferramentaService;
    }


    @GetMapping
    public List<FerramentaResponseDTO> listarTodos() {
        return ferramentaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<FerramentaResponseDTO> salvar(FerramentaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ferramentaService.salvar(dto));
    }

    @PutMapping
    public ResponseEntity<FerramentaResponseDTO> atualizar(@RequestBody FerramentaDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(ferramentaService.atualizar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FerramentaResponseDTO> deletar(@PathVariable Long id) {
        ferramentaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
