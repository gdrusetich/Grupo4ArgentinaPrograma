/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

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
@Table (name = "cliente")
public class Cliente {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "id_orden", unique = true)
    private int id_orden;
        
        @Column(name = "dni", nullable = false)
    private String dni;
        
        @Column(name = "nombre", nullable = false)
    private String nombre;
        
        @Column(name = "direccion", nullable = false)
    private String direccion;
        
        @Column(name = "mail", nullable = false)
    private String mail;
        
        @Transient
    private ArrayList<Orden> listaDeOrdenes = new ArrayList<>();
    
    public Cliente(String dni, String nombre, String direccion, String email){
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.mail = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Orden> getListaDeOrdenes() {
        return listaDeOrdenes;
    }

    public void setListaDeOrdenes(ArrayList<Orden> listaDeOrdenes) {
        this.listaDeOrdenes = listaDeOrdenes;
    }
    
    public void agregarOrden(Orden orden){
        this.listaDeOrdenes.add(orden);
    }
    
    
}
