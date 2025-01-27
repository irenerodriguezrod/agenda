package es.sauces.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
*
* @author Usuario
* @version 3.0
*/

public class Agenda {

private Map<String,Contacto>contactos;

    public Agenda() {
        contactos=new TreeMap<>();
    }

    /**
     * Se utiliza para crear un nuevo conatacto y añadirlo al TreeSet. En caso de que ya exista uno, non será creado
     * 
     * @param contacto
     * 
     * @return El valor de un nuevo contacto creado
     */
    public boolean crearContacto(Contacto contacto) {
        //se comprueba que no sea un valor nulo y en caso de que no lo sea, crea uno nuevo. En caso de que exista, devuelve error
        if(contactos!=null){
            return contactos.putIfAbsent(contacto.getNombre(), contacto)==null;
        }
        return false;
    }

    /**
     * 
     * @param nombre
     * @return Devuelve el contacto que el usuario está buscando. Devuelve el nombre, telefono y email que hayamos introducido en el momento en que lo creamos
     */
    public Contacto consultarContacto(String nombre) {
        // se hace un get del nombre pq es la clave
        contactos.get(nombre);
        
        return null;
    }

    /**
     * 
     * @param contacto
     * @return modifica los valores iniciales que tenia el contacto por los nuevos que ha introducido el usuario
     */
    public boolean modificarContacto(Contacto contacto) {
        if(contacto!=null && contactos.get(contacto.getNombre())!=null){
            contactos.put(contacto.getNombre(), contacto);
            return true;
        }
        return false;
    }

    /**
     * 
     * @param nombre
     * @return elimina el contacto en caso de que lo hayamos confirmado
     */
    public boolean eliminarContacto(String nombre) {
        contactos.remove(nombre);
        return true;
    }

    /**
     * 
     * @return la lista de todos los contactos que tenemos 
     */
    public List<Contacto> listaContactos(){
        return new ArrayList<>(contactos.values());
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