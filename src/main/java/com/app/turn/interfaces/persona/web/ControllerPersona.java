/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.persona.web;

import com.app.turn.interfaces.persona.dto.PersonaDTO;
import com.app.turn.interfaces.persona.facade.PersonaFacade;
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
@RequestMapping("/Persona")
@Api(value = "Persona RestController", description = "This API has a CRUD for Persona")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ControllerPersona {

    @Autowired
    PersonaFacade PersonaFacade;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Save Persona", notes = "Return ResponseUtil")
    public ResponseUtil savePersona(@RequestBody @Valid PersonaDTO personDTO) {
        return PersonaFacade.save(personDTO);
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "findById/{id}", notes = "Return a PersonaDTO By id")
    public PersonaDTO findById(@PathVariable("id") Long id) {
        return PersonaFacade.findById(id);
    }

    @RequestMapping(value = "findByIdentificacion/{identificacion}", method = RequestMethod.GET)
    @ApiOperation(value = "findByIdentificacion/{identificacion}", notes = "Return a PersonaDTO By identificacion")
    public PersonaDTO findByIdentificacion(@PathVariable("id") String identificacion) {
        return PersonaFacade.findByIdentificacion(identificacion);
    }

    @RequestMapping(value = "findByRol/{rol}", method = RequestMethod.GET)
    @ApiOperation(value = "findByRol/{rol}", notes = "Return a PersonaDTO By rol")
    public List<PersonaDTO> findByRol(@PathVariable("id") String rol) {
        return PersonaFacade.findByRol(rol);
    }

}
