/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bugcat.apiTarjeta.service;

import com.bugcat.apiTarjeta.dao.TarjetaRepository;
import com.bugcat.apiTarjeta.entity.Tarjeta;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TarjetaServiceImpl implements TarjetaService{

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public List<Tarjeta> findAll() {
        log.info("Obteniendo todas las tarjetas.");
        return tarjetaRepository.findAll();
    }
    

    @Override
    public Tarjeta findById(Long id) {
        log.info("Obteniendo la tarjeta con el id {}", id);
        return tarjetaRepository.findById(id).get();
    }

    @Override
    public Tarjeta add(Tarjeta tarjeta) {
        log.info("Agregrando nueva tarjeta: {}", tarjeta);
        return tarjetaRepository.save(tarjeta);
    }

    @Override
    public Tarjeta update(Tarjeta tarjeta) {
        try{
            log.info("Actualizando tarjeta: {}", tarjeta);
            var tarjetaDB = tarjetaRepository.findById(tarjeta.getIdtarjeta()).get();
            tarjetaDB.setNroTarjeta(tarjeta.getNroTarjeta());
            tarjetaDB.setFechaCad(tarjeta.getFechaCad());
            tarjetaDB.setCcv(tarjeta.getCcv());
            return tarjetaRepository.save(tarjetaDB);
        } catch(Exception e){
            log.error("Error al actualizar tarjeta.", e);
            throw e;
        }   
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Eliminando tarjeta con ID: {}.", id);
            var tarjetaDB = tarjetaRepository.findById(id).orElse(null);
            if (tarjetaDB != null) {
                tarjetaRepository.delete(tarjetaDB);
            } else {
                log.warn("No se encontró ninguna tarjeta con ID: {}.", id);
            }
        } catch (Exception e) {
            log.error("Error al eliminar tarjeta.", e);
            throw e;
        }
    }
    


   
}
