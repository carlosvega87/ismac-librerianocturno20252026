package com.distribuida.principal;

import com.distribuida.beans.Cliente;

public class ClientePincipal {

    public static  void main(String[] args){
        Cliente cliente = new Cliente(1,"1719432275","Luis","Jara","Pifo","099042415","ljara@hotmail.com");
System.out.println(cliente.toString());
    }
}
