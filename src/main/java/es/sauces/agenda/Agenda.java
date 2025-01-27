package es.sauces.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
*
* @author Usuario
* @version 3.0
*/

public class Agenda {

private final TreeSet<Contacto> contactos;
//El programa aconseja usar final aqui porque En ningún lugar del código se reasigna contactos a otra lista. 

    public Agenda() {
        contactos=new TreeSet<>();
    }

    /**
     * Se utiliza para crear un nuevo conatacto y añadirlo al TreeSet. En caso de que ya exista uno, non será creado
     * 
     * @param contacto
     * 
     * @return El valor de un nuevo contacto creado
     */
    public boolean crearContacto(Contacto contacto) {
        boolean contactoCreado = false;
        if(!contactos.contains(contacto)){
            contactos.add(contacto); // o salida=contactos.add(contacto) y return salida
        }
        else {
            return false;
        }
      return contactoCreado;
    }

    /**
     * 
     * @param nombre
     * @return Devuelve el contacto que el usuario está buscando. Devuelve el nombre, telefono y email que hayamos introducido en el momento en que lo creamos
     */
    public Contacto consultarContacto(String nombre) {
        // la c es la abreviatura de contacto. En este caso lo que se hace es que para cada contacto (c) de la lista de contactos, 
        //si cuando obtenemos el nombre nos devuelve uno igual al que hemos introducido, se devuelven todos los datos que tengamos almacenados del contacto a buscar
        for(Contacto c: contactos){
            if(c.getNombre().equals(nombre)){
                return c;
            }
        }
       return null;
    }

    /**
     * 
     * @param contacto
     * @return modifica los valores iniciales que tenia el contacto por los nuevos que ha introducido el usuario
     */
    public boolean modificarContacto(Contacto contacto) {
        boolean modificado = false;
        Contacto c;
        
        //comprobación de posibles errores, hay que verificar que no sea null
        if(contacto!=null){
            c=consultarContacto(contacto.getNombre());
            //aqui indica que si es el mismo contacto, que no cambie nada
            if(c!=null){
                c.setTelefono(contacto.getTelefono());
                c.setEmail(contacto.getEmail());
                modificado=true;
            }  
        }
        return modificado;
    }

    /**
     * 
     * @param nombre
     * @return elimina el contacto en caso de que lo hayamos confirmado
     */
    public boolean eliminarContacto(String nombre) {
        boolean contactoEliminado=false;
        Contacto contactoAEliminar=new Contacto(nombre);
        if(contactos.contains(contactoAEliminar)){
           contactos.remove(contactoAEliminar);
           contactoEliminado=true;
       }
       return contactoEliminado;
    }

    /**
     * 
     * @return 
     */
    public List<Contacto> listaContactos(){
        return new ArrayList<>(contactos);
    }

    /**
     * 
     * @return 
     * 
     */
    public int mostrarNumeroContactos(){
        return contactos.size();
    }   

}


/**
 * 
 * Si se emplea == es que tiene que ser IGUAL al que se ha facilitado, 
 * en cambio si utilizamos EQUALS tiene que ser equivalente a lo que estamos buscando
 *
 */