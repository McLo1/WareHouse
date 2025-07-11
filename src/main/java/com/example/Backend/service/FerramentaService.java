package com.example.Backend.service;

import com.example.Backend.dto.FerramentaDTO;
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
    public List<FerramentaResponseDTO> listarTodos() {
        return ferrametaRepository.findAll()
                .stream()
                .map(ferramenta -> {
                    FerramentaResponseDTO ferramentaResponseDTO = new
                            FerramentaResponseDTO(
                                    ferramenta.getId(),
                                    ferramenta.getNome(),
                                    ferramenta.getMarca(),
                                    ferramenta.getTipo(),
                                    ferramenta.getFerramentaStatus()
                    );
                    return ferramentaResponseDTO;
                }).toList();
    }

    public FerramentaResponseDTO salvar(FerramentaDTO ferramentaDTO) {
        if (ferrametaRepository.findById(ferramentaDTO.getId()).isPresent()){
            throw new RuntimeException("Ferramenta já cadastrada");
        }
        Ferramenta ferramenta = new Ferramenta(
                null,
                ferramentaDTO.getNome(),
                ferramentaDTO.getMarca(),
                ferramentaDTO.getTipo(),
                ferramentaDTO.getFerramentaStatus()

        );
        ferrametaRepository.save(ferramenta);

        FerramentaResponseDTO ferramentaResponseDTO = new FerramentaResponseDTO(
                ferramenta.getId(),
                ferramenta.getNome(),
                ferramenta.getMarca(),
                ferramenta.getTipo(),
                ferramenta.getFerramentaStatus()
        );
        return ferramentaResponseDTO;
    }

}
