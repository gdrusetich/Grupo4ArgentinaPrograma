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
}
