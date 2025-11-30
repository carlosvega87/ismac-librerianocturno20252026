package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Libro;
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
@Rollback(value = false)
public class LibroTestIntegracion {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void testLibroFindAll(){
        List<Libro> libro=libroRepository.findAll();
        assertNotNull (libro);
        assertTrue(libro.size()>0);
        libro.forEach(System.out::println);

    }
    @Test
    public void testLibroFindOne(){
        Optional<Libro> libro =libroRepository.findById(4);
        assertTrue(libro.isPresent());
        assertEquals( "pinocho",libro.orElse(null).getTitulo());
        assertEquals("mappa",libro.orElse(null).getEditorial());
        System.out.println(libro);
    }
@Test
    public void testLibroSave(){
        Optional<Autor> autor =autorRepository.findById(4);
        assertTrue(autor.isPresent());

        Libro libro1= new Libro();
        libro1.setIdlibro(0);
        libro1.setTitulo("cenicienta");
        libro1.setEditorial("coquito");
        libro1.setNumPaginas(20);
        libro1.setEdicion("2025");
        libro1.setIdioma("español");
        libro1.setFechaPublicacion("12/12/2023");
        libro1.setDescripcion("nuevo");
        libro1.setTipoPasta("dura");
        libro1.setIsbn("2025");
        libro1.setNumEjemplares(100);
        libro1.setPortada("nueva");
        libro1.setPresentacion("virtual");
        libro1.setPrecio(12.00);
        libro1.setAutor(autor.orElse(null));


        Libro libroGuardado =libroRepository.save(libro1);
        assertNotNull(libroGuardado);
        assertEquals("cenicienta",libroGuardado.getTitulo());
        assertEquals("coquito",libroGuardado.getEditorial());
        assertEquals(20,libroGuardado.getNumPaginas());
        assertEquals("2025",libroGuardado.getEdicion());
        assertEquals("español",libroGuardado.getIdioma());
        assertEquals("12/12/2023",libroGuardado.getFechaPublicacion());
        assertEquals("nuevo",libroGuardado.getDescripcion());
        assertEquals("dura",libroGuardado.getTipoPasta());
        assertEquals("2025",libroGuardado.getIsbn());
        assertEquals(100,libroGuardado.getNumEjemplares());
        assertEquals("nueva",libroGuardado.getPortada());
        assertEquals("virtual",libroGuardado.getPresentacion());
        assertEquals(12,libroGuardado.getPrecio());
    }
    @Test
    public void testLibroUpdate(){
        Optional<Autor> autor=autorRepository.findById(2);
        assertTrue(autor.isPresent());
        Optional<Libro> libro= libroRepository.findById(79);
        assertTrue(libro.isPresent());
        libro.orElse(null).setTitulo("gato");
        libro.orElse(null).setEditorial("coquito");
        libro.orElse(null).setNumPaginas(50);
        libro.orElse(null).setEdicion("2025");
        libro.orElse(null).setIdioma("español");
        libro.orElse(null).setFechaPublicacion("29/11/2025");
        libro.orElse(null).setDescripcion("nueva");
        libro.orElse(null).setTipoPasta("dura");
        libro.orElse(null).setIsbn("1987");
        libro.orElse(null).setNumEjemplares(100);
        libro.orElse(null).setPortada("nueva");
        libro.orElse(null).setPresentacion("virtual");
        libro.orElse(null).setPrecio(10.00);
        libro.orElse(null).setAutor(autor.orElse(null));

        Libro libroActualizado =libroRepository.save(libro.orElse(null));
        assertNotNull(libroActualizado);
        assertEquals("gato",libroActualizado.getTitulo());
        assertEquals("coquito",libroActualizado.getEditorial());
        assertEquals(50,libroActualizado.getNumPaginas());
        assertEquals("2025",libroActualizado.getEdicion());
        assertEquals("español",libroActualizado.getIdioma());
        assertEquals("29/11/2025",libroActualizado.getFechaPublicacion());
        assertEquals("nueva",libroActualizado.getDescripcion());
        assertEquals("dura",libroActualizado.getTipoPasta());
        assertEquals("1987",libroActualizado.getIsbn());
        assertEquals(100,libroActualizado.getNumEjemplares());
        assertEquals("nueva",libroActualizado.getPortada());
        assertEquals("virtual",libroActualizado.getPresentacion());
        assertEquals(10.00,libroActualizado.getPrecio());
    }
    @Test
    public void testLibroDelete(){
        if (libroRepository.existsById(79)){
            libroRepository.deleteById(79);
        }
        assertFalse(libroRepository.existsById(79));
    }


}
