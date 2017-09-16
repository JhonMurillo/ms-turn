/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.rol;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface RolRepository extends CrudRepository<Rol, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    Rol findByNombre(String nombre);
}
