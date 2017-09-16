/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.dominio.cubiculo;

import com.app.turn.dominio.entidad.Entidad;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author DESARROLLO
 */
public interface CubiculoRepository extends CrudRepository<Cubiculo, Long> {

    /**
     *
     * @param nombre
     * @return
     */
    List<Entidad> findByNombre(String nombre);

    /**
     *
     * @param estado
     * @return
     */
    List<Entidad> findByEstado(boolean estado);
}
