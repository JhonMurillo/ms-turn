/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.web;

import com.app.turn.interfaces.turno.dto.TurnoDTO;
import com.app.turn.interfaces.turno.facade.TurnoFacade;
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
@RequestMapping("/Turno")
@Api(value = "Turno RestController", description = "This API has a CRUD for Turno")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerTurno {

    @Autowired
    TurnoFacade turnoFacade;

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return All TurnoDTO")
    public List<TurnoDTO> findAll() {
        return turnoFacade.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Turno", notes = "Return ResponseUtil")
    public ResponseUtil saveTurno(@RequestBody @Valid TurnoDTO turnoDTO) {
        return turnoFacade.save(turnoDTO);
    }

    @RequestMapping(value = "updateTurno", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Update Turno", notes = "Return ResponseUtil")
    public ResponseUtil updateTurno(@RequestBody @Valid TurnoDTO turnoDTO) {
        return turnoFacade.actualizarTurno(turnoDTO);
    }
}
