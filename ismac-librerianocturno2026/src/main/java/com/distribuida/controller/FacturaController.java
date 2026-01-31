package com.distribuida.controller;

import com.distribuida.model.Factura;
import com.distribuida.service.FacturaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @GetMapping
    public ResponseEntity<List<Factura>> findAll(){
        List<Factura> Facturas= facturaService.findAll();
        return ResponseEntity.ok(Facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> findOne (@PathVariable int id) {
        Optional<Factura> Factura = facturaService.findOne(id);
        if (Factura== null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Factura.orElse(null));
    }

    @PostMapping
    public  ResponseEntity<Factura> save(@RequestBody Factura factura){
        Factura FacturaNuevo=facturaService.save(factura);
        return  ResponseEntity.ok(FacturaNuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> update(@PathVariable int id , @RequestBody Factura factura){
        Factura FacturaActualizado = facturaService.update(id,factura);
        if( FacturaActualizado== null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(FacturaActualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id ){
        facturaService.delete(id);
        return ResponseEntity.noContent().build();

    }

}
