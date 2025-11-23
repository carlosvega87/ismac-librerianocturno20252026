package com.distribuida.dao;

import com.distribuida.model.Autor;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

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
        for (Autor item : autores) {
            System.out.println(item.toString());
        }
    }

    @Test
    public void testAutorFindOne() {
        Optional<Autor> autor = autorRepository.findById(1);
        System.out.println((autor));
    }

    @Test
    public void testAutorSave() {
        Autor autor = new Autor(0, "Jose", "Ramos", "Ecuador", "Puembo", "2056412", "jramos@gmail.com");
        autorRepository.save(autor);
    }

    @Test
    public void testAutorActualizar(){

        Optional<Autor>autor=autorRepository.findById(54);
        autor.orElse(null).setNombre("Carlos");
        autor.orElse(null).setApellido("Vera");
        autor.orElse(null).setPais("Ecuador");
        autor.orElse(null).setDireccion("Pifo");
        autor.orElse(null).setTelefono("2056341");
        autor.orElse(null).setCorreo("cvera@gmail.com");

    }
    @Test
    public void testAutorBorrar(){
      autorRepository.deleteById(54);
    }


}