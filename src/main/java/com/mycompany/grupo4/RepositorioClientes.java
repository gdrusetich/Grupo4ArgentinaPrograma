/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author German
 */
public class RepositorioClientes {
    private ArrayList<Cliente> repoClientes = new ArrayList<>();
    private static final RepositorioClientes instance = new RepositorioClientes();
 
    public static RepositorioClientes getInstance(){
        return instance;
    }
    //Agrega un Cliente al RepoCliente
            public void agregarUnCliente(Cliente unCliente){
            
        this.repoClientes.add(unCliente);
    }
    
    
    public Boolean validarCliente(String dni){
        return repoClientes.stream().map(cliente->cliente.getDni()).collect(Collectors.toList()).contains(dni);
    }
    
    public Cliente devolverClienteConDNI(String dni){
        return repoClientes.stream().filter(cliente -> cliente.getDni() == dni).collect(Collectors.toList()).get(0);
    }
    
    
}
