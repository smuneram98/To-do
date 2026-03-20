package com.proyecto.lista.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.lista.models.NotaModel;
import com.proyecto.lista.repository.NotaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaService {
    private final NotaRepository notaRepository;

    public NotaModel crear(NotaModel nota){
        if(notaRepository.existsByTitulo(nota.getTitulo())){
            System.out.println("ya existe");
        }

        return notaRepository.save(nota);
        
    }

    public List<NotaModel> findAll(){
        return notaRepository.findAll();
    }

    public Optional<NotaModel> findById(Long id){
        return notaRepository.findById(id);
    }

    public Optional<NotaModel> findByTitulo(String titulo){
        return notaRepository.findByTitulo(titulo);
    }

    public NotaModel update(String titulo, NotaModel notaDetails){
        NotaModel nota=notaRepository.findByTitulo(titulo)
        .orElseThrow(()->new RuntimeException("Nota no encontrada"));

        if(notaDetails.getContenido()!=null && !notaDetails.getContenido().trim().isEmpty()){
            nota.setContenido(notaDetails.getContenido());
        }

        if(notaDetails.isDone()!=nota.isDone()){
            nota.setDone(!nota.isDone());
        }

        return notaRepository.save(nota);
    }

    public String eliminar(Long id){
        NotaModel nota=notaRepository.findById(id)
        .orElseThrow(()->new RuntimeException("Nota no encontrada"));

        notaRepository.delete(nota);
        
        return "Nota eliminada";
    }

}
