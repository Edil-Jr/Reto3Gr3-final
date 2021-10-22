/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interfaces;

import com.modelo.Reservacion;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author adminjunior
 */
public interface InterfaceReservas extends CrudRepository<Reservacion,Integer> {
    
}
