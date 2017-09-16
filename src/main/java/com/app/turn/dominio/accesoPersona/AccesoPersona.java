/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.accesoPersona;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author DESARROLLO
 */
@Entity
@Table(name = "acceso_persona", uniqueConstraints
        = @UniqueConstraint(columnNames = "token", name = "uk_token")
)
@ApiModel("Model AccesoPersona")
public class AccesoPersona implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "the  id", required = true)
    private Long id;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  id_Persona", required = true)
    private Long idPersona;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  stateLogin", required = true)
    private String stateLogin;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  token", required = true)
    private String token;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  stateToken", required = true)
    private String stateToken;
    @Column(nullable = false)
    @ApiModelProperty(value = "the  loginDate", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar loginDate;
    @ApiModelProperty(value = "the  logoutDate", required = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Calendar logoutDate;

    public AccesoPersona() {
    }

    public AccesoPersona(Long id, Long idPersona, String stateLogin, String token, String stateToken, Calendar loginDate, Calendar logoutDate) {
        this.id = id;
        this.idPersona = idPersona;
        this.stateLogin = stateLogin;
        this.token = token;
        this.stateToken = stateToken;
        this.loginDate = loginDate;
        this.logoutDate = logoutDate;
    }

    public Long id() {
        return id;
    }

    public Long idPersona() {
        return idPersona;
    }

    public String stateLogin() {
        return stateLogin;
    }

    public String token() {
        return token;
    }

    public String stateToken() {
        return stateToken;
    }

    public Calendar loginDate() {
        return loginDate;
    }

    public Calendar logoutDate() {
        return logoutDate;
    }

}
