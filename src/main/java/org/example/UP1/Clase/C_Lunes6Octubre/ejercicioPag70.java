/*
RANDOMACCESSFILE
Crea un programa que abre un fichero de acceso aleatorio y luego realiza las
siguientes operaciones de lectura y escritura.
a. Escribe tres datos usando los métodos writeChar(), writeInt() y writeDouble().
b. Lleva el puntero al principio del fichero usando el método seek().
c. Lee los tres elementos e imprímelos por consola.
d. Ahora lleva el puntero al segundo elemento y luego lee e imprime por consola el
segundo elemento del fichero.
e. Mueve el puntero al final usando el método length(), luego vuelve a añadir el
segundo elemento y debajo añade otro ítem booleano.
f. Ahora tenemos 5 ítems en el fichero, ¿dónde estará el puntero en este momento?
g. Lleva el puntero al cuarto elemento e imprímelo.
h. Al final, cierra el fichero usando el método close().
 */
package org.example.UP1.Clase.C_Lunes6Octubre;
// Necesitamos RandomAccessFile para leer/escribir en cualquier posición
import java.io.RandomAccessFile;

public class ejercicioPag70 {

    public static void main(String[] args) {

        // try-with-resources: abre el fichero y LO CIERRA automáticamente al salir del bloque
        // modo --> "rw" = read + write. Si no existe, lo crea. El puntero empieza en 0.

        try (RandomAccessFile raf = new RandomAccessFile("ejercicioPag70.dat", "rw")) {

            // Eliminamos contenido previo (tamaño = 0 bytes) para limpiar el fichero
            raf.setLength(0);

            // ---------------------------------------------
            // a) Escribe tres datos: char, int y double
            // ---------------------------------------------

            // Escribo un char → ocupa 2 bytes → el interno puntero pasa de 0 a 2 bytes
            raf.writeChar('A');

            // Escribo un int → ocupa 4 bytes → puntero pasa de 2 a 6
            raf.writeInt(12345);

            // Escribo un double → ocupa 8 bytes → puntero pasa de 6 a 14
            raf.writeDouble(3.1416);

            // --------------------------------------------
            // b) Lleva el puntero al principio del fichero
            // --------------------------------------------

            // seek(0) mueve el puntero al byte 0
            raf.seek(0);

            // --------------------------------------------
            // c) Lee los tres elementos e imprímelos por consola
            // --------------------------------------------

            // Leo el char (consume 2 bytes) → el puntero pasa de 0 a 2 bytes
            char c = raf.readChar();

            // Leo el int (consume 4 bytes) → puntero 2 → 6
            int n = raf.readInt();

            // Leo el double (consume 8 bytes) → puntero 6 → 14
            double d = raf.readDouble();

            // Muestro lo leído
            System.out.println("c) Leídos -> char=" + c + ", int=" + n + ", double=" + d);

            // ----------------------------------------------
            // d) lleva el puntero al segundo elemento y luego lee e imprime por consola el
            // segundo elemento del fichero.
            // -----------------------------------------------

            // El int empieza en el byte 2 (tras el char de 2 bytes)
            raf.seek(2);

            // Leo SOLO ese int (consume 4 bytes) → puntero 2→6
            int segundo = raf.readInt();
            System.out.println("d) Segundo elemento (int) = " + segundo);

            // ---------------------------------------------
            // e) Mover puntero al FINAL y añadir: el segundo elemento + un boolean
            // -----------------------------------------------

            // length() = tamaño actual del fichero en bytes (debe ser 14 tras los tres primeros datos)
            long fin = raf.length();

            // Me posiciono exactamente al final (byte 14) para APPEND
            raf.seek(fin);

            // Escribo otra vez el int “segundo” → 4 bytes → puntero 14→18
            raf.writeInt(segundo);

            // Escribo un boolean (true/false) → 1 byte → puntero 18→19
            raf.writeBoolean(true);

            // ─────────────────────────────────────────────
            // f) ¿Dónde está el puntero ahora?
            // ─────────────────────────────────────────────

            // getFilePointer() devuelve la posición actual (en bytes desde el inicio)
            long pos = raf.getFilePointer();
            System.out.println("f) Puntero actual = " + pos + " (debería ser 19, al final)");

            // ---------------------------------------------
            // g) Ir al CUARTO elemento y leerlo
            // ----------------------------------------------
            // Estructura (con offsets):
            // 1º char   → bytes 0..1   (2 bytes)
            // 2º int    → bytes 2..5   (4 bytes)
            // 3º double → bytes 6..13  (8 bytes)
            // 4º int    → bytes 14..17 (4 bytes)
            // 5º boolean→ byte  18     (1 byte)

            // Para leer el 4º elemento (int al final) me posiciono en el byte 14
            raf.seek(14);

            // Leo ese int → puntero 14→18
            int cuarto = raf.readInt();
            System.out.println("g) Cuarto elemento (int) = " + cuarto);

            // ---------------------------------------------
            // h) Cerrar el fichero
            // ---------------------------------------------
            // No hay que hacer nada: el try-with-resources lo cierra automáticamente.

        } catch (Exception e) {
            // Si ocurre un error de E/S, lo mostramos por consola
            e.printStackTrace();
        }
    }
}


