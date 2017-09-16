/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.accesoPersona.service.impl;

import com.app.turn.dominio.accesoPersona.AccesoPersona;
import com.app.turn.dominio.accesoPersona.AccesoPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.app.turn.interfaces.accesoPersona.service.AccesoPersonaService;
import com.app.turn.interfaces.login.dto.LogoutDTO;

/**
 *
 * @author DESARROLLO
 */
@Component("AccesoPersonaService")
@Service
public class AccesoPersonaServiceImpl implements AccesoPersonaService {

    @Autowired
    AccesoPersonaRepository accesoPersonaRepository;

    @Override
    public AccesoPersona save(AccesoPersona accesoPersona) {
        return accesoPersonaRepository.save(accesoPersona);
    }

    @Override
    public AccesoPersona findById(Long id) {
        return accesoPersonaRepository.findOne(id);
    }

    @Override
    public AccesoPersona findByIdPersona(Long idPersona) {
        return accesoPersonaRepository.findByIdPersona(idPersona);
    }

    @Override
    public AccesoPersona findByToken(String token) {
        return accesoPersonaRepository.findByToken(token);
    }

    @Override
    public List<AccesoPersona> findByStateLogin(String stateLogin) {
        return (List<AccesoPersona>) accesoPersonaRepository.findByStateLogin(stateLogin);
    }

    @Override
    public AccesoPersona findLogout(LogoutDTO logoutDTO, String stateLogin, String stateToken) {
        return accesoPersonaRepository.findLogout(logoutDTO.getIdAccesoPersona(), logoutDTO.getIdPersona(), logoutDTO.getToken(), stateLogin, stateToken);
    }

}
