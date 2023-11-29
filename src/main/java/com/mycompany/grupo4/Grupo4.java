/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo4;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author German
 */
public class Grupo4 {

    public static void main(String[] args) {
              
        Grupo4 es = new Grupo4();
        //es.ingresarOrden();
        es.listarOrdenesEntre();
        HibernateUtil.getSessionFactory().close();
    }

    
    private Cliente buscarCliente(String dniBuscado){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Cliente cliente = session.find(Cliente.class,dniBuscado);
        if(cliente==null){
            String nombreDelNuevoCliente = JOptionPane.showInputDialog(null, "Ingrese el nombre del cliente");
            String direccionDelNuevoCliente = JOptionPane.showInputDialog(null, "Ingrese la direccion del cliente");
            String emailDelNuevoCliente = JOptionPane.showInputDialog(null, "Ingrese el email del cliente");
            Cliente nuevoCliente = new Cliente(dniBuscado, nombreDelNuevoCliente, direccionDelNuevoCliente, emailDelNuevoCliente);
        //    session.beginTransaction();
            session.save(nuevoCliente);
            //session.getTransaction().commit();
            return nuevoCliente;             
        } else{ 
            //String nombreDeCliente = cliente.getNombre();
            //String direccionDeCliente = cliente.getDireccion();
            //String mail = cliente.getMail();
            //Cliente clienteRecuperado = new Cliente(dniBuscado, nombreDeCliente, direccionDeCliente, mail);
            //System.out.println(clienteRecuperado.getDni());
            //System.out.println(clienteRecuperado.getNombre());
            //System.out.println(clienteRecuperado.getDireccion());
            //System.out.println(clienteRecuperado.getMail());
            return cliente;
        }
    }
    
    private Categoria buscarCategoria(Integer idCategoria){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Categoria categoria = session.find(Categoria.class,idCategoria);
        return categoria;
    }
    
        private Tecnico buscarTecnico(Integer idTecnico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //session.beginTransaction();
        Tecnico tecnico = session.find(Tecnico.class,idTecnico);
        return tecnico;
    }
    

    private void ingresarOrden(){
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    //session.beginTransaction();
    String descripcionDeLaOrden = JOptionPane.showInputDialog(null, "Ingrese la Descripcion de la orden");
    Integer costoDeLaOrden = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el costo de la orden"));
    
    String dniDelCliente = JOptionPane.showInputDialog(null, "Ingrese el DNI del cliente");
    Cliente clienteDeOrdenNueva = this.buscarCliente(dniDelCliente);

    Integer idCategoria = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id de la categoria"));
    Categoria categoriaIngresada = this.buscarCategoria(idCategoria);
    
    Integer idTecnico =  Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id del tecnico"));
    Tecnico tecnicoIngresado = this.buscarTecnico(idTecnico);

    
    Orden nuevaOrden = new Orden(descripcionDeLaOrden, costoDeLaOrden, clienteDeOrdenNueva, categoriaIngresada, tecnicoIngresado);
    //session.beginTransaction();
    session.save(nuevaOrden);
    session.getTransaction().commit();
}
        
    private void listarOrdenesEntre(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        List<Orden> todasLasOrdenes = (List<Orden>)session.createQuery("from Orden").list();
        Integer añoPrimeraFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de la primera fecha"));
        Integer mesPrimeraFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la primera fecha"));
        Integer diaPrimeraFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de la primera fecha"));
        LocalDate primeraFecha = LocalDate.of(añoPrimeraFecha, mesPrimeraFecha, diaPrimeraFecha);
        Integer añoSegundaFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de la segunda fecha"));
        Integer mesSegundaFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes de la segunda fecha"));
        Integer diaSegundaFecha = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el día de la segunda fecha"));
        LocalDate SegundaFecha = LocalDate.of(añoSegundaFecha, mesSegundaFecha, diaSegundaFecha);
               
        List<Orden> ordenesFiltradas = this.ordenesEntre(todasLasOrdenes, primeraFecha, SegundaFecha);
        for(Orden unaOrden: ordenesFiltradas){
        System.out.println("Cliente :" + unaOrden.getCliente().getNombre() + "\n" + "Tecnico: " + unaOrden.getTecnico().getNombreApellido() + "\n" +
                "Fecha: " + unaOrden.getFechaOrden() + "\n" + "Descripción: " + unaOrden.getDescripcion());    
        } 
        //return this.ordenesEntre(todasLasOrdenes, fecha1, fecha2);
    }
    
        public List<Orden> ordenesEntre(List<Orden> todasLasOrdenes, LocalDate primeraFecha, LocalDate segundaFecha){
            
        return (List<Orden>) todasLasOrdenes.stream().filter(orden->orden.getFechaOrden().isAfter(primeraFecha)).
        filter(orden->orden.getFechaOrden().isBefore(segundaFecha)).collect(Collectors.toList());        
    }    
    /*
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
        private void createAndStoreOrden(String descripcion, Integer costo, Cliente cliente, Categoria categoria, Tecnico tecnico){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(new Orden(descripcion, costo, cliente, categoria, tecnico));
        session.getTransaction().commit();

        }
    */ 
    /*
    private void buscarCliente(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        List<Cliente> todosLosClientes = (List<Cliente>)session.createQuery("from Cliente").list();
        for (Cliente cliente : todosLosClientes)
        {
            System.out.println(cliente.getNombre());
        }
    }

        private void buscarCliente2(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        String dni = JOptionPane.showInputDialog(null, "Ingrese el dni del cliente: ");
        List<Cliente> result = (List<Cliente>)session.createQuery("from Cliente where dni =" + dni).list();
        for (Cliente clienteBuscado : result){
        System.out.println(clienteBuscado.getNombre());
        }
        }
        
                private void buscarClienteHibernate2(String dniClienteBuscado){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Cliente cliente = session.get(Cliente.class,dniClienteBuscado);
        if(cliente==null){
            System.out.println("no hay cliente");
        } else {
            System.out.println(cliente.getNombre());
        }            
    }
        
        private void buscarClienteCriteria(String dniBuscado){
            
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //Cliente cliente = session.get(Cliente.class,2);
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("dni"),dniBuscado));

        List<Cliente> todosLosClientes = session.createQuery(criteria).list();
        
        for(Cliente evento : todosLosClientes){
            System.out.println(evento.getNombre());
        }
    }
    */ 

}