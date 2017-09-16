/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.persona.facade;

import com.app.turn.interfaces.persona.dto.PersonaDTO;
import com.app.turn.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PersonaFacade {

    ResponseUtil save(PersonaDTO PersonaDTO);

    PersonaDTO findById(Long id);

    PersonaDTO findByIdentificacion(String identificacion);

    List<PersonaDTO> findByRol(String rol);
}
