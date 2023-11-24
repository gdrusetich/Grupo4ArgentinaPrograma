/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo4;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author German
 */
public class Grupo4 {

    public static void main(String[] args) {
        
        /*
        RepositorioClientes repositorioClientes = new RepositorioClientes();
        RepositorioOrdenes repositorioOrdenes = new RepositorioOrdenes();

        */
        
        Grupo4 es = new Grupo4();
        /*  YA SE CREÓ UNA VEZ
                es.createAndStoreCliente("38388388", "Gianni", "Palermo", "gianni@gmail.com");
        es.createAndStoreCliente("18122022", "German", "VillaLugano", "german@gmail.com");
        es.createAndStoreCliente("30822822", "Leandro", "VillaOrtuzar", "Leandro@gmail.com");
        es.createAndStoreTecnico("Pablo Marmol");
        es.createAndStoreCategoria("Celular");
        HibernateUtil.getSessionFactory().close();*/


    }

    
    private void createAndStoreCliente(String dni, String nombre, String direccion, String email){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new Cliente(dni, nombre, direccion, email));
        session.getTransaction().commit();        
    }
    
        private void createAndStoreTecnico(String nombreApellido){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new Tecnico(nombreApellido));
        session.getTransaction().commit();        
    }
        
        private void createAndStoreCategoria(String descripcion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new Categoria(descripcion));
        session.getTransaction().commit();        
    }
        
        
    
    /*
    private void buscarCliente(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Cliente> result = (List<Cliente>)session.createQuery("from Cliente").list();
    for (Cliente evento : result)
    {System.out.println(evento.getNombre());
    }
    
    
    
    }  
    
    private void buscarCLiente2(){
               Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Cliente user = session.find(Cliente.class,4);
        if(user==null){
            System.out.println("no hay cliente");
        }
        
            
    }
    
        private void buscarCliente3(){
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
               Cliente user = session.find(Cliente.class,2);                   
        if(user=null){

        }
    
      */  
        
        
    }
    

    




