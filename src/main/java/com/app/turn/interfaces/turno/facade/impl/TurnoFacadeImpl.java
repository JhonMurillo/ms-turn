/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.facade.impl;

import com.app.turn.dominio.turno.Turno;
import com.app.turn.interfaces.asignacionCubiculo.service.AsignacionCubiculoService;
import com.app.turn.dominio.asignacionCubiculo.AsignacionCubiculo;
import com.app.turn.interfaces.cubiculo.service.CubiculoService;
import com.app.turn.interfaces.persona.facade.impl.PersonaFacadeImpl;
import com.app.turn.interfaces.persona.service.PersonaService;
import com.app.turn.interfaces.turno.dto.TurnoDTO;
import com.app.turn.interfaces.turno.facade.TurnoFacade;
import com.app.turn.interfaces.turno.service.TurnoService;
import com.app.turn.utils.ConstanteUtil;
import com.app.turn.utils.ObjectMapperUtil;
import com.app.turn.utils.ResponseUtil;
import com.app.turn.websocket.SocketHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author DESARROLLO
 */
@Component("TurnoFacade")
public class TurnoFacadeImpl implements TurnoFacade {

    @Autowired
    TurnoService turnoService;
    @Autowired
    AsignacionCubiculoService asignacionCubiculoService;
    @Autowired
    CubiculoService cubiculoService;
    @Autowired
    PersonaService personaService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<TurnoDTO> findAll() {
        return convertListDTOs(turnoService.findAll());
    }

    @Override
    public ResponseUtil save(TurnoDTO turnoDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            AsignacionCubiculo asignacionCubiculo = asignacionCubiculoService.findById(turnoDTO.getIdAsignacionCubiculo());
            if (!asignacionCubiculo.disponible() || !asignacionCubiculo.estado()) {
                responseUtil.setTipo(ConstanteUtil.CODE_OK);
                responseUtil.setMessage(ConstanteUtil.CUBICULO_NO_DISPONIBLE);
                return responseUtil;
            }
            Long idMaxTurno = turnoService.findMaxIdAsigacionCubiculo(turnoDTO.getIdAsignacionCubiculo());
            Integer numero = 1;
            if (idMaxTurno != null) {
                Turno turnoAnterior = turnoService.findById(idMaxTurno);
                numero = Integer.parseInt(turnoAnterior.numero()) + 1;
            }
            turnoDTO.setNumero(String.valueOf(numero));
            turnoDTO.setFechaTurno(new GregorianCalendar());
            Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
            turnoService.save(turno);
            TurnoDTO dTO = objectMapper.convertValue(turno, TurnoDTO.class);
            dTO.setNombrePersona(personaService.findById(turno.idPersona()).nombre());
            dTO.setNombreAsesor(personaService.findById(asignacionCubiculo.idPersona()).nombre());
            dTO.setNombreCubiculo(cubiculoService.findById(asignacionCubiculo.idCubiculo()).nombre());
            dTO.setAtend(turno.atendido() == true ? "ATENDIDO" : "NO ATENDIDO");
            SocketHandler socketHandler = new SocketHandler();
            List<WebSocketSession> sessions = socketHandler.sessions;
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(dTO);
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

    @Override
    public ResponseUtil actualizarTurno(TurnoDTO turnoDTO) {
        ResponseUtil responseUtil = new ResponseUtil();
        try {
            Turno turno = objectMapper.convertValue(turnoDTO, Turno.class);
            turnoService.save(turno);
            TurnoDTO dTO = objectMapper.convertValue(turno, TurnoDTO.class);
            AsignacionCubiculo asignacionCubiculo = asignacionCubiculoService.findById(turnoDTO.getIdAsignacionCubiculo());
            dTO.setNombrePersona(personaService.findById(turno.idPersona()).nombre());
            dTO.setNombreAsesor(personaService.findById(asignacionCubiculo.idPersona()).nombre());
            dTO.setNombreCubiculo(cubiculoService.findById(asignacionCubiculo.idCubiculo()).nombre());
            dTO.setAtend(turno.atendido() == true ? "ATENDIDO" : "NO ATENDIDO");
            responseUtil.setTipo(ConstanteUtil.CODE_OK);
            responseUtil.setMessage(ConstanteUtil.MSG_EXITO);
            responseUtil.setObject(dTO);
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

    private List<TurnoDTO> convertListDTOs(List<Turno> listTurnos) {
        List<TurnoDTO> listaTurnoDTOs = new ArrayList<>();
        listTurnos.forEach((turno) -> {
            TurnoDTO turnoDTO = objectMapper.convertValue(turno, TurnoDTO.class);
            turnoDTO.setNombrePersona(personaService.findById(turno.idPersona()).nombre());

            AsignacionCubiculo asignacionCubiculo = asignacionCubiculoService.findById(turno.idAsignacionCubiculo());

            turnoDTO.setNombreAsesor(personaService.findById(asignacionCubiculo.idPersona()).nombre());
            turnoDTO.setNombreCubiculo(cubiculoService.findById(asignacionCubiculo.idCubiculo()).nombre());
            turnoDTO.setAtend(turno.atendido() == true ? "ATENDIDO" : "NO ATENDIDO");

            listaTurnoDTOs.add(turnoDTO);
        });
        return listaTurnoDTOs;
    }

}
