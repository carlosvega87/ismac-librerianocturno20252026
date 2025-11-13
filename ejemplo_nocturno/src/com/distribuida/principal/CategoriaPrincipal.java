package com.distribuida.principal;

import com.distribuida.beans.Categoria;

public class CategoriaPrincipal {
    public static  void main(String[] args){

        Categoria categoria= new Categoria(1,"historia","nuevo");


        System.out.println(categoria.toString());
    }
}
