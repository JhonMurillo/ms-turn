/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.service.impl;

import com.app.turn.dominio.entidad.Entidad;
import com.app.turn.dominio.entidad.EntidadRepository;
import com.app.turn.interfaces.entidad.service.EntidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("EntidadService")
@Service
public class EntidadServiceImpl implements EntidadService {

    @Autowired
    EntidadRepository entidadRepository;

    @Override
    public Entidad save(Entidad entidad) {
        return entidadRepository.save(entidad);
    }

    @Override
    public Entidad findById(Long id) {
        return entidadRepository.findOne(id);
    }

    @Override
    public List<Entidad> findByEstado(boolean estado) {
        return entidadRepository.findByEstado(estado);
    }

    @Override
    public List<Entidad> findAll() {
        return (List<Entidad>) entidadRepository.findAll();
    }

}
