package com.distribuida.controller;

import com.distribuida.model.FacturaDetalle;
import com.distribuida.service.FacturaDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/FacturaDetalle")
public class FacturaDetalleController {
    @Autowired
    private FacturaDetalleService facturaDetalleService;

    @GetMapping
    public ResponseEntity<List<FacturaDetalle>> findAll() {
        List<FacturaDetalle> FacturaDetalles = facturaDetalleService.findAll();
        return ResponseEntity.ok(FacturaDetalles);
    }
        @GetMapping("/{id}")
        public ResponseEntity<FacturaDetalle> findOne ( @PathVariable int id){
            Optional<FacturaDetalle> FacturaDetalle = facturaDetalleService.findOne(id);
            if (FacturaDetalle == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(FacturaDetalle.orElse(null));
        }

        @PostMapping
        public ResponseEntity<FacturaDetalle> save (@RequestBody FacturaDetalle facturaDetalle){
            FacturaDetalle FacturaDetalleNuevo = facturaDetalleService.save(facturaDetalle);
            return ResponseEntity.ok(FacturaDetalleNuevo);
        }
        @PutMapping("/{id}")
        public ResponseEntity<FacturaDetalle> update ( @PathVariable int id, @RequestBody FacturaDetalle facturaDetalle)
        {
            FacturaDetalle FacturaDetalleActualizado = facturaDetalleService.update(id, facturaDetalle);
            if (FacturaDetalleActualizado == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(FacturaDetalleActualizado);
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete ( @PathVariable int id){
            facturaDetalleService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }
