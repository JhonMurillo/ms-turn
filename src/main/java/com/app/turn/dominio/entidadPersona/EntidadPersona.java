/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.entidadPersona;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "entidad_persona")
@ApiModel("Model EntidadPersona")
public class EntidadPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "idEntidad", required = true)
    private Long idEntidad;
    @ApiModelProperty(value = "idPersona", required = true)
    private Long idPersona;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public Long idEntidad() {
        return idEntidad;
    }

    public Long idPersona() {
        return idPersona;
    }

    public boolean estado() {
        return estado;
    }

}
