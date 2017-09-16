/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.rolPersona;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
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
@Table(name = "rol_persona")
@ApiModel("Model RolPersona")
public class RolPersona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "idPersona", required = true)
    private Long idPersona;
    @ApiModelProperty(value = "idRol", required = true)
    private Long idRol;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public Long idPersona() {
        return idPersona;
    }

    public Long idRol() {
        return idRol;
    }

    public boolean estado() {
        return estado;
    }

}
