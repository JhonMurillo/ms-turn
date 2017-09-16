/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.menu;

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
@Table(name = "menu")
@ApiModel("Model Menu")
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "titulo", required = true)
    private String titulo;
    @ApiModelProperty(value = "color", required = true)
    private String color;
    @ApiModelProperty(value = "icono", required = true)
    private String icono;
    @ApiModelProperty(value = "path", required = true)
    private String path;
    @ApiModelProperty(value = "url", required = true)
    private String url;
    @ApiModelProperty(value = "controlador", required = true)
    private String controlador;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    /**
     * @return the id
     */
    public Long id() {
        return id;
    }

    /**
     * @return the nombre
     */
    public String nombre() {
        return nombre;
    }

    /**
     * @return the titulo
     */
    public String titulo() {
        return titulo;
    }

    /**
     * @return the color
     */
    public String color() {
        return color;
    }

    /**
     * @return the icono
     */
    public String icono() {
        return icono;
    }

    /**
     * @return the path
     */
    public String path() {
        return path;
    }

    /**
     * @return the url
     */
    public String url() {
        return url;
    }

    /**
     * @return the controlador
     */
    public String controlador() {
        return controlador;
    }

    /**
     * @return the estado
     */
    public boolean estado() {
        return estado;
    }

}
