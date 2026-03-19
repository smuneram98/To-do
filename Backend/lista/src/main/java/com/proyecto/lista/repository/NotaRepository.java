package com.proyecto.lista.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.lista.models.NotaModel;

public interface NotaRepository extends JpaRepository<NotaModel,Long>{
    Optional<NotaModel> buscarPorTitulo(String titulo);

    boolean existeTitulo(String titulo);
}
