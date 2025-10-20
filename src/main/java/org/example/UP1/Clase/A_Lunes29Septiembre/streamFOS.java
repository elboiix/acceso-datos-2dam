package org.example.UP1.Clase.A_Lunes29Septiembre;

import java.io.FileOutputStream;
import java.io.IOException;

public class streamFOS {
    public static void main(String[] args) {
        String texto = "Hola";
        // Creamos un String con el texto que queremos escribir en el archivo

        try {
            // Se abre (o crea si no existe) un archivo en la ruta indicada, en modo escritura
            FileOutputStream fos = new FileOutputStream("./src/ficheros/archivo.txt");

            // Convierte el String "Hola" a un array de bytes y los escribe en el archivo
            // El método write(int b) escribe un solo byte en el archivo.
            fos.write(texto.getBytes());

            // Escribe un solo byte con el valor 1 en el archivo (no es el carácter '1')
            // El valor 1 no significa el carácter "1", sino el byte con valor binario 00000001.
            fos.write(1);

            // Muy importante: cerrar el fichero para liberar recursos y asegurar que se guarde todo
            fos.close();

            // Mensaje de confirmación en consola
            System.out.println("Datos escritos en el archivo binario.");

        } catch (IOException e) {
            // Si ocurre un error (ej. no encuentra la ruta), muestra la traza del error
            e.printStackTrace();
        }
    }
}
