/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.service;

import com.app.turn.dominio.entidad.Entidad;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface EntidadService {

    Entidad save(Entidad entidad);

    Entidad findById(Long id);

    List<Entidad> findByEstado(boolean estado);

    List<Entidad> findAll();
}
