/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.asignacionCubiculo.dto;

import java.util.Calendar;

/**
 *
 * @author DESARROLLO
 */
public class AsignacionCubiculoDTO {

    private Long id;
    private Long idPersona;
    private String nombrePersona;
    private Long idCubiculo;
    private String cubiculo;
    private Calendar fechaAsignado;
    private Calendar fechaDesasignado;
    private boolean disponible;
    private boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public Long getIdCubiculo() {
        return idCubiculo;
    }

    public void setIdCubiculo(Long idCubiculo) {
        this.idCubiculo = idCubiculo;
    }

    public String getCubiculo() {
        return cubiculo;
    }

    public void setCubiculo(String cubiculo) {
        this.cubiculo = cubiculo;
    }

    public Calendar getFechaAsignado() {
        return fechaAsignado;
    }

    public void setFechaAsignado(Calendar fechaAsignado) {
        this.fechaAsignado = fechaAsignado;
    }

    public Calendar getFechaDesasignado() {
        return fechaDesasignado;
    }

    public void setFechaDesasignado(Calendar fechaDesasignado) {
        this.fechaDesasignado = fechaDesasignado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
