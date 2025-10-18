package org.example.UP1.Tareas.Tarea5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private static final String FICHERO = "src/main/java/org/example/UP1/Tarea5/BookFile.dat";

    public static void main(String[] args) {

        List<Book> lista = new ArrayList<>();
        lista.add(new Book("Gabriel García Márquez", "Cien años de soledad", "Sudamericana", "1967"));
        lista.add(new Book("George Orwell", "1984", "Secker & Warburg", "1949"));
        lista.add(new Book("J.K. Rowling", "Harry Potter", "Bloomsbury", "1997"));

        try {

            escribirLista(lista,FICHERO);

            List<Book> leidos = leerLista(FICHERO);
            System.out.println("Lista inicial de libros:");
            imprimir(leidos);

            leidos.add(new Book("Miguel de Cervantes", "Don Quijote de la Mancha", "Francisco de Robles", "1605"));

            escribirLista(leidos, FICHERO);

            List<Book> actualizados = leerLista(FICHERO);
            System.out.println("Lista actualizada:");
            imprimir(actualizados);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void escribirLista(List<Book> lista, String ruta) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(lista);
            oos.flush();
        }
    }

    private static List<Book> leerLista(String ruta) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<Book>) ois.readObject();
        }
    }

    private static void imprimir(List<Book> lista) {
        for (Book b : lista){
            System.out.println(" - " + b);
        }
    }
}
