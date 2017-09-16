/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.cubiculo.service.impl;

import com.app.turn.dominio.cubiculo.Cubiculo;
import com.app.turn.dominio.cubiculo.CubiculoRepository;
import com.app.turn.interfaces.cubiculo.service.CubiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO
 */
@Component("CubiculoService")
@Service
public class CubiculoServiceImpl implements CubiculoService {
    
    @Autowired
    CubiculoRepository rolRepository;
    
    @Override
    public List<Cubiculo> findAll() {
        return (List<Cubiculo>) rolRepository.findAll();
    }
    
    @Override
    public Cubiculo findById(Long id) {
        return rolRepository.findOne(id);
    }
    
}
