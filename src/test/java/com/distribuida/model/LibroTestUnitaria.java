package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTestUnitaria {
    private Libro libro;
    private Categoria categoria;
    private Autor autor;
    @BeforeEach
    public void setUp() {
        categoria = new Categoria(1, "Terror", "casos reales");
        autor = new Autor(1, "Mario", "Ruiz", "Argentina", "Plaza Central", "0994265410", "mruiz@gmail.com");
        libro = new Libro();
        libro.setIdlibro(1);
        libro.setTitulo("Causa y efecto");
        libro.setEditorial("Conejo");
        libro.setNumPaginas(200);
        libro.setEdicion("2025");
        libro.setIdioma("español");
        libro.setFechaPublicacion("19/11/2025");
        libro.setDescripcion("investigacion");
        libro.setTipoPasta("blanda");
        libro.setIsbn("2025");
        libro.setNumEjemplares(100);
        libro.setPortada("nueva");
        libro.setPresentacion("virtual");
        libro.setPrecio(12.50);
// inyeccion de dependencias
        libro.setCategoria(categoria);
        libro.setAutor(autor);
    }
@Test
public void libroTestConstructor(){
    assertAll("Validar Constructor - Libro",
            ()->assertEquals(1,libro.getIdlibro()),
            ()->assertEquals("Causa y efecto",libro.getTitulo()),
            ()->assertEquals("Conejo",libro.getEditorial()),
            ()->assertEquals(200,libro.getNumPaginas()),
            ()->assertEquals("2025",libro.getEdicion()),
            ()->assertEquals("español",libro.getIdioma()),
            ()->assertEquals("19/11/2025",libro.getFechaPublicacion()),
            ()->assertEquals("investigacion",libro.getDescripcion()),
            ()->assertEquals("blanda",libro.getTipoPasta()),
            ()->assertEquals("2025",libro.getIsbn()),
            ()->assertEquals(100,libro.getNumEjemplares()),
            ()->assertEquals("nueva",libro.getPortada()),
            ()->assertEquals("virtual",libro.getPresentacion()),
            ()->assertEquals(12.50,libro.getPrecio())
    );
        }
        @Test
    public void libroTestSetters(){
            categoria = new Categoria(2, "Drama", "casos reales");
            autor = new Autor(2, "Maria", "Ruiz", "Argentina2", "Plaza Central2", "0994265412", "mruiz@gmail.com");
            libro = new Libro();
            libro.setIdlibro(2);
            libro.setTitulo("Causas");
            libro.setEditorial("liebre");
            libro.setNumPaginas(100);
            libro.setEdicion("2026");
            libro.setIdioma("ingles");
            libro.setFechaPublicacion("20/11/2025");
            libro.setDescripcion("investigacion");
            libro.setTipoPasta("blanda");
            libro.setIsbn("2026");
            libro.setNumEjemplares(200);
            libro.setPortada("nueva");
            libro.setPresentacion("virtual");
            libro.setPrecio(15.50);
            // inyeccion de dependencias
            libro.setCategoria(categoria);
            libro.setAutor(autor);

            assertAll("Validar Setters - Libro",
                    ()->assertEquals(2,libro.getIdlibro()),
                    ()->assertEquals("Causas",libro.getTitulo()),
                    ()->assertEquals("liebre",libro.getEditorial()),
                    ()->assertEquals(100,libro.getNumPaginas()),
                    ()->assertEquals("2026",libro.getEdicion()),
                    ()->assertEquals("ingles",libro.getIdioma()),
                    ()->assertEquals("20/11/2025",libro.getFechaPublicacion()),
                    ()->assertEquals("investigacion",libro.getDescripcion()),
                    ()->assertEquals("blanda",libro.getTipoPasta()),
                    ()->assertEquals("2026",libro.getIsbn()),
                    ()->assertEquals(200,libro.getNumEjemplares()),
                    ()->assertEquals("nueva",libro.getPortada()),
                    ()->assertEquals("virtual",libro.getPresentacion()),
                    ()->assertEquals(15.50,libro.getPrecio()),
            ()->assertEquals(2,libro.getAutor().getIdAutor()),
            ()->assertEquals(2,libro.getCategoria().getIdCategoria())
            );

        }
@Test
public void libroTestToString(){
        String str =libro.toString();
    assertAll("Validar to String - Libro",
            ()->assertTrue(str.contains("1")),
            ()->assertTrue(str.contains("Causa y efecto")),
            ()->assertTrue(str.contains("Conejo")),
            ()->assertTrue(str.contains("200")),
            ()->assertTrue(str.contains("2025")),
            ()->assertTrue(str.contains("español")),
            ()->assertTrue(str.contains("19/11/2025")),
            ()->assertTrue(str.contains("investigacion")),
            ()->assertTrue(str.contains("blanda")),
            ()->assertTrue(str.contains("2025")),
            ()->assertTrue(str.contains("100")),
            ()->assertTrue(str.contains("nueva")),
            ()->assertTrue(str.contains("virtual")),
            ()->assertTrue(str.contains("1")),
            ()->assertTrue(str.contains("1"))
            );
}

}
