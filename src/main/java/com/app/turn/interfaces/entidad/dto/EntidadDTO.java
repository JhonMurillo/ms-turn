/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.entidad.dto;

/**
 *
 * @author DESARROLLO
 */
public class EntidadDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;
    private byte logo;
    private boolean estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public byte getLogo() {
        return logo;
    }

    public void setLogo(byte logo) {
        this.logo = logo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
