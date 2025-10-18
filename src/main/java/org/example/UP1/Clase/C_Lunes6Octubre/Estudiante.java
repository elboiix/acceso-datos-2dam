package org.example.UP1.Clase.C_Lunes6Octubre;

// Necesitamos marcar la clase como serializable para poder guardarla en binario
import java.io.Serializable;

// Declaramos la clase de dominio: Estudiante
public class Estudiante implements Serializable {

    // Declaramos la versión de la clase (controla compatibilidad entre lecturas/escrituras)
    private static final long serialVersionUID = 1L;

    // Atributos de la clase Estudiante
    private int ID;
    private String nombre;   // Nombre (String)
    private double nota;     // Nota (double)

    // Constructor para crear estudiantes rápidamente
    public Estudiante(int id, String nombre, double nota) {
        this.ID = id;
        this.nombre = nombre;
        this.nota = nota;
    }

    // Getters para poder leer los campos desde el main (podrías añadir setters si quieres)
    public int getId() { return ID; }
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }

    // Método de utilidad para imprimir bonito por consola
    @Override
    public String toString() {
        return "Estudiante{id=" + ID + ", nombre='" + nombre + "', nota=" + nota + "}";
    }
}

