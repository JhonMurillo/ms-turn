/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rol.facade;

import com.app.turn.interfaces.rol.dto.RolDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface RolFacade {

    List<RolDTO> findAll();
}
