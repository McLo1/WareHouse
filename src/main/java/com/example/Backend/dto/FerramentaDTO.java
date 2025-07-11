package com.example.Backend.dto;


import com.example.Backend.Enuns.FerramentaStatus;

public class FerramentaDTO {

    private Long id;
    private String nome;
    private String marca;
    private String tipo;
    private FerramentaStatus ferramentaStatus;

    public FerramentaDTO(Long id, String nome, String marca, String tipo, FerramentaStatus ferramentaStatus) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.tipo = tipo;
        this.ferramentaStatus = ferramentaStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
