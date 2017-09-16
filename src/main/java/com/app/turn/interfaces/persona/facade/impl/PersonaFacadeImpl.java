/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.persona.facade.impl;

import com.app.turn.dominio.persona.Persona;
import com.app.turn.dominio.rol.Rol;
import com.app.turn.dominio.rolPersona.RolPersona;
import com.app.turn.interfaces.persona.dto.PersonaDTO;
import com.app.turn.interfaces.persona.facade.PersonaFacade;
import com.app.turn.interfaces.persona.service.PersonaService;
import com.app.turn.interfaces.rol.service.RolService;
import com.app.turn.interfaces.rolPersona.dto.RolPersonaDTO;
import com.app.turn.interfaces.rolPersona.service.RolPersonaService;
import com.app.turn.utils.ConstanteUtil;
import com.app.turn.utils.ObjectMapperUtil;
import com.app.turn.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("PersonaFacade")
//@Transactional
public class PersonaFacadeImpl implements PersonaFacade {

    @Autowired
    PersonaService PersonaService;

    @Autowired
    RolPersonaService rolPersonaService;

    @Autowired
    RolService rolService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    /**
     *
     * @param PersonaDTO
     * @return
     */
    @Override
    public ResponseUtil save(PersonaDTO PersonaDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            RolPersonaDTO rolPersonaDTO = new RolPersonaDTO();
            rolPersonaDTO.setIdRol(PersonaDTO.getIdRol());
            PersonaDTO.setContrasenhia(com.app.turn.utils.Encrytacion.getMd5(PersonaDTO.getContrasenhia()));
            Persona Persona = objectMapper.convertValue(PersonaDTO, Persona.class);
            PersonaService.save(Persona);
            PersonaDTO = objectMapper.convertValue(Persona, PersonaDTO.class);
            rolPersonaDTO.setIdPersona(Persona.id());
            rolPersonaDTO.setEstado(true);
            RolPersona rolPersona = objectMapper.convertValue(rolPersonaDTO, RolPersona.class);
            rolPersonaService.save(rolPersona);
            PersonaDTO.setContrasenhia(null);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(PersonaDTO);
            return responseUtil;
        } catch (IllegalArgumentException | NoSuchAlgorithmException p) {
            Logger.getLogger(PersonaFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
        } catch (DataIntegrityViolationException da) {
            responseUtil.setMessage(da.getRootCause().getMessage());
            responseUtil.setTipo(ConstanteUtil.CODE_ERROR);
            return responseUtil;
        }
        responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
        responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
        return responseUtil;
    }

    @Override
    public PersonaDTO findById(Long id) {
        PersonaDTO PersonaDTO = objectMapper.convertValue(PersonaService.findById(id), PersonaDTO.class);
        return PersonaDTO;
    }

    @Override
    public PersonaDTO findByIdentificacion(String identificacion) {
        PersonaDTO PersonaDTO = objectMapper.convertValue(PersonaService.findByIdentificacion(identificacion), PersonaDTO.class);
        return PersonaDTO;
    }

    @Override
    public List<PersonaDTO> findByRol(String rol) {
        List<PersonaDTO> personaDTOs = new ArrayList<>();
        Rol rolD = rolService.findByNombre(rol);
        if (rolD == null) {
            return personaDTOs;
        }

        List<RolPersona> rolPersonas = rolPersonaService.findByIdRolAndEstado(rolD.id(), true);

        if (rolPersonas.isEmpty()) {
            return personaDTOs;
        }

        rolPersonas.forEach((rolPersona) -> {
            personaDTOs.add(objectMapper.convertValue(PersonaService.findById(rolPersona.idPersona()), PersonaDTO.class));
        });
        return personaDTOs;
    }

}
