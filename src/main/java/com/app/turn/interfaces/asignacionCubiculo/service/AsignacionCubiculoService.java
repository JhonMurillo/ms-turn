/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.service;

import com.app.turn.dominio.asignacionCubiculo.AsignacionCubiculo;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface AsignacionCubiculoService {

    List<AsignacionCubiculo> findAll();

    AsignacionCubiculo save(AsignacionCubiculo asignacionCubiculo);
    
    AsignacionCubiculo findById(Long id);
}
