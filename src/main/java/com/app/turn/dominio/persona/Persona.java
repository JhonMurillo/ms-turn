/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.persona;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "persona", uniqueConstraints
        = @UniqueConstraint(columnNames = "identificacion", name = "uk_identificacion")
)
@ApiModel("Model Persona")
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
    @ApiModelProperty(value = "nombre", required = true)
    private String nombre;
    @ApiModelProperty(value = "identificacion", required = true)
    private String identificacion;
    @ApiModelProperty(value = "direccion", required = true)
    private String direccion;
    @ApiModelProperty(value = "telefono", required = true)
    private String telefono;
    @ApiModelProperty(value = "email", required = true)
    private String email;
    @ApiModelProperty(value = "contrasenhia", required = true)
    private String contrasenhia;
    @ApiModelProperty(value = "estado", required = true)
    private boolean estado;

    public Long id() {
        return id;
    }

    public void id(Long id) {
        this.id = id;
    }

    public String nombre() {
        return nombre;
    }

    public void nombre(String nombre) {
        this.nombre = nombre;
    }

    public String identificacion() {
        return identificacion;
    }

    public void identificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String direccion() {
        return direccion;
    }

    public void direccion(String direccion) {
        this.direccion = direccion;
    }

    public String telefono() {
        return telefono;
    }

    public void telefono(String telefono) {
        this.telefono = telefono;
    }

    public String email() {
        return email;
    }

    public void email(String email) {
        this.email = email;
    }

    public String contrasenhia() {
        return contrasenhia;
    }

    public void contrasenhia(String contrasenhia) {
        this.contrasenhia = contrasenhia;
    }

    public boolean estado() {
        return estado;
    }

    public void estado(boolean estado) {
        this.estado = estado;
    }

}
