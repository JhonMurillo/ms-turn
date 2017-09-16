/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.web;

import com.app.turn.interfaces.asignacionCubiculo.dto.AsignacionCubiculoDTO;
import com.app.turn.interfaces.asignacionCubiculo.facade.AsignacionCubiculoFacade;
import com.app.turn.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DESARROLLO
 */
@RestController
@RequestMapping("/AsignacionCubiculo")
@Api(value = "Cubiculo RestController", description = "This API has a CRUD for AsignacionCubiculo")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerAsignacionCubiculo {

    @Autowired
    AsignacionCubiculoFacade asignacionCubiculoFacade;

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return All AsignacionCubiculoDTO")
    public List<AsignacionCubiculoDTO> findAll() {
        return asignacionCubiculoFacade.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save", notes = "Return ResponseUtil")
    public ResponseUtil save(@RequestBody @Valid List<AsignacionCubiculoDTO> asignacionCubiculoDTOs) {
        return asignacionCubiculoFacade.save(asignacionCubiculoDTOs);
    }
}
