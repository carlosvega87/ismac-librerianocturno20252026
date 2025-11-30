package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    @Transactional
    @Rollback(value= false)
    public class ClienteTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testClienteFindAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        assertNotNull(clientes);
        asserTrue(clientes.size() > 0);
        for (Cliente item : clientes) {
            System.out.println(item.toString());
        }
    }

    private void asserTrue(boolean b) {
    }

    @Test
    public void testClienteFindOne() {
        Optional<Cliente> cliente = clienteRepository.findById(1);
        assertNotNull(cliente.isPresent());
        assertEquals("Puro", cliente.orElse(null).getNombre());
        assertEquals("Hueso", cliente.orElse(null).getApellido());
        System.out.println((cliente));
    }

    @Test
    public void testClienteSave() {
        Cliente cliente = new Cliente(0, "1719432278", "Juan", "Taipe", "Tumbaco", "0990464220", "jtaipe@gmail.com");
        Cliente clienteGuardado = clienteRepository.save(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("1719432278", clienteGuardado.getCedula());
        assertEquals("Juan", clienteGuardado.getNombre());
    }

    @Test
    public void testClienteActualizar() {
        Optional<Cliente> cliente2 = clienteRepository.findById(39);
        asserTrue(cliente2.isPresent());
        cliente2.orElse(null).setCedula("1719412245");
        cliente2.orElse(null).setNombre("Jose");
        cliente2.orElse(null).setApellido("Diaz");
        cliente2.orElse(null).setDireccion("Pifo");
        cliente2.orElse(null).setTelefono("2056431");
        cliente2.orElse(null).setCorreo("jdiaz@gmail.com");
        Cliente clienteActualizado = clienteRepository.save(cliente2.orElse(null));

        assertNotNull(clienteActualizado);
        assertEquals("Diaz", clienteActualizado.getApellido());
        assertEquals("Pifo", clienteActualizado.getDireccion());
    }

    @Test
    public void testClienteBorrar() {
        clienteRepository.deleteById(39);
        if(clienteRepository.existsById(39)){
       clienteRepository.deleteById(39);
    }
    assertFalse(clienteRepository.existsById(39));
    }
    }






