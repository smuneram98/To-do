package com.proyecto.lista.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.lista.models.NotaModel;
import com.proyecto.lista.services.NotaService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/notas")
@RequiredArgsConstructor
public class NotaController {
    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<NotaModel> crear(@RequestBody NotaModel nota){
        return ResponseEntity.ok(notaService.crear(nota));
    }

    @GetMapping
    public List<NotaModel> findAll(){
        return notaService.findAll();
    }

    @PutMapping("/{titulo}")
    public NotaModel update(@PathVariable String titulo, @RequestBody NotaModel nota){
        return notaService.update(titulo,nota);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
       return notaService.eliminar(id);
    }
}
