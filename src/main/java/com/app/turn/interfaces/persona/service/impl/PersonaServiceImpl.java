/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.persona.service.impl;

import com.app.turn.dominio.persona.Persona;
import com.app.turn.dominio.persona.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.turn.interfaces.persona.service.PersonaService;

/**
 *
 * @author DESARROLLO
 */
@Component("PersonaService")
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository PersonaRepository;

    public List<Persona> findAll() {
        return (List<Persona>) PersonaRepository.findAll();
    }

    @Override
    public Persona save(Persona user) {
        return PersonaRepository.save(user);
    }

    @Override
    public Persona findById(Long id) {
        return PersonaRepository.findOne(id);
    }

    @Override
    public Persona findByEmail(String email) {
        return PersonaRepository.findByEmail(email);
    }

    @Override
    public Persona findByIdentificacion(String identificacion) {
        return PersonaRepository.findByIdentificacion(identificacion);
    }
}
