package com.example.Backend.service;

import com.example.Backend.dto.FerramentaDTO;
import com.example.Backend.dto.FerramentaResponseDTO;
import com.example.Backend.model.Ferramenta;
import com.example.Backend.repository.FerrametaRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
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

    public FerramentaResponseDTO atualizar(FerramentaDTO ferramentaDTO) {
        Ferramenta ferramenta = ferrametaRepository.findById(ferramentaDTO.getId()).map(f -> {
            f.setId(null);
            f.setNome(ferramentaDTO.getNome());
            f.setMarca(ferramentaDTO.getMarca());
            f.setTipo(ferramentaDTO.getTipo());
            f.setFerramentaStatus(ferramentaDTO.getFerramentaStatus());

            return f;
        })
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

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

    public void excluir(Long id) {
        Ferramenta ferramenta = ferrametaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

        ferrametaRepository.deleteById(id);
    }



}
