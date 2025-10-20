package org.example.UP1.Clase.A_Lunes29Septiembre;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Copiar una imagen
public class streamExFlujosBinarios {

    // throws IOException
    // En Java, muchas operaciones de entrada/salida (I/O) pueden fallar.
    // Ejemplo: el archivo no existe, no tienes permisos, el disco está lleno, etc.
    // Estas situaciones generan una excepción de tipo IOException (Input/Output Exception).
    // En este caso, si hay un error de entrada/salida,
    // el método main no lo gestiona aquí, lo paso al sistema operativo que informa a la
    // Máquina Virtual de Java --> JMV detiene la ejecución y muestra un mensaje por consola

    public static void main(String[] args) throws IOException {
        // Abrimos un flujo de entrada para leer la imagen original
        FileInputStream in = new FileInputStream("foto.jpg");

        // Abrimos un flujo de salida para escribir la copia
        FileOutputStream out = new FileOutputStream("copia.jpg");

        int byteLeido; // Variable que almacenará cada byte leído
        // Leer de uno en uno todos los bytes hasta llegar al final (-1)
        while ((byteLeido = in.read()) != -1) {
            out.write(byteLeido); // Escribimos el byte leído en el archivo de salida
        }

        // Cerramos los flujos para liberar recursos
        in.close();
        out.close();

        System.out.println("Imagen copiada con éxito.");
    }
}
