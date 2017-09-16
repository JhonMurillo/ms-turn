/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.web;

import com.app.turn.interfaces.entidad.dto.EntidadDTO;
import com.app.turn.interfaces.entidad.facade.EntidadFacade;
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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/Entidad")
@Api(value = "Entidad RestController", description = "This API has a CRUD for Entidad")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerEntidad {

    @Autowired
    EntidadFacade entidadFacade;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Entidad", notes = "Return ResponseUtil")
    public ResponseUtil saveEntidad(@RequestBody @Valid EntidadDTO entidadDTO) {
        return entidadFacade.save(entidadDTO);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a EntidadDTO By id")
    public EntidadDTO findById(@PathVariable("id") Long id) {
        return entidadFacade.findById(id);
    }

    @RequestMapping(value = "findByEstado/{estado}", method = RequestMethod.GET)
    @ApiOperation(value = "findByEstado/{estado}", notes = "Return a List of EntidadDTO By estado")
    public List<EntidadDTO> findByEstado(@PathVariable("estado") boolean estado) {
        return entidadFacade.findByEstado(estado);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    @ApiOperation(value = "findAll", notes = "Return a List of EntidadDTO")
    public List<EntidadDTO> findAll() {
        return entidadFacade.findAll();
    }
}
