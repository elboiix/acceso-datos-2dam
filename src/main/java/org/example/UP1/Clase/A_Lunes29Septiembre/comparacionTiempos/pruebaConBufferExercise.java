package org.example.UP1.Clase.A_Lunes29Septiembre.comparacionTiempos;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class pruebaConBufferExercise {

    public static void main(String[] args) {
        int cantidadDatos = 1000000; // Un millón de enteros

        long inicioConBuffer = System.currentTimeMillis();

        try {
            DataOutputStream dosBuff = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("./src/ficheros/con_buffer.bin")
                    )
            );

            for (int i = 0; i < cantidadDatos; i++) {
                dosBuff.writeInt(i); // Escribir enteros en el archivo
            }

            dosBuff.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long finConBuffer = System.currentTimeMillis();
        System.out.println("Tiempo con BufferedOutputStream: " +
                (finConBuffer - inicioConBuffer) + " ms");
    }
}
