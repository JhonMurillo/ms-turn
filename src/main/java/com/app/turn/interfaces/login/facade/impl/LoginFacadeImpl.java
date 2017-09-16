/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.login.facade.impl;

import com.app.turn.dominio.accesoPersona.AccesoPersona;
import com.app.turn.dominio.menu.Menu;
import com.app.turn.dominio.persona.Persona;
import com.app.turn.dominio.rolMenu.RolMenu;
import com.app.turn.dominio.rolPersona.RolPersona;
import com.app.turn.interfaces.accesoPersona.service.AccesoPersonaService;
import com.app.turn.interfaces.login.dto.CredencialDTO;
import com.app.turn.interfaces.login.dto.LoginDTO;
import com.app.turn.interfaces.login.dto.LogoutDTO;
import com.app.turn.interfaces.login.facade.LoginFacade;
import com.app.turn.interfaces.menu.service.MenuService;
import com.app.turn.interfaces.persona.service.PersonaService;
import com.app.turn.interfaces.rolMenu.service.RolMenuService;
import com.app.turn.interfaces.rolPersona.service.RolPersonaService;
import com.app.turn.utils.ConstanteUtil;
import com.app.turn.utils.ObjectMapperUtil;
import com.app.turn.utils.ResponseUtil;
import com.app.turn.utils.config.AuthUtils;
import com.app.turn.utils.config.PasswordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DESARROLLO 13
 */
@Service
public class LoginFacadeImpl implements LoginFacade {

    public final static Logger LOG = LoggerFactory.getLogger(LoginFacadeImpl.class);

    @Context
    HttpHeaders headers;

    @Autowired
    private AccesoPersonaService accesoPersonaService;

    @Autowired
    private PersonaService PersonaService;

    @Autowired
    private RolPersonaService rolPersonaService;

    @Autowired
    private RolMenuService rolMenuService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private AuthUtils authUtils;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil login(CredencialDTO credencialDTO, HttpServletRequest request) {
        ResponseUtil responseUtil = new ResponseUtil();
        AccesoPersona accesoPersona = new AccesoPersona();
        Persona Persona = new Persona();
        Persona c = new Persona();
        if (StringUtils.isEmpty(credencialDTO.getContrasenhia()) || StringUtils.isEmpty(credencialDTO.getEmail())) {
            responseUtil.setMessage(ConstanteUtil.MSG_ERROR_AUTENTICACION);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        c = PersonaService.findByEmail(credencialDTO.getEmail());
        if (c == null) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        Persona = PersonaService.findById(c.id());

        if (Persona != null && Persona.estado() == true) {
            boolean passok = PasswordService.equalsPassword(credencialDTO.getContrasenhia(), Persona.contrasenhia());
            if (passok) {

                RolPersona rolPersona = rolPersonaService.findByIdPersonaAndEstado(Persona.id(), true);
                
                if (rolPersona == null) {
                    responseUtil.setMessage(ConstanteUtil.MSG_USER_SIN_ROL);
                    responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
                    return responseUtil;
                }
                
                List<RolMenu> rolesMenu = rolMenuService.findByIdRolAndEstado(rolPersona.idRol(), true);
                LoginDTO loginDTO = new LoginDTO();

                

                if (rolesMenu.isEmpty()) {
                    responseUtil.setMessage(ConstanteUtil.MSG_ROL_NO_CONFIGURED);
                    responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
                    return responseUtil;
                }

                List<Menu> listaMenus = new ArrayList<>();
                rolesMenu.forEach((rolMenu) -> {
                    listaMenus.add(menuService.findById(rolMenu.idMenu()));
                });

                loginDTO = objectMapper.convertValue(Persona, LoginDTO.class);

                String tokenStr = authUtils.createLoginToken(request.getRemoteHost(), Persona);
                accesoPersona = new AccesoPersona(null,
                        Persona.id(),
                        ConstanteUtil.STATE_LOGIN,
                        tokenStr,
                        ConstanteUtil.STATE_INITIATED,
                        new GregorianCalendar(),
                        null);
                accesoPersonaService.save(accesoPersona);
                loginDTO.setListaMenus(listaMenus);
                loginDTO.setIdAcessoPersona(accesoPersona.id());
                responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
                responseUtil.setTipo(ConstanteUtil.CODE_OK);
                responseUtil.setToken(tokenStr);
                responseUtil.setObject(loginDTO);

//                try {
//                    responseUtil.setObjectResponse(objectMapper.readTree(objectMapper.writeValueAsString(loginDTO)));
//                } catch (JsonProcessingException ex) {
//                    LOG.warn("Error : " + ex);
//                } catch (IOException ex) {
//                    LOG.error("Error : " + ex);
//                }
                return responseUtil;
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_PASS_NO_VALIDAD);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            }
        } else {
            if (Persona == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_EXISTE);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            } else {
                responseUtil.setMessage(ConstanteUtil.MSG_NO_ACCESS);
                responseUtil.setTipo(ConstanteUtil.CODE_UNAUTHORIZED);
            }
        }

        return responseUtil;
    }

    @Override
    public ResponseUtil logout(LogoutDTO logoutDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            AccesoPersona accesoPersona = new AccesoPersona();
            accesoPersona = accesoPersonaService.findLogout(logoutDTO, ConstanteUtil.STATE_LOGIN, ConstanteUtil.STATE_INITIATED);
            if (accesoPersona == null) {
                responseUtil.setMessage(ConstanteUtil.MSG_USER_NO_LOGIN);
                responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
                return responseUtil;
            }
            accesoPersona = new AccesoPersona(accesoPersona.id(),
                    accesoPersona.idPersona(),
                    ConstanteUtil.STATE_LOGOUT,
                    accesoPersona.token(),
                    ConstanteUtil.STATE_EXPIRED,
                    accesoPersona.loginDate(),
                    new GregorianCalendar());
            accesoPersonaService.save(accesoPersona);
            responseUtil.setMessage(ConstanteUtil.MSG_USER_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            return responseUtil;
        } catch (Exception e) {
            responseUtil.setMessage(ConstanteUtil.MSG_USER_ERROR_LOGOUT);
            responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
            return responseUtil;
        }
    }

}
