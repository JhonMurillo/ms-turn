/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.turno;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface TurnoRepository extends CrudRepository<Turno, Long> {

    @Query(value = "select max(t.id) from turno t join asignacion_cubiculo ac on t.id_asignacion_cubiculo = ac.id where ac.id = 1 and t.estado = true and ac.estado = true;", nativeQuery = true)
    Long findMaxIdAsigacionCubiculo(Long idAsignacionCubiculo);
}
