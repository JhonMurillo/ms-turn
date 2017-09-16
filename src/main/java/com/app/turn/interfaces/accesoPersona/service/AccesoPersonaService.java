/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.accesoPersona.service;

import com.app.turn.dominio.accesoPersona.AccesoPersona;
import com.app.turn.interfaces.login.dto.LogoutDTO;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public interface AccesoPersonaService {

    AccesoPersona save(AccesoPersona accesoPersona);

    AccesoPersona findById(Long id);

    AccesoPersona findByIdPersona(Long idPersona);

    AccesoPersona findByToken(String token);

    List<AccesoPersona> findByStateLogin(String stateLogin);

    AccesoPersona findLogout(LogoutDTO logoutDTO, String stateLogin, String stateToken);

}
