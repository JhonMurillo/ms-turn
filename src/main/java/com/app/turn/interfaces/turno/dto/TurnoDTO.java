/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.turno.dto;

import java.util.Calendar;

/**
 *
 * @author DESARROLLO
 */
public class TurnoDTO {

    private Long id;
    private String numero;
    private Long idPersona;
    private String nombrePersona;
    private Long idAsignacionCubiculo;
    private String nombreCubiculo;
    private String nombreAsesor;
    private Calendar fechaTurno;
    private Calendar fechaTurnoRetirado;
    private boolean estado;
    private boolean atendido;
    private String atend;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Long getIdAsignacionCubiculo() {
        return idAsignacionCubiculo;
    }

    public void setIdAsignacionCubiculo(Long idAsignacionCubiculo) {
        this.idAsignacionCubiculo = idAsignacionCubiculo;
    }

    public String getNombreCubiculo() {
        return nombreCubiculo;
    }

    public void setNombreCubiculo(String nombreCubiculo) {
        this.nombreCubiculo = nombreCubiculo;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public Calendar getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(Calendar fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public Calendar getFechaTurnoRetirado() {
        return fechaTurnoRetirado;
    }

    public void setFechaTurnoRetirado(Calendar fechaTurnoRetirado) {
        this.fechaTurnoRetirado = fechaTurnoRetirado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public String getAtend() {
        return atend;
    }

    public void setAtend(String atend) {
        this.atend = atend;
    }
    
    
}
