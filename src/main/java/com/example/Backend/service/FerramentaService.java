package com.example.Backend.service;

import com.example.Backend.dto.FerramentaDTO;
import com.example.Backend.dto.FerramentaResponseDTO;
import com.example.Backend.model.Ferramenta;
import com.example.Backend.repository.FerramentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FerramentaService {

    private FerramentaRepository ferramentaRepository;

    public FerramentaService(FerramentaRepository ferramentaRepository) {
        this.ferramentaRepository = ferramentaRepository;
    }
    public List<FerramentaResponseDTO> listarTodos() {
        return ferramentaRepository.findAll()
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
        if (ferramentaRepository.findByNome(ferramentaDTO.getNome()).isPresent()){
            throw new RuntimeException("Ferramenta já cadastrada");
        }
        Ferramenta ferramenta = new Ferramenta(
                ferramentaDTO.getId(),
                ferramentaDTO.getNome(),
                ferramentaDTO.getMarca(),
                ferramentaDTO.getTipo(),
                ferramentaDTO.getFerramentaStatus()

        );
        ferramentaRepository.save(ferramenta);

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
        Ferramenta ferramenta = ferramentaRepository.findById(ferramentaDTO.getId()).map(f -> {
            f.setNome(ferramentaDTO.getNome());
            f.setMarca(ferramentaDTO.getMarca());
            f.setTipo(ferramentaDTO.getTipo());
            f.setFerramentaStatus(ferramentaDTO.getFerramentaStatus());

            return f;
        })
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

        ferramentaRepository.save(ferramenta);

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
        Ferramenta ferramenta = ferramentaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ferramenta não encontrada"));

        ferramentaRepository.deleteById(id);
    }



}
