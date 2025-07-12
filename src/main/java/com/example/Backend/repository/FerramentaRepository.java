package com.example.Backend.repository;

import com.example.Backend.model.Ferramenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Long> {
    Optional<Ferramenta> findByNome(String Nome);
}
