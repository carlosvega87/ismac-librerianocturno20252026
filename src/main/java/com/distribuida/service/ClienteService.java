package com.distribuida.service;

import com.distribuida.model.Cliente;

import java.util.List;


public interface ClienteService {

    public List<Cliente> findAll();
    public Cliente findOne( int id);
    public Cliente save( Cliente Cliente);
    public Cliente update (Cliente Cliente);
    public void delete (int id);

}
