/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.cubiculo;

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
@Table(name = "cubiculo")
@ApiModel("Model Cubiculo")
public class Cubiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public boolean estado() {
        return estado;
    }

}
