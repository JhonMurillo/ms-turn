/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.service.impl;

import com.app.turn.dominio.turno.Turno;
import com.app.turn.dominio.turno.TurnoRepository;
import com.app.turn.interfaces.turno.service.TurnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("TurnoService")
@Service
public class TurnoServiceImpl implements TurnoService {
    
    @Autowired
    TurnoRepository turnoRepository;
    
    @Override
    public List<Turno> findAll() {
        return (List<Turno>) turnoRepository.findAll();
    }
    
    @Override
    public Turno save(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Long findMaxIdAsigacionCubiculo(Long idAsignacionCubiculo) {
        return turnoRepository.findMaxIdAsigacionCubiculo(idAsignacionCubiculo);
    }

    @Override
    public Turno findById(Long id) {
        return turnoRepository.findOne(id);
    }
}
