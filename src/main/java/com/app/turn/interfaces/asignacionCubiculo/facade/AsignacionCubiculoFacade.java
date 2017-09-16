/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.facade;

import com.app.turn.interfaces.asignacionCubiculo.dto.AsignacionCubiculoDTO;
import com.app.turn.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface AsignacionCubiculoFacade {

    List<AsignacionCubiculoDTO> findAll();

    ResponseUtil save(List<AsignacionCubiculoDTO> asignacionCubiculoDTOs);
}
