/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.cubiculo.service;

import com.app.turn.dominio.cubiculo.Cubiculo;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface CubiculoService {

    List<Cubiculo> findAll();

    Cubiculo findById(Long id);
}
