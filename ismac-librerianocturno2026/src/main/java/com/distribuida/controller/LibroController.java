package com.distribuida.controller;

import com.distribuida.model.Libro;
import com.distribuida.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/libros")

public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> findAll(){
        List<Libro> Libros =libroService.findAll();
        return  ResponseEntity.ok(Libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> findOne (@PathVariable int id){
        Optional<Libro> Libro=libroService.findOne(id);
        if(Libro==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Libro.orElse(null));
    }

    @PostMapping
    public ResponseEntity<Libro> save(@RequestBody Libro libro){
        Libro LibroNuevo = libroService.save(libro);
        return  ResponseEntity.ok(LibroNuevo);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Libro> update(@PathVariable int id , @RequestBody Libro libro){
        Libro LibroActualizado = libroService.update(id ,libro);
        if(LibroActualizado==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LibroActualizado);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> delete (@PathVariable int id){
        libroService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
