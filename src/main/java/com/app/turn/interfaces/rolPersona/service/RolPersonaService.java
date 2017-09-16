/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rolPersona.service;

import com.app.turn.dominio.rolPersona.RolPersona;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface RolPersonaService {

    RolPersona save(RolPersona rolPersona);

    RolPersona findById(Long id);

    RolPersona findByIdPersonaAndEstado(Long idPersona, boolean estado);

    RolPersona findByIdPersonaAndIdRolAndEstado(Long idPersona, Long idRol, boolean estado);

    List<RolPersona> findByIdRolAndEstado(Long idRol, boolean estado);
}
