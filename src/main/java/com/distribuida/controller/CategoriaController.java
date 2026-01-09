package com.distribuida.controller;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import com.distribuida.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    @GetMapping
    public ResponseEntity<List<Categoria>> findAll()
    {
        List<Categoria> categorias= categoriaService.findAll();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Categoria> findOne (@PathVariable int id){
       Optional<Categoria> categoria= categoriaService.findOne(id);
        if(categoria==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoria.orElse(null));
    }
}
