/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rol.facade.impl;

import com.app.turn.dominio.rol.Rol;
import com.app.turn.interfaces.rol.dto.RolDTO;
import com.app.turn.interfaces.rol.facade.RolFacade;
import com.app.turn.interfaces.rol.service.RolService;
import com.app.turn.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("RolFacade")
public class RolFacadeImpl implements RolFacade {

    @Autowired
    RolService rolService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<RolDTO> findAll() {
        return convertListDTOs(rolService.findAll());
    }

    private List<RolDTO> convertListDTOs(List<Rol> listRoles) {
        List<RolDTO> listaRolesDTOs = new ArrayList<>();
        listRoles.forEach((rol) -> {
            RolDTO rolDTO = objectMapper.convertValue(rol, RolDTO.class);
            listaRolesDTOs.add(rolDTO);
        });
        return listaRolesDTOs;
    }

}
