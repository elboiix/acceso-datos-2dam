package Lunes29Septiembre;

import java.io.FileReader;
import java.io.IOException;

public class streamExFlujosChars {

    public static void main(String[] args) throws IOException {
        // Abrimos un flujo para leer caracteres del archivo "texto.txt"
        FileReader fr = new FileReader("texto.txt");

        int caracter; // Variable que almacenará cada carácter leído (en código Unicode)
        // Leer de uno en uno todos los caracteres hasta llegar al final (-1)
        while ((caracter = fr.read()) != -1) {
            System.out.print((char) caracter); // Convertimos el número Unicode a carácter y lo mostramos
        }

        // Cerramos el flujo para liberar recursos
        fr.close();
    }

}
