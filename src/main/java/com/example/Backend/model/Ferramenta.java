package com.example.Backend.model;

import com.example.Backend.Enuns.FerramentaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.boot.model.naming.ImplicitEntityNameSource;

@Entity
public class Ferramenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "Nome é obrigatorio")
    private String nome;
    @NotBlank(message = "Marca é obrigatorio")
    private String marca;
    @NotBlank(message = "Tipo é obrigatorio")
    private String tipo;

    private FerramentaStatus ferramentaStatus;

    public Ferramenta() {
    }

    public Ferramenta(Long id, String nome, String marca, String tipo, FerramentaStatus ferramentaStatus) {
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
