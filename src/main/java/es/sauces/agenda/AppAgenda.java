/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.agenda;


import java.util.Scanner;
 
/**
*
* @author irene
* @version 3.0
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
            System.out.println("5.- Listar Contartos");
            System.out.println("6.- Mostrar numero de contactos");
            System.out.println("0.- Salir");
            System.out.print("Introduzca opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion >= 1 && opcion <= 6) {
                 switch (opcion) {
                case 1 -> {
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    System.out.print("Introduzca teléfono: ");
                    telefono = teclado.nextLine();
                    System.out.print("Introduzca email: ");
                    email = teclado.nextLine();
                    if (agenda.crearContacto(new Contacto(nombre, telefono, email))) {
                        System.out.println("Contacto creado");
                    } else {
                        System.out.println("No podemos crear el contacto");
                    }
                }
                case 2 -> {
                    System.out.print("Introduzca nombre del contacto a consultar: ");
                    nombre = teclado.nextLine();
                    contacto = agenda.consultarContacto(nombre);
                    if (contacto != null) {
                        System.out.println(contacto);
                        }
                }
                case 3 -> {
                    System.out.print("Introduzca nombre del contacto a modificar: ");
                    nombre=teclado.nextLine();
                    contacto=agenda.consultarContacto(nombre);
                    if(contacto !=null){
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
                    }else{
                        System.out.println("No existe un contacto con ese nombre");
                    }
                }
                case 4 -> {
                    System.out.print("Introduzca el nombre a eliminar: ");
                    nombre = teclado.nextLine();
                    contacto= agenda.consultarContacto(nombre);
                    if(contacto!=null){
                        System.out.println(contacto);
                        System.out.print("Estás seguro que quieres eliminar el contacto (S/N)? ");
                        seguro = teclado.nextLine();
                        if (seguro.equals("S")) {
                            if (agenda.eliminarContacto(nombre)) {
                                System.out.println("Contacto eliminado");
                            } else {
                            System.out.println("No se ha podido eliminar el contacto");
                            }
                            }
                    }else{
                        System.out.println("Este contacto no existe.");
                    }
                }
                case 5 -> {
                    System.out.println(agenda.listaContactos());
                }
                case 6 -> {
                    System.out.printf("Actualmente hay %d contactos.",agenda.mostrarNumeroContactos());
                }
                case 0 -> {
                }
                default -> {
                }
                }    
                } else {
                        System.out.println("No existe un contacto con ese nombre");
                    }
        } while (opcion != 0);
 
    }
}