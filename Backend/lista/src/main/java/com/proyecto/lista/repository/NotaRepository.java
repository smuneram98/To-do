package com.proyecto.lista.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.lista.models.NotaModel;
//import java.util.List;


public interface NotaRepository extends JpaRepository<NotaModel,Long>{
    Optional<NotaModel> findByTitulo(String titulo);
    
    boolean existsByTitulo(String titulo);
   /*  boolean existeTitulo(String titulo);
     */
}
