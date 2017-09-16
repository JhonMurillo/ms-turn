/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.persona;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    List<Persona> findByNombre(String nombre);

    /**
     *
     * @param estado
     * @return
     */
    List<Persona> findByEstado(boolean estado);

    /**
     *
     * @param identificacion
     * @return
     */
    Persona findByIdentificacion(String identificacion);

    /**
     *
     * @param email
     * @return
     */
    Persona findByEmail(String email);

}
