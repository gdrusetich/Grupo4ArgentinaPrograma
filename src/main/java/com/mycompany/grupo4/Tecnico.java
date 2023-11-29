/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author German
 */
@Entity
        @Table(name = "tecnico")
class Tecnico implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_tecnico", unique=true)
    private int id_tecnico;
    
    @Column(name = "nombreApellido", nullable = false)
    private String nombreApellido;
   
    @Transient
   private ArrayList<Orden> listaDeOrdenes = new ArrayList<>();

    public Tecnico(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
        public Tecnico() {}

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

}
