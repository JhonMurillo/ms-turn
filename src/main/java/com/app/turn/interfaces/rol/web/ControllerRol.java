/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.rol.web;

import com.app.turn.interfaces.rol.dto.RolDTO;
import com.app.turn.interfaces.rol.facade.RolFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/Rol")
@Api(value = "Rol RestController", description = "This API has a CRUD for Rol")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerRol {

    @Autowired
    RolFacade rolFacade;


    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return All RolDTO")
    public List<RolDTO> findAll() {
        return rolFacade.findAll();
    }

}