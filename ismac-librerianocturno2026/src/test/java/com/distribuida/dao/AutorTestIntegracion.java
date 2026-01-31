package com.distribuida.dao;

import com.distribuida.model.Autor;
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
public class AutorTestIntegracion {
    @Autowired
    private AutorRepository autorRepository;

    @Test
    public void testAutorFindAll() {
        List<Autor> autores = autorRepository.findAll();
        assertNotNull(autores);
        assertTrue(autores.size() > 0);
        for (Autor item : autores) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testAutorFindOne() {
        Optional<Autor> autor = autorRepository.findById(1);
        assertNotNull(autor.isPresent());
        assertEquals("Jose", autor.orElse(null).getNombre());
        assertEquals("Ramos", autor.orElse(null).getApellido());
        System.out.println((autor));
    }

    @Test
    public void testAutorSave() {
        Autor autor = new Autor(0, "Jose", "Ramos", "Ecuador", "Puembo", "2056412", "jramos@gmail.com");
        Autor autorGuardado = autorRepository.save(autor);
        assertNotNull((autorGuardado));
        assertEquals("Jose", autorGuardado.getNombre());
        assertEquals("Ramos", autorGuardado.getApellido());
    }

    @Test
    public void testAutorActualizar() {
        Optional<Autor> autor = autorRepository.findById(56);
        assertTrue(autor.isPresent());
        autor.orElse(null).setNombre("Carlos");
        autor.orElse(null).setApellido("Vera");
        autor.orElse(null).setPais("Ecuador");
        autor.orElse(null).setDireccion("Pifo");
        autor.orElse(null).setTelefono("2056341");
        autor.orElse(null).setCorreo("cvera@gmail.com");
        Autor autorActualizado = autorRepository.save(autor.orElse(null));
        assertNotNull(autorActualizado);
        assertEquals("Carlos", autorActualizado.getNombre());
        assertEquals("Vera", autorActualizado.getApellido());

    }

    @Test
    public void testAutorBorrar() {
        autorRepository.deleteById(55);
        if (autorRepository.existsById(55)) {
            autorRepository.deleteById(55);
        }
        assertFalse(autorRepository.existsById(55));

    }
}