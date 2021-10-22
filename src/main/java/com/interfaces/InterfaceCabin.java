/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.interfaces;


import com.modelo.Cabin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Edilberto Holguin
 */
public interface InterfaceCabin extends CrudRepository<Cabin,Integer>{
    
}
