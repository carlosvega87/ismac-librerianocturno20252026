package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AutorTestUnitaria {
    private Autor autor;
   @BeforeEach
   public void setUp(){
       autor=new Autor(1,"Luis","Perez","Ecuador","Quito","0990464221","lperez@gmail.com");
   }
     @Test
      public void TestAutorConstructor(){
            assertAll("Validar datos autor -Constructor",
                    ()-> assertEquals(1,autor.getIdAutor()),
                    ()-> assertEquals("Luis",autor.getNombre()),
                    ()-> assertEquals("Perez",autor.getApellido()),
                    ()-> assertEquals("Ecuador",autor.getPais()),
                    ()-> assertEquals("Quito",autor.getDireccion()),
                    ()-> assertEquals("0990464221",autor.getTelefono()),
                    ()-> assertEquals("lperez@gmail.com",autor.getCorreo())
                    );
    }

@Test
    public void TestAutorSetters(){
       autor.setIdAutor(1);
       autor.setNombre("Mario");
       autor.setApellido("Ruiz");
       autor.setPais("Peru");
       autor.setDireccion("Lima");
       autor.setTelefono("2056341");
       autor.setCorreo("mruiz@gmail.com");

    assertAll("Validar datos autor -Setters",
            ()-> assertEquals(1,autor.getIdAutor()),
            ()-> assertEquals("Mario",autor.getNombre()),
            ()-> assertEquals("Ruiz",autor.getApellido()),
            ()-> assertEquals("Peru",autor.getPais()),
            ()-> assertEquals("Lima",autor.getDireccion()),
            ()-> assertEquals("2056341",autor.getTelefono()),
            ()-> assertEquals("mruiz@gmail.com",autor.getCorreo())
    );
}

@Test
    public void TestAutorToString(){
       String str =autor.toString();
    assertAll("Validar datos autor-To String",
            ()->assertTrue(str.contains("1")),
            ()->assertTrue(str.contains("Luis")),
            ()->assertTrue(str.contains("Perez")),
            ()->assertTrue(str.contains("Ecuador")),
            ()->assertTrue(str.contains("Quito")),
            ()->assertTrue(str.contains("0990464221")),
            ()->assertTrue(str.contains("lperez@gmail.com"))
    );
}

}
