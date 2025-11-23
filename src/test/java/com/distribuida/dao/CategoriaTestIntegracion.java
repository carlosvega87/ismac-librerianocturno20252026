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
        for (Categoria item : categorias) {
            System.out.println(item.toString());
        }
    }
    @Test
    public void testCategoriaFindOne(){
        Optional<Categoria> categoria= categoriaRepository.findById(1);
        System.out.println(categoria);

    }
    @Test
    public void testCategoriaSave(){
        Categoria categoria =new Categoria(0,"Terror","cuentos reales");
        categoriaRepository.save(categoria);

    }
@Test
    public void testCategoriaActualizar(){
   Optional<Categoria> categoria = categoriaRepository.findById(58);
            categoria.orElse(null).setCategoria("Drama");
            categoria.orElse(null).setDescripcion("Casos ficticios");

}
@Test
    public void testCategoriaBorrar(){
       categoriaRepository.deleteById(58);
}


}
