/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.login.dto;

import com.app.turn.dominio.menu.Menu;
import java.util.List;

/**
 *
 * @author DESARROLLO
 */
public class LoginDTO {

    private Long id;
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;
    private String contrasenhia;
    private String estado;
    private Long idAcessoPersona;
    private List<Menu> listaMenus;

    public LoginDTO() {
    }

    public LoginDTO(Long id, String nombre, String rut, String direccion, String telefono, String email, String contrasenhia, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasenhia = contrasenhia;
        this.estado = estado;
    }

    public LoginDTO(Long id, String nombre, String rut, String direccion, String telefono, String email, String contrasenhia, String estado, Long idAcessoPersona) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = rut;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.contrasenhia = contrasenhia;
        this.estado = estado;
        this.idAcessoPersona = idAcessoPersona;
    }

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

    public String getRut() {
        return identificacion;
    }

    public void setRut(String rut) {
        this.identificacion = rut;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenhia() {
        return contrasenhia;
    }

    public void setContrasenhia(String contrasenhia) {
        this.contrasenhia = contrasenhia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getIdAcessoPersona() {
        return idAcessoPersona;
    }

    public void setIdAcessoPersona(Long idAcessoPersona) {
        this.idAcessoPersona = idAcessoPersona;
    }

    public List<Menu> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menu> listaMenus) {
        this.listaMenus = listaMenus;
    }

}
