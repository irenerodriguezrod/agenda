/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.sauces.agenda;

/**
 *
 * @author ambrosio
 */
public class Agenda {

    private Contacto contacto;

    public boolean crearContacto(String nombre, String telefono, String email) {
        boolean contactoCreado = false;
        if (contacto == null) {
            contacto = new Contacto(nombre, telefono, email);
            contactoCreado = true;
        }
        return contactoCreado;
    }

    public Contacto consultarContacto(String nombre) {
        Contacto contacto = null;
        if (this.contacto != null && nombre.equals(this.contacto.getNombre())) {
            contacto = this.contacto;
        }
        return contacto;
    }

    public boolean modificarContacto(Contacto contacto) {
        boolean contactoModificado = false;
        if (contacto!= null && contacto.equals(this.contacto)) {
            this.contacto = contacto;
            contactoModificado = true;
        }
        return contactoModificado;
    }

    public boolean eliminarContacto(String nombre) {
        boolean contactoEliminado = false;
        if (contacto != null && nombre.equals(contacto.getNombre())) {
            contacto = null;
            contactoEliminado=true;            
        }
        return contactoEliminado;
    }
}
