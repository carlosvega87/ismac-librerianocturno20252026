package com.distribuida.principal;

import com.distribuida.beans.Autor;

public class AutorPrincipal {

    public static  void main(String[] args){
        Autor autor =new Autor(1,"Luis","Perez","Ecuador","Av.Interoceanica","2056345","lperez@gmail.com");


        System.out.println(autor.toString());
    }
}
