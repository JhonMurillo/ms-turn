/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.asignacionCubiculo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "asignacion_cubiculo")
@ApiModel("Model Asignacion Cubiculo")
public class AsignacionCubiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  id_persona", required = true)
    private Long idPersona;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  id_cubiculo", required = true)
    private Long idCubiculo;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  loginDate", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaAsignado;
    @ApiModelProperty(value = "the  logoutDate", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaDesasignado;
    @ApiModelProperty(value = "disponible", required = true)
    private boolean disponible;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public Long idPersona() {
        return idPersona;
    }

    public Long idCubiculo() {
        return idCubiculo;
    }

    public Calendar fechaAsignado() {
        return fechaAsignado;
    }

    public Calendar fechaDesasignado() {
        return fechaDesasignado;
    }

    public boolean disponible() {
        return disponible;
    }

    public boolean estado() {
        return estado;
    }

}
