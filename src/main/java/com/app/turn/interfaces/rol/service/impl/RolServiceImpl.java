/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rol.service.impl;

import com.app.turn.dominio.rol.Rol;
import com.app.turn.dominio.rol.RolRepository;
import com.app.turn.interfaces.rol.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("RolService")
@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

}
