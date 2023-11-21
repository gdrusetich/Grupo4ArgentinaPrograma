/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author German
 */
class Orden {
    String descripcion_orden;
    Integer costo;
    Date fechaOrden;
    Boolean estado;
    Cliente cliente;
    Categoria categoria;
    Tecnico tecnico;
    
    public Orden(String descripcion, Integer costo, Cliente cliente, Categoria categoria, Tecnico tecnico){
        this.descripcion_orden = descripcion;
        this.costo = costo;
        this.fechaOrden = new Date();
        this.estado = false;
        this.cliente = cliente;
        this.categoria = categoria;
        this.tecnico = tecnico;        
    }
//Getters
    public Date getFechaOrden()     {   return fechaOrden;}
    public Cliente getCliente()     {   return cliente;}
    public Categoria getCategoria() {   return categoria;}
    public Tecnico getTecnico()     {   return tecnico;}

    public void setDescripcion_orden(String descripcion_orden) {
        this.descripcion_orden = descripcion_orden;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    
}
