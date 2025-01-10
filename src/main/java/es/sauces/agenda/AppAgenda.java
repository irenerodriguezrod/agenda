/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package es.sauces.agenda;

import java.util.Scanner;

/**
 *
 * @author ambrosio
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
            System.out.println("0.- Salir");
            System.out.print("Introduzca opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            if (opcion >= 1 && opcion <= 4) {
                if (opcion == 1) {
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    System.out.print("Introduzca teléfono: ");
                    telefono = teclado.nextLine();
                    System.out.print("Introduzca email: ");
                    email = teclado.nextLine();
                    if (agenda.crearContacto(nombre, telefono, email)) {
                        System.out.println("Contacto creado");
                    } else {
                        System.out.println("No podemos crear el contacto");
                    }
                } else {
                    System.out.print("Introduzca nombre: ");
                    nombre = teclado.nextLine();
                    contacto = agenda.consultarContacto(nombre);
                    if (contacto != null) {
                        System.out.println(contacto);
                        switch (opcion) {

                            case 3 -> {

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

                            case 4 -> {

                                System.out.print("Seguro (S/N)? ");
                                seguro = teclado.nextLine();
                                if (seguro.equals("S")) {
                                    if (agenda.eliminarContacto(nombre)) {
                                        System.out.println("Contacto eliminado");
                                    } else {
                                        System.out.println("No se ha podido eliminar el contacto");
                                    }

                                }

                            }

                        }

                    } else {
                        System.out.println("No existe un contacto con ese nombre");
                    }
                }

            }
        } while (opcion != 0);

    }
}
