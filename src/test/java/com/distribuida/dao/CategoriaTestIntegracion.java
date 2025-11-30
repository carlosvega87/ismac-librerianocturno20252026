package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Categoria;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value= false)
public class CategoriaTestIntegracion{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Test
    public void testCategoriaFindAll() {
        List<Categoria> categorias = categoriaRepository.findAll();
        assertNotNull(categorias);
        assertTrue(categorias.size()> 0);
        for (Categoria item : categorias) {
            System.out.println(item.toString());
        }
    }
    @Test
    public void testCategoriaFindOne(){
        Optional<Categoria> categoria= categoriaRepository.findById(7);
        assertNotNull(categoria.isPresent());
        assertEquals("Novela",categoria.orElse(null).getCategoria());
        assertEquals("Autobiografia",categoria.orElse(null).getDescripcion());
        System.out.println(categoria);

    }
    @Test
    public void testCategoriaSave(){
        Categoria categoria =new Categoria(0,"Terror","cuentos reales");
       Categoria categoriaGuardado= categoriaRepository.save(categoria);
       assertNotNull(categoriaGuardado);
       assertEquals("Terror",categoriaGuardado.getCategoria());
       assertEquals("cuentos reales",categoriaGuardado.getDescripcion());

    }
@Test
    public void testCategoriaActualizar(){
   Optional<Categoria> categoria = categoriaRepository.findById(59);
        assertTrue(categoria.isPresent());
        categoria.orElse(null).setCategoria("Drama");
        categoria.orElse(null).setDescripcion("Casos ficticios");
        Categoria categoriaActualizado = categoriaRepository.save(categoria.orElse(null));

        assertNotNull(categoriaActualizado);
        assertEquals("Drama",categoriaActualizado.getCategoria());
        assertEquals("Casos ficticios",categoriaActualizado.getDescripcion());
}
@Test
    public void testCategoriaBorrar(){
        categoriaRepository.deleteById(59);
        if(categoriaRepository.existsById(59)){
            categoriaRepository.deleteById(59);
    }
        assertFalse(categoriaRepository.existsById(59));
}


}
