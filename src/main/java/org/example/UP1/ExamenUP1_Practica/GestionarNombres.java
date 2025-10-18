package org.example.UP1.ExamenUP1_Practica;

import java.io.*;
import java.util.Scanner;

public class GestionarNombres {

    public static Scanner entrada = new Scanner(System.in);

    static void main(String[] args) {

        mostrarOpciones();

    }

    public static void mostrarOpciones() {

        System.out.println("1. Añadir nombre al principio");
        System.out.println("2. Añadir nombre al final");
        System.out.println("3. Mostrar contenido del fichero");
        System.out.println("\"0\" para salir del programa");
        seleccionarOpcion();

    }

    public static void seleccionarOpcion() {

        System.out.print("Selecciona una opción: ");
        int opcion = entrada.nextInt();

        switch (opcion) {

            case 1:
                escribirNombreAlPrincipio();
            case 2:
                escribirNombreAlFinal();
            case 3:
                mostrarContenido();

            case 0:
                System.out.println("Saliendo del programa...");
                System.exit(1);
            default:
                System.out.println("¡ERROR al seleccionar una opcion!");
                seleccionarOpcion();

        }
    }

    private static void escribirNombreAlFinal() {

       String lecturaFichero = leerFichero();

        try (BufferedWriter file = new BufferedWriter(new FileWriter("src/main/java/org/example/ExamenUD1_Practicar/file.txt"))) {

            System.out.print("Introduce el nombre que quieres poner al final del fichero: ");
            String nombre = entrada.next();

            if (lecturaFichero.isEmpty()){
                file.write(nombre);
            }else{
                file.write(lecturaFichero + " " + nombre);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        mostrarOpciones();
    }

    public static void mostrarContenido() {

        try (BufferedReader file = new BufferedReader(new FileReader("src/main/java/org/example/ExamenUD1_Practicar/file.txt"))) {

            int caracter;

            while ((caracter = file.read()) != -1) {
                System.out.print((char) caracter);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        mostrarOpciones();
    }


    public static String leerFichero() {

        StringBuilder sb = new StringBuilder();

        try (BufferedReader file = new BufferedReader(new FileReader("src/main/java/org/example/ExamenUD1_Practicar/file.txt"))) {

            int caracter;

            while ((caracter = file.read()) != -1) {
                sb.append((char) caracter);
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }

    private static void escribirNombreAlPrincipio() {

        String lecturaFichero = leerFichero();

        try (BufferedWriter file = new BufferedWriter(new FileWriter("src/main/java/org/example/ExamenUD1_Practicar/file.txt"))) {

            System.out.print("Introduce el nombre que quieres poner al principio del fichero: ");
            String nombre = entrada.next();

            if (lecturaFichero.isEmpty()){
                file.write(nombre);
            }else{
                file.write(nombre + " " + lecturaFichero);
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        mostrarOpciones();
    }
}
