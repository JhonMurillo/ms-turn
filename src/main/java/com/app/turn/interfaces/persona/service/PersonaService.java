/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.persona.service;

import com.app.turn.dominio.persona.Persona;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface PersonaService {

    Persona save(Persona Persona);

    Persona findById(Long id);

    Persona findByEmail(String email);
    
    Persona findByIdentificacion(String identificacion);
    
}
