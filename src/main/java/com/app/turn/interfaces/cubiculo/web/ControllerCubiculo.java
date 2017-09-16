/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.cubiculo.web;

import com.app.turn.interfaces.cubiculo.dto.CubiculoDTO;
import com.app.turn.interfaces.cubiculo.facade.CubiculoFacade;
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
@RequestMapping("/Cubiculo")
@Api(value = "Cubiculo RestController", description = "This API has a CRUD for Cubiculo")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerCubiculo {

    @Autowired
    CubiculoFacade cubiculoFacade;


    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return All CubiculoDTO")
    public List<CubiculoDTO> findAll() {
        return cubiculoFacade.findAll();
    }

}