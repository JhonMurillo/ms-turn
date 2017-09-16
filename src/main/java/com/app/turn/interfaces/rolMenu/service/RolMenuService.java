/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rolMenu.service;

import com.app.turn.dominio.rolMenu.RolMenu;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface RolMenuService {

    RolMenu save(RolMenu rolMenu);

    RolMenu findById(Long id);

    List<RolMenu> findByIdRolAndEstado(Long idRol, boolean estado);
}
