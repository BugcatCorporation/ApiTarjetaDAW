
package com.bugcat.apiTarjeta.dao;

import com.bugcat.apiTarjeta.entity.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TarjetaRepository extends JpaRepository<Tarjeta, Long>{
    
}
