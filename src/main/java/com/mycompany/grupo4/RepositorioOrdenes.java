/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

/**
 *
 * @author German
 */
public class RepositorioOrdenes {
    private ArrayList<Orden> repoOrdenes = new ArrayList<Orden>();
    
/*  

    public ArrayList<Orden> quitarOrdenesAnteriores(Date unaFecha){   
    return (ArrayList<Orden>) repoOrdenes.stream().filter(orden->orden.getFechaOrden().before(unaFecha)).collect(Collectors.toList());
    }
    
    public ArrayList<Orden> quitarOrdenesPosteriores(Date unaFecha){
        return (ArrayList<Orden>) repoOrdenes.stream().filter(orden->orden.getFechaOrden().after(unaFecha)).collect(Collectors.toList());
    }
  
    public ArrayList<Orden> ordenesEntreLasFechas(Date primeraFecha, Date segundaFecha){
        return (ArrayList<Orden>) repoOrdenes.quitarOrdenesAnteriores(primeraFecha);
    }
  */  
    public ArrayList<Orden> ordenesEntre(Date primeraFecha, Date segundaFecha){
        return (ArrayList<Orden>) repoOrdenes.stream().filter(orden->orden.getFechaOrden().after(primeraFecha)).
        filter(orden->orden.getFechaOrden().before(segundaFecha)).collect(Collectors.toList());
    }
    
    
}
