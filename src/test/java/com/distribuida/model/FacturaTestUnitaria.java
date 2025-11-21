package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FacturaTestUnitaria {

    private Cliente cliente;
    private Factura factura;
    @BeforeEach
    public void setUp(){
        cliente=new Cliente(1,"1719432274","Juan","Perez","Tumbaco2","20562222","jtaipe@gmail.com");
factura = new Factura();
factura.setIdFactura(1);
factura.setNumFactura("FAC-001");
factura.setFecha(new Date());
factura.setTotalNeto(100.00);
factura.setIva(15.00);
factura.setTotal(115.00);

// inyeccion de dependencias
       factura.setCliente(cliente);
    }

@Test
   public void facturaTestConstructor(){
        assertAll("Validar Constructor - Factura",
                ()->assertEquals(1,factura.getIdFactura()),
                ()->assertEquals("FAC-001",factura.getNumFactura()),
                //() -> assertEquals(new Date(), factura.getFecha()),
                ()->assertEquals(100.00,factura.getTotalNeto()),
                ()->assertEquals(15.00,factura.getIva()),
                ()->assertEquals(115.00,factura.getTotal()),
                ()->assertEquals("Juan",factura.getCliente().getNombre())
                    );
}
@Test
    public void facturaTestSetters(){
    cliente=new Cliente(2,"1719432272","Juan2","Taipe2","Tumbaco","2056351","jperez@gmail.com");

    factura.setIdFactura(2);
        factura.setNumFactura("FAC-002");
        factura.setFecha(new Date());
        factura.setTotalNeto(200.00);
        factura.setIva(30.00);
        factura.setTotal(230.00);

        factura.setCliente(cliente);

    assertAll("Validar Setters - Factura",
            ()->assertEquals(2,factura.getIdFactura()),
            ()->assertEquals("FAC-002",factura.getNumFactura()),
            //() -> assertEquals(new Date(), factura.getFecha()),
            ()->assertEquals(200.00,factura.getTotalNeto()),
            ()->assertEquals(30.00,factura.getIva()),
            ()->assertEquals(230.00,factura.getTotal()),
            ()->assertEquals("Juan2",factura.getCliente().getNombre())
    );

}

@Test
    public void facturaTestToString(){
        String str= factura.toString();
        assertAll("Validar to String - Factura",
                ()->assertTrue(str.contains("1")),
                ()->assertTrue(str.contains("FAC-001")),
                ()->assertTrue(str.contains("100.0")),
                ()->assertTrue(str.contains("15.0")),
                ()->assertTrue(str.contains("115.0")),
                ()->assertTrue(str.contains("Juan"))
                );
}
@Test
    public void facturaTestInyector(){
        assertAll("Validar metodo Inyector -Factura",
                ()->assertNotNull(factura.getCliente()),
                ()-> assertEquals("Perez",factura.getCliente().getApellido())
    );

}

@Test
    public void facturaTestValoresNegativos(){
        factura.setTotal(-100.00);
        assertAll("Validar datos negatios -Factura",
                ()-> assertEquals(-100.00,factura.getTotal())
        );

        //vALIDAR LOS CAMPOS NEGATIVOS, SOLO DEBERIA EXISTIR VALORES POSITIVOS EN LA factura

}


}
