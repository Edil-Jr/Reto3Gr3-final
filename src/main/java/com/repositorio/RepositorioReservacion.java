/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositorio;


import com.interfaces.InterfaceReservas;
import com.modelo.Reservacion;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adminjunior
 */
@Repository
public class RepositorioReservacion {
    	      @Autowired
	    private InterfaceReservas crud4;
	
	    public List<Reservacion> getAll(){
	        return (List<Reservacion>) crud4.findAll();
	    }
	    public Optional<Reservacion> getReservacion(int id){
	        return crud4.findById(id);
	    }
	
	    public Reservacion save(Reservacion reservacion){
	        return crud4.save(reservacion);
	    }
	    public void delete(Reservacion reservacion){
	        crud4.delete(reservacion);
	    }
	}
