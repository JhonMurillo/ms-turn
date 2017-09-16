/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.facade.impl;

import com.app.turn.dominio.asignacionCubiculo.AsignacionCubiculo;
import com.app.turn.interfaces.asignacionCubiculo.dto.AsignacionCubiculoDTO;
import com.app.turn.interfaces.asignacionCubiculo.facade.AsignacionCubiculoFacade;
import com.app.turn.interfaces.asignacionCubiculo.service.AsignacionCubiculoService;
import com.app.turn.interfaces.cubiculo.service.CubiculoService;
import com.app.turn.interfaces.persona.facade.impl.PersonaFacadeImpl;
import com.app.turn.interfaces.persona.service.PersonaService;
import com.app.turn.utils.ConstanteUtil;
import com.app.turn.utils.ObjectMapperUtil;
import com.app.turn.utils.ResponseUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DESARROLLO
 */
@Component("AsignacionCubiculoFacade")
public class AsignacionCubiculoFacadeImpl implements AsignacionCubiculoFacade {

    @Autowired
    AsignacionCubiculoService asignacionCubiculoService;

    @Autowired
    PersonaService personaService;

    @Autowired
    CubiculoService cubiculoService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<AsignacionCubiculoDTO> findAll() {
        return convertListDTOs(asignacionCubiculoService.findAll());
    }

    @Override
    @Transactional
    public ResponseUtil save(List<AsignacionCubiculoDTO> asignacionCubiculoDTOs) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            List<AsignacionCubiculoDTO> listaAsignacionCubiculoDTO = new ArrayList<>();
            List<AsignacionCubiculo> listaAsignacionCubiculo = new ArrayList<>();
            asignacionCubiculoDTOs.stream().map((asignacionCubiculoDTO) -> objectMapper.convertValue(asignacionCubiculoDTO, AsignacionCubiculo.class)).forEachOrdered((asignacionCubiculo) -> {
                listaAsignacionCubiculo.add(asignacionCubiculoService.save(asignacionCubiculo));
            });
            listaAsignacionCubiculoDTO = convertListDTOs(listaAsignacionCubiculo);
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            try {
                responseUtil.setObjectResponse(objectMapper.readTree(objectMapper.writeValueAsString(listaAsignacionCubiculoDTO)));
            } catch (JsonProcessingException ex) {
                responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
                responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
                return responseUtil;
            } catch (IOException ex) {
                responseUtil.setTipo(ConstanteUtil.CODE_INTERNAL_ERROR);
                responseUtil.setMessage(ConstanteUtil.MSG_FALLIDO);
                return responseUtil;
            }
            return responseUtil;
        } catch (IllegalArgumentException p) {
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

    private List<AsignacionCubiculoDTO> convertListDTOs(List<AsignacionCubiculo> listAsignacionCubiculos) {
        List<AsignacionCubiculoDTO> listAsignacionCubiculoDTOs = new ArrayList<>();
        listAsignacionCubiculos.forEach((asignacionCubiculo) -> {
            AsignacionCubiculoDTO asignacionCubiculoDTO = objectMapper.convertValue(asignacionCubiculo, AsignacionCubiculoDTO.class);
            asignacionCubiculoDTO.setNombrePersona(personaService.findById(asignacionCubiculo.idPersona()).nombre());
            asignacionCubiculoDTO.setCubiculo(cubiculoService.findById(asignacionCubiculo.idCubiculo()).nombre());
            listAsignacionCubiculoDTOs.add(asignacionCubiculoDTO);
        });
        return listAsignacionCubiculoDTOs;
    }

}
