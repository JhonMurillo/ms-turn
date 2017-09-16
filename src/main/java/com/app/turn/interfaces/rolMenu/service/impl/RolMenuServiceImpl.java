/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rolMenu.service.impl;

import com.app.turn.dominio.rolMenu.RolMenu;
import com.app.turn.dominio.rolMenu.RolMenuRepository;
import com.app.turn.interfaces.rolMenu.service.RolMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("RolMenuService")
@Service
public class RolMenuServiceImpl implements RolMenuService {

    @Autowired
    RolMenuRepository rolMenuRepository;

    @Override
    public RolMenu findById(Long id) {
        return rolMenuRepository.findOne(id);
    }

    @Override
    public RolMenu save(RolMenu rolMenu) {
        return rolMenuRepository.save(rolMenu);
    }

    @Override
    public List<RolMenu> findByIdRolAndEstado(Long idRol, boolean estado) {
        return rolMenuRepository.findByIdRolAndEstado(idRol, estado);
    }

}
