/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.login.dto;

/**
 *
 * @author DESARROLLO
 */
public class LogoutDTO {

    private Long idAccesoPersona;
    private Long idPersona;
    private String token;

    public LogoutDTO() {
    }

    public LogoutDTO(Long idAccesoPersona, Long idPersona, String token) {
        this.idAccesoPersona = idAccesoPersona;
        this.idPersona = idPersona;
        this.token = token;
    }

    public Long getIdAccesoPersona() {
        return idAccesoPersona;
    }

    public void setIdAccesoPersona(Long idAccesoPersona) {
        this.idAccesoPersona = idAccesoPersona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
