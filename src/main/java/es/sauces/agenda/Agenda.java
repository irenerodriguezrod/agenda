package es.sauces.agenda;
 
import java.util.ArrayList;

import java.util.LinkedList;

import java.util.List;

/**

*

* @author Usuario

*/

public class Agenda {

private final List<Contacto> contactos;

//El programa aconseja usar final aqui porque En ningún lugar del código se reasigna contactos a otra lista. 

//Lo único que haces es modificar el contenido de la lista (agregar, eliminar, etc.).
 
    public Agenda() {

        contactos=new LinkedList<>();

    }

    public boolean crearContacto(Contacto contacto) {

        boolean contactoCreado = false;

        if(!contactos.contains(contacto)){

            contactos.add(contacto); // o salida=contactos.add(contacto) y return salida

        }else {

        return false;

        }

      return contactoCreado;

    }

 
    public Contacto consultarContacto(String nombre) {

        Contacto contacto =null;

          int indice;

    indice=buscarContacto(nombre);

    if(indice!=-1){

     contacto=contactos.get(indice);

     contacto=new Contacto(contacto.getNombre(), contacto.getTelefono(), contacto.getEmail());

    }

       return contacto;

    }

    public boolean modificarContacto(Contacto contacto) {

         boolean contactoModificado = false;

         int indice;

         indice=buscarContacto(contacto.getNombre());

         if(indice!=-1){

         contactos.set(indice, contacto);

         }

        return contactoModificado;

    }

    public boolean eliminarContacto(String nombre) {

        boolean contactoEliminado=false;

        Contacto contactoAEliminar=new Contacto(nombre);

        if(contactos.contains(contactoAEliminar)){

           contactos.remove(contactoAEliminar);

           contactoEliminado=true;

       }

       return contactoEliminado;

    }

    public List<Contacto> listaContactos(){

    return new ArrayList<>(contactos);

    }

    public int mostrarNumeroContactos(){

    return contactos.size();

}   

    private int buscarContacto(String nombre){

     return contactos.indexOf(new Contacto(nombre));

    }

}