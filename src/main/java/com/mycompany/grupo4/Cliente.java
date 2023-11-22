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
}
