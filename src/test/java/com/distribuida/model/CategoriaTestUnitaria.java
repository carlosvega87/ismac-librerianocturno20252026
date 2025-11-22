package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoriaTestUnitaria {
    private Categoria categoria;
    @BeforeEach
    public void setUp (){
        categoria= new Categoria (1,"terror","novela");
    }

    @Test
    public void TestCategoriaConstructor(){
        assertAll("Validar datos categoria -Constructor",
                () -> assertEquals(1,categoria.getIdCategoria()),
                ()-> assertEquals("terror",categoria.getCategoria()),
                ()-> assertEquals("novela",categoria.getDescripcion())
        );

    }
    @Test
    public void TestCategoriaSetters() {

        categoria.setIdCategoria(1);
        categoria.setCategoria("Bibliografia");
        categoria.setDescripcion("serie");
        assertAll("Validar datos categoria -Setters",
                () -> assertEquals(1, categoria.getIdCategoria()),
                () -> assertEquals("Bibliografia", categoria.getCategoria()),
                () -> assertEquals("serie", categoria.getDescripcion())
        );
    }

    @Test

    public void TestCategoriaToString(){
        String str= categoria.toString();
        assertAll("Validar datos categoria -ToString",
                ()-> assertTrue(str.contains("1")),
                ()-> assertTrue(str.contains("terror")),
                ()-> assertTrue(str.contains("novela"))
        );
    }
}
