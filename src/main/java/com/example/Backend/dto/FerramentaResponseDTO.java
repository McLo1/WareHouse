package com.example.Backend.dto;

import com.example.Backend.Enuns.FerramentaStatus;

public class FerramentaResponseDTO {

    private String nome;
    private String marca;
    private String tipo;
    private FerramentaStatus ferramentaStatus;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FerramentaStatus getFerramentaStatus() {
        return ferramentaStatus;
    }

    public void setFerramentaStatus(FerramentaStatus ferramentaStatus) {
        this.ferramentaStatus = ferramentaStatus;
    }

}
