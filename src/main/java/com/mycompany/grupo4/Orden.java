/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author German
 */
@Entity
        @Table(name = "orden")
class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden", unique = true)
    private int id_orden;
    
    @Column(name = "descripcion_orden", nullable = false)
    String descripcion;
    
    @Column(name = "costo", nullable = false)
    Integer costo;
    
    @Column(name = "fecha_orden", nullable = false)
    LocalDate fechaOrden;
    
    
    Estado estado;
    
    @ManyToOne(cascade  =CascadeType.ALL)
    @JoinColumn(name = "cliente_orden")
    Cliente cliente;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tecnico_orden")
    Tecnico tecnico;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_orden")
    Categoria categoria;

    
    public Orden(String descripcion, Integer costo, Cliente cliente, Categoria categoria, Tecnico tecnico){
        this.descripcion = descripcion;
        this.costo = costo;
        this.fechaOrden = LocalDate.now();
        this.estado = Estado.NoResuelto;
        this.cliente = cliente;
        this.categoria = categoria;
        this.tecnico = tecnico;  
        
    }
    public Orden(){}
    
//Getters
    public String getDescripcion()  {return descripcion;}
    public LocalDate getFechaOrden()     {   return fechaOrden;}
    public Cliente getCliente()     {   return cliente;}
    public Categoria getCategoria() {   return categoria;}
    public Tecnico getTecnico()     {   return tecnico;}

    public void setDescripcion_orden(String descripcion_orden) {
        this.descripcion = descripcion_orden;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setFechaOrden(LocalDate fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public void setEstado(Estado unEstado) {
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
    
    public void ingresarOrden(String descripcion, Integer costo, String dni, Categoria categoria, Tecnico tecnico){
//Si el cliente existe.
        
            
    }
}

