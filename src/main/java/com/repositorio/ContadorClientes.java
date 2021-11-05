/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositorio;

import com.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author adminjunior
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContadorClientes {
    private Long total;
    private Cliente client;
    
    
}
