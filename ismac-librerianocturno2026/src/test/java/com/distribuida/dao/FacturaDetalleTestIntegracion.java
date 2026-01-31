package com.distribuida.dao;

import com.distribuida.dao.FacturaDetalleRepository;
import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import com.distribuida.model.FacturaDetalle;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaDetalleTestIntegracion {
    @Autowired
    private FacturaDetalleRepository facturaDetalleRepository;
@Autowired
private FacturaRepository facturaRepository;
    @Test
    public void testFacturaDetalleFindAll() {
        List<FacturaDetalle> facturaDetalle = facturaDetalleRepository.findAll();
        assertNotNull(facturaDetalle);
        assertTrue(facturaDetalle.size() > 0);
        facturaDetalle.forEach(System.out::println);
    }
    @Test
    public void testFacturaDetalleFindOne(){
        Optional<FacturaDetalle> facturaDetalle = facturaDetalleRepository.findById(1);
        assertTrue(facturaDetalle.isPresent());
        assertEquals(2,facturaDetalle.orElse(null).getCantidad());
        assertEquals(30.84,facturaDetalle.orElse(null).getSubtotal());

        System.out.println(facturaDetalle);
    }
    @Test
    public void testFacturaDetalleSave(){
        Optional<Factura> factura = facturaRepository.findById(1);
        assertTrue(factura.isPresent());

        FacturaDetalle facturaDetalle1=new FacturaDetalle();
        facturaDetalle1.setIdFacDetalle(0);
        facturaDetalle1.setCantidad(2);
        facturaDetalle1.setSubtotal(12.50);
        facturaDetalle1.setFactura(factura.orElse(null));

        FacturaDetalle facturaDetalle1Guardada= facturaDetalleRepository.save(facturaDetalle1);
        assertNotNull(facturaDetalle1Guardada);
        assertEquals(2,facturaDetalle1Guardada.getCantidad());
        assertEquals(12.50, facturaDetalle1Guardada.getSubtotal());

    }
    @Test
    public void testFacturaDetalleUpdate() {
        Optional<Factura> factura = facturaRepository.findById(2);

        assertTrue(factura.isPresent());

        Optional<FacturaDetalle> facturaDetalle = facturaDetalleRepository.findById(206);

        assertTrue((facturaDetalle.isPresent()));


        facturaDetalle.orElse(null).setCantidad(2);

        facturaDetalle.orElse(null).setSubtotal(200.00);

        facturaDetalle.orElse(null).setFactura(factura.orElse(null));

        FacturaDetalle facturaDetalle1Actualizada = facturaDetalleRepository.save(facturaDetalle.orElse(null));
        assertNotNull(facturaDetalle1Actualizada);
        assertEquals(2, facturaDetalle1Actualizada.getCantidad());
        assertEquals(200.00, facturaDetalle1Actualizada.getSubtotal());
    }
    @Test
    public void testFacturaDetalleDelete(){
        if (facturaDetalleRepository.existsById(206)){
            facturaDetalleRepository.deleteById(206);
        }
        assertFalse(facturaDetalleRepository.existsById(206));
    }
}
