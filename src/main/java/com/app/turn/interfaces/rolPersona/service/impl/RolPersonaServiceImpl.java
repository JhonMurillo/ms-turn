/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rolPersona.service.impl;

import com.app.turn.dominio.rolPersona.RolPersona;
import com.app.turn.dominio.rolPersona.RolPersonaRepository;
import com.app.turn.interfaces.rolPersona.service.RolPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("RolPersonaService")
@Service
public class RolPersonaServiceImpl implements RolPersonaService {

    @Autowired
    RolPersonaRepository rolPersonaRepository;

    @Override
    public RolPersona findById(Long id) {
        return rolPersonaRepository.findOne(id);
    }

    @Override
    public RolPersona save(RolPersona rolPersona) {
        return rolPersonaRepository.save(rolPersona);
    }

    @Override
    public RolPersona findByIdPersonaAndEstado(Long idPersona, boolean estado) {
        return rolPersonaRepository.findByIdPersonaAndEstado(idPersona, estado);
    }

    @Override
    public RolPersona findByIdPersonaAndIdRolAndEstado(Long idPersona, Long idRol, boolean estado) {
        return rolPersonaRepository.findByIdPersonaAndIdRolAndEstado(idPersona, idRol, estado);
    }

    @Override
    public List<RolPersona> findByIdRolAndEstado(Long idRol, boolean estado) {
        return rolPersonaRepository.findByIdRolAndEstado(idRol, estado);
    }

}
