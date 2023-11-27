/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bugcat.apiTarjeta.controller;

import com.bugcat.apiTarjeta.entity.Tarjeta;
import com.bugcat.apiTarjeta.service.TarjetaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/tarjeta")
public class TarjetaController {
    
    @Autowired
    private TarjetaService tarjetaService;
    
    @GetMapping("findAll")
    public ResponseEntity<List<Tarjeta>> findAll() {
        try {
            log.info("Tarjetas obtenidas.");
            return new ResponseEntity<>(tarjetaService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todas las tarjetas.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("findById/{id}")
    public ResponseEntity<Tarjeta> findById(@PathVariable Long id) {
        try {
            log.info("Obteniendo tarjeta con ID: {}.", id);
            Tarjeta tarjeta = tarjetaService.findById(id);

            if (tarjeta != null) {
                return new ResponseEntity<>(tarjeta, HttpStatus.OK);
            } else {
                log.warn("No se encontró ninguna tarjeta con ID: {}.", id);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.error("Error al obtener tarjeta con ID: {}.", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PostMapping("add")
    public ResponseEntity<Tarjeta> add(@RequestBody Tarjeta tarjeta) {
        try {
            log.info("Tarjeta agregada.", tarjeta);
            return new ResponseEntity<>(tarjetaService.add(tarjeta), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nueva tarjeta: {}.", tarjeta, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update")
    public ResponseEntity<Tarjeta> update(@RequestBody Tarjeta tarjeta) {
        try {
            log.info("Tarjeta actualizada {}.", tarjeta);
            return new ResponseEntity<>(tarjetaService.update(tarjeta), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar tarjeta: {}.", tarjeta, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            log.info("Eliminando tarjeta con ID: {}.", id);
            tarjetaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Error al eliminar tarjeta con ID: {}.", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
