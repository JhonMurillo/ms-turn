/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.facade.impl;

import com.app.turn.dominio.entidad.Entidad;
import com.app.turn.interfaces.entidad.dto.EntidadDTO;
import com.app.turn.interfaces.entidad.facade.EntidadFacade;
import com.app.turn.interfaces.entidad.service.EntidadService;
import com.app.turn.utils.ConstanteUtil;
import com.app.turn.utils.ObjectMapperUtil;
import com.app.turn.utils.ResponseUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@Component("EntidadFacade")
public class EntidadFacadeImpl implements EntidadFacade {

    @Autowired
    EntidadService entidadService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public ResponseUtil save(EntidadDTO entidadDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            Entidad entidad = objectMapper.convertValue(entidadDTO, Entidad.class);
            entidadService.save(entidad);
            EntidadDTO edto = objectMapper.convertValue(entidad, EntidadDTO.class);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(edto);
            return responseUtil;
        } catch (IllegalArgumentException p) {
            Logger.getLogger(EntidadFacadeImpl.class.getName()).log(Level.SEVERE, null, p);
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
    public EntidadDTO findById(Long id) {
        EntidadDTO entidadDTO = objectMapper.convertValue(entidadService.findById(id), EntidadDTO.class);
        return entidadDTO;
    }

    @Override
    public List<EntidadDTO> findByEstado(boolean estado) {
        return convertListDTO(entidadService.findByEstado(estado));
    }

    @Override
    public List<EntidadDTO> findAll() {
        return convertListDTO(entidadService.findAll());
    }

    public List<EntidadDTO> convertListDTO(List<Entidad> entidades) {
        List<EntidadDTO> entidadesDTO = new ArrayList<>();
        entidades.stream().map((entidad) -> {
            EntidadDTO entidadDTO = new EntidadDTO();
            entidadDTO.setId(entidad.id());
            entidadDTO.setDireccion(entidad.direccion());
            entidadDTO.setEstado(entidad.estado());
            entidadDTO.setLogo(entidad.logo());
            entidadDTO.setNombre(entidad.nombre());
            entidadDTO.setPaginaWeb(entidad.paginaWeb());
            entidadDTO.setTelefono(entidad.telefono());
            return entidadDTO;
        }).forEachOrdered((entidadDTO) -> {
            entidadesDTO.add(entidadDTO);
        });
        return entidadesDTO;
    }

}
