/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rol.service;

import com.app.turn.dominio.rol.Rol;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface RolService {

    List<Rol> findAll();

    Rol findByNombre(String nombre);
}
