package com.distribuida.principal;

import com.distribuida.beans.Cliente;
import com.distribuida.beans.Factura;

import java.util.Date;

public class FacturaPrincipal {


    public static void main (String[] args){
        Cliente cliente = new Cliente(1,"1719432275","Luis","Jara","Pifo","099042415","ljara@hotmail.com");

        Factura factura=new Factura();
        factura.setIdFactura(1);
        factura.setNumFactura("FAC-0001");
        factura.setFecha(new Date());
        factura.setTotalNeto(100.00);
        factura.setIva(15.00);
        factura.setTotal(115.00);
        //inyeccion de dependencias
        factura.setCliente(cliente);

        System.out.println(factura.toString());
    }
}
