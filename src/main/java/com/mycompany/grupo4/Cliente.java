/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.util.ArrayList;

/**
 *
 * @author German
 */
public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    private String mail;
    private ArrayList<Orden> listaDeOrdenes = new ArrayList<>();
    
    public Cliente(String dni, String nombre, String direccion, String email){
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = email;
    }
    
    public void ingresarOrden(String descripcion, Integer costo, Categoria categoria, Tecnico tecnico){
        Orden nuevaOrden = new Orden(descripcion, costo, this, categoria, tecnico);
        listaDeOrdenes.add(nuevaOrden);
    }
}
