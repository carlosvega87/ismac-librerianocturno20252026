package com.distribuida.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacturaDetalleTestUnitaria {
    private FacturaDetalle facturaDetalle;
    private Libro libro;
    private Factura factura;
    private Categoria categoria;
    private Autor autor;
    private Cliente cliente;
    @BeforeEach
    void setUp(){
        categoria =new Categoria(1,"terror","casos reales");
        autor=new Autor(1,"Luis","Perez","Ecuador","Quito","0990464221","lperez@gmail.com");
        cliente=new Cliente(1,"1719432274","Juan","Perez","Tumbaco","2056351","jperez@gmail.com");
       libro=new Libro(1,"Corazon","Vernaza",200,"2025","español","19/01/2025","anatomia","nueva","2025",120,"nueva","virtual",10.50,categoria,autor);
       factura= new Factura(1,cliente,10.00,1.50,11.50,new Date(),"FAC-001");

        facturaDetalle= new FacturaDetalle();
        facturaDetalle.setIdFacDetalle(1);
        facturaDetalle.setCantidad(10);
        facturaDetalle.setSubtotal(12.00);

        //inyecccion de dependencias
        facturaDetalle.setLibro(libro);
        facturaDetalle.setFactura(factura);
    }
    @Test

    public void facturaDetalleTestConstructor(){
        assertAll("Validar Constructor - FacturaDetalle",
                ()->assertEquals(1,facturaDetalle.getIdFacDetalle()),
                ()->assertEquals(10,facturaDetalle.getCantidad()),
                ()->assertEquals(12.00,facturaDetalle.getSubtotal())
                );
    }

    @Test

    public void facturaDetalleTestSetters(){
        categoria =new Categoria(2,"terror","casos reales");
        autor=new Autor(2,"Luis","Perez","Ecuador","Quito","0990464221","lperez@gmail.com");
        cliente=new Cliente(2,"1719432274","Juan","Perez","Tumbaco","2056351","jperez@gmail.com");
        libro=new Libro(2,"Corazon","Vernaza",200,"2025","español","19/01/2025","anatomia","nueva","2025",120,"nueva","virtual",10.50,categoria,autor);
        factura= new Factura(2,cliente,10.00,1.50,11.50,new Date(),"FAC-001");

        facturaDetalle.setIdFacDetalle(2);
        facturaDetalle.setCantidad(20);
        facturaDetalle.setSubtotal(15.00);
        facturaDetalle.setLibro(libro);
        facturaDetalle.setFactura(factura);

        assertAll("Validar Setters - FacturaDetalle",
                ()->assertEquals(2,facturaDetalle.getIdFacDetalle()),
                ()->assertEquals(20,facturaDetalle.getCantidad()),
                ()->assertEquals(15,facturaDetalle.getSubtotal()),
                ()->assertEquals("Corazon",facturaDetalle.getLibro().getTitulo()),
                ()->assertEquals(2,facturaDetalle.getFactura().getIdFactura())
        );

    }

    @Test
    public void facturaDetalleTestToSTring(){
        String str= facturaDetalle.toString();
        assertAll("Validar to String - FacturaDetalle",
                ()->assertTrue(str.contains("1")),
                ()->assertTrue(str.contains("10")),
                ()->assertTrue(str.contains("12.0"))

        );
    }
@Test
    public void facturaDetalleTestInyectores(){
    assertAll("Validar metodo Inyector -FacturaDetalle",
            ()->assertNotNull(facturaDetalle.getLibro()),
            ()-> assertEquals("Corazon",facturaDetalle.getLibro().getTitulo()),
            ()->assertNotNull(facturaDetalle.getFactura()),
            ()-> assertEquals("FAC-001",facturaDetalle.getFactura().getNumFactura())

    );
}


}
