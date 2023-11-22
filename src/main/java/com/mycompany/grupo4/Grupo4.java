/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo4;

import org.hibernate.Session;

/**
 *
 * @author German
 */
public class Grupo4 {

    public static void main(String[] args) {
        Grupo4 es = new Grupo4();
        es.ejemplo();
    }
    
    public void ejemplo(){
        createAndStoreOrden("La Orden");
        HibernateUtil.getSessionFactory().close();
    }
    
    private void createAndStoreOrden(String title){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente clienteGerman = new Cliente("35255255", "Germán", "VillaLugano", "german@gmail.com");
        Categoria celular = new Categoria("Tecnico de celulares");
        Tecnico alfredoCelular = new Tecnico("Alfredo Montes");
        Orden theOrden = new Orden("Pantalla de celular rota", 15000, clienteGerman, celular, alfredoCelular);
        session.save(theOrden);
        session.getTransaction().commit();
    }
}
