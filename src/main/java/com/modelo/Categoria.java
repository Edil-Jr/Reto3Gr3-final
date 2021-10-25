/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author adminjunior
 */    
@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (nullable = false, length = 45)
    private String name;
    @Column (nullable = false, length = 250)
    private String description;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="categoryId")
    @JsonIgnoreProperties("category")
    private List<Cabin> cabins;

  
    
    
}
