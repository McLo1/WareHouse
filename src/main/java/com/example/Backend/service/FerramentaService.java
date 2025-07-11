package com.example.Backend.service;

import com.example.Backend.dto.FerramentaResponseDTO;
import com.example.Backend.model.Ferramenta;
import com.example.Backend.repository.FerrametaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerramentaService {

    private FerrametaRepository ferrametaRepository;

    public FerramentaService(FerrametaRepository ferrametaRepository) {
        this.ferrametaRepository = ferrametaRepository;
    }


    public List<Ferramenta> listarTodos() {
        return ferrametaRepository.findAll()
                .stream()
                .map(ferramenta -> {
                    FerramentaResponseDTO ferramentaResponseDTO = new
                            FerramentaResponseDTO(
                                    ferramenta.getId(),
                                    ferramenta.getNome(),
                                    ferramenta.getTipo(),
                                    ferramenta.getFerramentaStatus()
                    );
                    return ferramentaResponseDTO;

                }).toList();
    }

}
