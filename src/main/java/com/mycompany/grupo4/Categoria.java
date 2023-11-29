/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author German
 */
@Entity
@Table(name = "categoria")
class Categoria implements Serializable{


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_categoria", unique = true)
    private int id_categoria;
    
    @Column(name = "descripcion_categoria")
    private String descripcion;

    public Categoria(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Categoria() {}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
        public int getId() {
        return id_categoria;
    }
    
}
