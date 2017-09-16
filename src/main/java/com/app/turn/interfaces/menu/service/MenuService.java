/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.turn.interfaces.menu.service;

import com.app.turn.dominio.menu.Menu;

/**
 *
 * @author DESARROLLO
 */
public interface MenuService {

    Menu save(Menu rolMenu);

    Menu findById(Long id);
}
