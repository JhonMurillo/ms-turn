/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.facade;

import com.app.turn.interfaces.entidad.dto.EntidadDTO;
import com.app.turn.utils.ResponseUtil;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface EntidadFacade {

    ResponseUtil save(EntidadDTO entidadDTO);

    EntidadDTO findById(Long id);

    List<EntidadDTO> findByEstado(boolean estado);

    List<EntidadDTO> findAll();
}
