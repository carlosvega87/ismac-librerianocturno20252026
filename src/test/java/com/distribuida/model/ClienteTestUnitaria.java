package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;
    @BeforeEach
    public void setUp(){
        cliente=new Cliente(1,"1719432274","Juan","Perez","Tumbaco","2056351","jperez@gmail.com");
    }

    @Test
    public void testClienteConstructor(){
        assertAll("Validar datos cliente -Constructor",

                ()-> assertEquals(1,cliente.getIdCliente()),
                ()-> assertEquals("1719432274",cliente.getCedula()),
                ()-> assertEquals("Juan",cliente.getNombre()),
                ()-> assertEquals("Perez",cliente.getApellido()),
                ()-> assertEquals("Tumbaco",cliente.getDireccion()),
                ()-> assertEquals("2056351",cliente.getTelefono()),
                ()-> assertEquals("jperez@gmail.com",cliente.getCorreo())
                );

    }
    @Test
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1719432271");
        cliente.setNombre("Mario");
        cliente.setApellido("Ruiz");
        cliente.setDireccion("Puembo");
        cliente.setTelefono("2056123");
        cliente.setCorreo("mruiz@gmail.com");
        assertAll("Validar datos cliente -Setters",

                ()-> assertEquals(2,cliente.getIdCliente()),
                ()-> assertEquals("1719432271",cliente.getCedula()),
                ()-> assertEquals("Mario",cliente.getNombre()),
                ()-> assertEquals("Ruiz",cliente.getApellido()),
                ()-> assertEquals("Puembo",cliente.getDireccion()),
                ()-> assertEquals("2056123",cliente.getTelefono()),
                ()-> assertEquals("mruiz@gmail.com",cliente.getCorreo())
        );
    }

    @Test

    public void clienteTestToString(){
        String str=cliente.toString();
        assertAll("Validar datos cliente -To String",
                ()->assertTrue(str.contains("1")),
                ()->assertTrue(str.contains("1719432274")),
                ()->assertTrue(str.contains("Juan")),
                ()->assertTrue(str.contains("Perez")),
                ()->assertTrue(str.contains("Tumbaco")),
                ()->assertTrue(str.contains("2056351")),
                ()->assertTrue(str.contains("jperez@gmail.com"))
        );
    }
}
