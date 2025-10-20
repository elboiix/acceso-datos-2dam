package org.example.UP1.Clase.A_Lunes29Septiembre;

// Scanner --> Es una clase de Java que sirve para leer datos (entrada).
import java.util.Scanner;

public class streamEx1 {
    public static void main(String[] args) {
        // System.in es la entrada estándar de Java (normalmente el teclado)
        Scanner sc = new Scanner(System.in);

        // Entrada estándar
        System.out.print("Introduce un número: ");
        // nextInt() → es un método de Scanner
        // que espera que el usuario introduzca un número entero.
        int numero = sc.nextInt();

        // Salida estándar
        System.out.println("Has introducido: " + numero);

        // Error estándar
        if (numero < 0) {
            System.err.println("Error: no se permiten números negativos.");
        }
    }
}
