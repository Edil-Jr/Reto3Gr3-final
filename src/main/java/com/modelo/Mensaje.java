/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author adminjunior
 */
@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mensaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
   
    @Column (nullable = false, length = 45)
    private String messageText;
    
     @ManyToOne
    @JoinColumn(name="id")
    @JsonIgnoreProperties({"messages", "client","reservations" })
     private Cabin cabin;
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "reservations","client"})
     private Cliente client;
     
}
