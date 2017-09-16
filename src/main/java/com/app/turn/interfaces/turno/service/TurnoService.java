/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.service;

import com.app.turn.dominio.turno.Turno;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface TurnoService {

    List<Turno> findAll();

    Turno save(Turno turno);

    Long findMaxIdAsigacionCubiculo(Long idAsignacionCubiculo);

    Turno findById(Long id);

}
