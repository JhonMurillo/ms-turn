/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.login.facade;

import com.app.turn.interfaces.login.dto.CredencialDTO;
import com.app.turn.interfaces.login.dto.LogoutDTO;
import com.app.turn.utils.ResponseUtil;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DESARROLLO 13
 */
public interface LoginFacade {

    public ResponseUtil login(CredencialDTO credentials, HttpServletRequest request);

    public ResponseUtil logout(LogoutDTO logoutDTO);

}
