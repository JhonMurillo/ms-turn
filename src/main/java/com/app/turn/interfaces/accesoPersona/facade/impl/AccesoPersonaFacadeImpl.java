/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.accesoPersona.facade.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
import com.app.turn.interfaces.accesoPersona.facade.AccesoPersonaFacade;
import com.app.turn.interfaces.accesoPersona.service.AccesoPersonaService;
import com.app.turn.utils.ObjectMapperUtil;

/**
 *
 * @author DESARROLLO
 */
@Component("AccesoPersonaFacade")
@Transactional
public class AccesoPersonaFacadeImpl implements AccesoPersonaFacade {

    @Autowired
    AccesoPersonaService accesoPersonaService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

}
