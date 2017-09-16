/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.rolPersona;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface RolPersonaRepository extends CrudRepository<RolPersona, Long> {

    RolPersona findByIdPersonaAndEstado(Long idPersona, boolean estado);

    RolPersona findByIdPersonaAndIdRolAndEstado(Long idPersona, Long idRol, boolean estado);

    List<RolPersona> findByIdRolAndEstado(Long idRol, boolean estado);
}
