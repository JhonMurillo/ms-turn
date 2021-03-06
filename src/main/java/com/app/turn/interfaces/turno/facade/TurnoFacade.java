/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.facade;

import com.app.turn.interfaces.turno.dto.TurnoDTO;
import com.app.turn.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface TurnoFacade {

    List<TurnoDTO> findAll();

    ResponseUtil save(TurnoDTO turnoDTO);

    ResponseUtil actualizarTurno(TurnoDTO turnoDTO);
}
