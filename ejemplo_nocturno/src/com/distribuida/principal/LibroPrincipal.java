package com.distribuida.principal;

import com.distribuida.beans.Autor;
import com.distribuida.beans.Categoria;
import com.distribuida.beans.Libro;

public class LibroPrincipal {
    public static  void main(String[] args){
        Autor autor =new Autor(1,"Luis","Perez","Ecuador","Av.Interoceanica","2056345","lperez@gmail.com");
        Categoria categoria= new Categoria(1,"historia","nuevo");


        Libro libro =new Libro();

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
        //inyeccion de dependencias
        libro.setCategoria(categoria);
        libro.setAutor(autor);
        System.out.println(libro.toString());
    }
}
