package org.example.UP1.Clase.C_Lunes6Octubre;

// Usaremos listas y streams de objetos para serializar/deserializar
import java.io.*;
import java.util.*;

// Clase con el método main y utilidades para leer/escribir la lista de estudiantes
public class AppEstudiantes {

    // Ruta del fichero binario donde guardaremos la lista
    private static final String FICHERO = "estudiantes.dat";

    public static void main(String[] args) {
        // Creamos una lista de al menos 3 estudiantes (punto 2.1)
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante(1, "Danielle",   8.1));
        lista.add(new Estudiante(2, "Adrián",  6.7));
        lista.add(new Estudiante(3, "Andrew", 9.2));

        try {
            // Guardamos la lista en el fichero (punto 2.2)
            escribirLista(lista, FICHERO);

            // Leemos la lista y la mostramos (punto 2.3)
            List<Estudiante> leidos = leerLista(FICHERO);
            System.out.println("Listado inicial:");
            imprimir(leidos);

            // Añadimos un nuevo estudiante a la lista (punto 2.4)
            leidos.add(new Estudiante(4, "Manuel", 7.5));
            // Guardamos de nuevo la lista con el nuevo alumno (punto 2.4)
            escribirLista(leidos, FICHERO);

            // Leemos de nuevo y mostramos la lista actualizada (punto 2.5)
            List<Estudiante> actualizados = leerLista(FICHERO);
            System.out.println("\nListado actualizado:");
            imprimir(actualizados);

        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre un problema de E/S o de clases (versionado), lo mostramos
            e.printStackTrace();
        }
    }

    // Escribe una lista de Estudiante en el fichero indicado
    private static void escribirLista(List<Estudiante> lista, String ruta) throws IOException {
        // try-with-resources: el stream se cierra solo al salir
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            // writeObject serializa la lista completa (y cada Estudiante dentro)
            oos.writeObject(lista);
            // flush no es obligatorio aquí, pero garantiza que todo se envíe al fichero
            oos.flush();
        }
    }

    // Lee y devuelve una lista de Estudiante desde el fichero indicado
    private static List<Estudiante> leerLista(String ruta) throws IOException, ClassNotFoundException {
        // try-with-resources: el stream se cierra automáticamente
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            // readObject deserializa; hacemos cast a List<Estudiante>
            return (List<Estudiante>) ois.readObject();
        }
    }

    // Muestra por consola cada estudiante de la lista
    private static void imprimir(List<Estudiante> lista) {
        // Recorremos y sacamos cada elemento formateado usando toString()
        for (Estudiante e : lista) System.out.println(" - " + e);
    }
}

