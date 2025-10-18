package org.example.UP1.Clase.C_Lunes6Octubre;

import java.io.RandomAccessFile;

public class Ex1RandomAccessFile {
    public static void main(String[] args) throws Exception {

        // SINTAXIS
        // RandomAccessFile raf = new RandomAccessFile(String ruta, String modo);
        // RandomAccessFile raf = new RandomAccessFile(java.io.File archivo, String modo);

        // Modos válidos
        // "r" → solo lectura. No crea el archivo si no existe.
        // "rw" → lectura y escritura. Crea el archivo si no existe.
        //"rws" → lectura/escritura con sincronización de datos y metadatos (tamaño, fechas) en el almacenamiento físico tras cada actualización.
        // rwd" → lectura/escritura con sincronización solo de datos (los metadatos pueden tardar en persistir).
        // En todos los casos, el puntero del archivo empieza en 0

        // Abrimos/creamos el fichero para Lectura/Escritura
        try (RandomAccessFile raf = new RandomAccessFile("puntero.dat", "rw")) {

            // (1) Limpiamos el fichero: empezamos desde 0 bytes
            raf.setLength(0);

            // (2) Al abrir, el puntero está en 0
            System.out.println("Inicio -> puntero = " + raf.getFilePointer()); // 0

            // (3) Escribimos un int (4 bytes). Al terminar, el puntero AVANZA 4 posiciones
            raf.writeInt(2025);
            System.out.println("Tras writeInt -> puntero = " + raf.getFilePointer()); // 4

            // (4) Escribimos un char (2 bytes). El puntero avanza 2 posiciones más
            raf.writeChar('A');
            System.out.println("Tras writeChar -> puntero = " + raf.getFilePointer()); // 6

            // (5) Escribimos un double (8 bytes). El puntero avanza 8
            raf.writeDouble(3.14);
            System.out.println("Tras writeDouble -> puntero = " + raf.getFilePointer()); // 14

            // (6) Volvemos al principio del archivo para LEER desde 0
            raf.seek(0);
            System.out.println("seek(0) -> puntero = " + raf.getFilePointer()); // 0

            // (7) Leemos un int (4 bytes). La JVM consume 4 bytes y el puntero salta a 4
            int n = raf.readInt();
            System.out.println("readInt = " + n + " | puntero = " + raf.getFilePointer()); // 4

            // (8) Leemos un char (2 bytes). El puntero pasa de 4 a 6
            char c = raf.readChar();
            System.out.println("readChar = " + c + " | puntero = " + raf.getFilePointer()); // 6

            // (9) Leemos un double (8 bytes). El puntero pasa de 6 a 14 (fin)
            double d = raf.readDouble();
            System.out.println("readDouble = " + d + " | puntero = " + raf.getFilePointer()); // 14

            // (10) Movemos el puntero manualmente al byte 4 (donde empezó el char)
            raf.seek(4);
            System.out.println("seek(4) -> puntero = " + raf.getFilePointer()); // 4

            // (11) Sobrescribimos el char por 'Z' (2 bytes). El puntero avanza a 6
            raf.writeChar('Z');
            System.out.println("Tras sobreescribir char -> puntero = " + raf.getFilePointer()); // 6
        }
    }
}
