/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.accesoPersona;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface AccesoPersonaRepository extends CrudRepository<AccesoPersona, Long> {

    AccesoPersona findByToken(String token);
    
    AccesoPersona findByIdPersona(Long idPersona);

    List<AccesoPersona> findByStateLogin(String stateLogin);

    @Query(value = "SELECT * \n"
            + "FROM acceso_persona \n"
            + "WHERE id = ?1 \n"
            + "AND id_persona = ?2   \n"
            + "AND token = ?3 \n"
            + "AND state_login =  ?4 \n"
            + "AND state_token = ?5", nativeQuery = true)
    AccesoPersona findLogout(Long idUserAccess, Long idPersona, String token, String stateLogin, String stateToken);

}
