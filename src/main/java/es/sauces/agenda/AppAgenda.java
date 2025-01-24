/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.agenda;


import java.util.Scanner;

/**
 *
 * @author irene
 */
public class AppAgenda {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Contacto contacto = null;
        Agenda agenda;
        String nombre, telefono, email, seguro;
        int opcion;

        agenda = new Agenda();
        do {
            System.out.println("1.- Crear contacto");
            System.out.println("2.- Consultar contacto");
            System.out.println("3.- Modificar contacto");
            System.out.println("4.- Eliminar contacto");
            System.out.println("5.- Listar contactos.");
            System.out.println("6.- Mostrar número de contactos.");
            System.out.println("0.- Salir");
            System.out.print("Introduzca opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1 -> { // Crear contacto
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    System.out.print("Introduzca teléfono: ");
                    telefono = teclado.nextLine();
                    System.out.print("Introduzca email: ");
                    email = teclado.nextLine();
                    if (agenda.crearContacto(new Contacto(nombre, telefono, email))) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("No podemos crear el contacto");
                    }
                }
                
                case 2 -> { //Consultar contacto
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    contacto = agenda.consultarContacto(nombre);
                    if (contacto != null) {
                        System.out.println(contacto);
                    } else {
                        System.out.println("No existe un contacto con ese nombre.");
                    }
                }

                case 3 -> { // Modificar contacto
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    contacto = agenda.consultarContacto(nombre);
                    System.out.print("Introduzca teléfono: ");
                    telefono = teclado.nextLine();
                    System.out.print("Introduzca email: ");
                    email = teclado.nextLine();
                    contacto.setTelefono(telefono);
                    contacto.setEmail(email);

                    if (agenda.modificarContacto(contacto)) {
                        System.out.println("Contacto modificado: " + contacto);
                    } else {
                        System.out.println("No se ha podido modificar el contacto");
                    }
                }

                case 4 -> { // Eliminar contacto
                    System.out.print("Seguro (S/N)? ");
                    seguro = teclado.nextLine(); // Seguuro es para verificar la eliminación(S/N)
                    if (seguro.equals("S")) {
                        if (agenda.eliminarContacto(nombre)) {
                            System.out.println("Contacto eliminado");
                        } else {
                            System.out.println("No se ha podido eliminar el contacto");
                        }
                    }
                }
            
                case 5 -> { // Listar contactos
                    for(Contacto contact: agenda.listarContactos()){
                        System.out.println(contact);
                    }
                }

                case 6 -> { // Mostrar numero contactos
                    System.out.println(agenda.mostrarContactos);
                }
            
                case 0 -> { // Salir
                    System.out.println("Bye.");
                }
            }
        } while (opcion != 0);
    } 
}