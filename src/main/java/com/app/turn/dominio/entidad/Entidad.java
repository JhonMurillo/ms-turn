/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.entidad;

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
@Table(name = "entidad")
@ApiModel("Model Entidad")
public class Entidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "direccion", required = true)
    private String direccion;
    @ApiModelProperty(value = "telefono", required = true)
    private String telefono;
    @ApiModelProperty(value = "pagina_web", required = true)
    private String paginaWeb;
    @ApiModelProperty(value = "logo", required = true)
    private byte logo;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public String nombre() {
        return nombre;
    }

    public String direccion() {
        return direccion;
    }

    public String telefono() {
        return telefono;
    }

    public String paginaWeb() {
        return paginaWeb;
    }

    public byte logo() {
        return logo;
    }

    public boolean estado() {
        return estado;
    }

}
