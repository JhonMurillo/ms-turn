/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.accesoPersona.web;

import io.swagger.annotations.Api;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.turn.interfaces.accesoPersona.facade.AccesoPersonaFacade;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/AccesoPersona")
@Api(value = "AccesoPersona RestController", description = "This API has a Methods for AccesoPersona")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerAccesoPersona {

    @Autowired
    AccesoPersonaFacade accesoPersonaFacade;

}
