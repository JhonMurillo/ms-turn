/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.cubiculo.facade.impl;


import com.app.turn.dominio.cubiculo.Cubiculo;
import com.app.turn.interfaces.cubiculo.dto.CubiculoDTO;
import com.app.turn.interfaces.cubiculo.facade.CubiculoFacade;
import com.app.turn.interfaces.cubiculo.service.CubiculoService;
import com.app.turn.utils.ObjectMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author DESARROLLO
 */
@Component("CubiculoFacade")
public class CubiculoFacadeImpl implements CubiculoFacade {

    @Autowired
    CubiculoService cubiculoService;

    public ObjectMapper objectMapper = ObjectMapperUtil.getInstanceObjectMapper();

    @Override
    public List<CubiculoDTO> findAll() {
        return convertListDTOs(cubiculoService.findAll());
    }

    private List<CubiculoDTO> convertListDTOs(List<Cubiculo> listCubiculos) {
        List<CubiculoDTO> listaCubiculosDTOs = new ArrayList<>();
        listCubiculos.forEach((cubiculo) -> {
            CubiculoDTO rolDTO = objectMapper.convertValue(cubiculo, CubiculoDTO.class);
            listaCubiculosDTOs.add(rolDTO);
        });
        return listaCubiculosDTOs;
    }

}
