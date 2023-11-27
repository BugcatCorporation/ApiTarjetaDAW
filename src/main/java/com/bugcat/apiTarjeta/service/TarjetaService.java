/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.bugcat.apiTarjeta.service;

import com.bugcat.apiTarjeta.entity.Tarjeta;
import java.util.List;

/**
 *
 * @author Nafet
 */
public interface TarjetaService {
    public List<Tarjeta> findAll();
    Tarjeta findById(Long id);
    Tarjeta add(Tarjeta tarjeta);
    Tarjeta update(Tarjeta tarjeta);
    public void delete(Long id);
}
