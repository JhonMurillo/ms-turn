/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.service.impl;

import com.app.turn.dominio.asignacionCubiculo.AsignacionCubiculo;
import com.app.turn.dominio.asignacionCubiculo.AsignacionCubiculoRepository;
import com.app.turn.interfaces.asignacionCubiculo.service.AsignacionCubiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("AsignacionCubiculoService")
public class AsignacionCubiculoServiceImpl implements AsignacionCubiculoService {

    @Autowired
    AsignacionCubiculoRepository asignacionCubiculoRepository;

    @Override
    public List<AsignacionCubiculo> findAll() {
        return (List<AsignacionCubiculo>) asignacionCubiculoRepository.findAll();
    }

    @Override
    public AsignacionCubiculo save(AsignacionCubiculo asignacionCubiculo) {
        return asignacionCubiculoRepository.save(asignacionCubiculo);
    }

    @Override
    public AsignacionCubiculo findById(Long id) {
         return asignacionCubiculoRepository.findOne(id);
    }

}
