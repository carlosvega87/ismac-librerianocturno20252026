package com.distribuida.principal;

import com.distribuida.beans.*;

import java.util.Date;

public class FacturaDetallePrincipal {
    public static void main(String[] args){
        Cliente cliente = new Cliente(1,"1719432275","Luis","Jara","Pifo","099042415","ljara@hotmail.com");
        Categoria categoria= new Categoria(1,"historia","nuevo");
        Autor autor =new Autor(1,"Luis","Perez","Ecuador","Av.Interoceanica","2056345","lperez@gmail.com");

        Factura factura = new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        //inyeccion de dependencias
        factura.setCliente(cliente);


        Libro libro= new Libro();
        libro.setIdlibro(1);
        libro.setTitulo("LA Nada");
        libro.setEditorial("Conejo");
        libro.setNumPaginas(200);
        libro.setEdicion("1");
        libro.setIdioma("Español");
        libro.setFechaPublicacion("1/01/2025");
        libro.setDescripcion("nuevo");
        libro.setTipoPasta("nueva");
        libro.setIsbn("2025");
        libro.setNumEjemplares(200);
        libro.setPortada("blanca");
        libro.setPresentacion("pequeña");
        libro.setPrecio(12.50);

        FacturaDetalle facturaDetalle = new FacturaDetalle();
        facturaDetalle.setIdFacDetalle(1);
        facturaDetalle.setCantidad(10);
        facturaDetalle.setSubtotal(10.20);

        facturaDetalle.setFactura(factura);
        facturaDetalle.setLibro(libro);
        System.out.println(facturaDetalle.toString());



    }
}

