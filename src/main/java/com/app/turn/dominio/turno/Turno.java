/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.turno;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "turno")
@ApiModel("Model Turno")
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "numero", required = true)
    private String numero;
    @ApiModelProperty(value = "id_persona", required = true)
    private Long idPersona;
    @ApiModelProperty(value = "id_asignacion_cubiculo", required = true)
    private Long idAsignacionCubiculo;
    @ApiModelProperty(value = "the  fechaTurno", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaTurno;
    @ApiModelProperty(value = "the  fechaTurnoRetirado", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar fechaTurnoRetirado;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;
    @ApiModelProperty(value = "atendido", required = true)
    private boolean atendido;

    public Long id() {
        return id;
    }

    public String numero() {
        return numero;
    }

    public Long idPersona() {
        return idPersona;
    }

    public Long idAsignacionCubiculo() {
        return idAsignacionCubiculo;
    }

    public Calendar fechaTurno() {
        return fechaTurno;
    }

    public Calendar fechaTurnoRetirado() {
        return fechaTurnoRetirado;
    }

    public boolean estado() {
        return estado;
    }

    public boolean atendido() {
        return atendido;
    }

}
