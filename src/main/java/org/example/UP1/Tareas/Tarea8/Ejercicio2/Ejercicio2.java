package org.example.UP1.Tareas.Tarea8.Ejercicio2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio2 {

    public static void main(String[] args) {

        Path ruta = Paths.get("src/main/java/org/example/UP1/Tarea8/Ejercicio1/estudiante.json");

        try {
            String contenido = Files.readString(ruta, StandardCharsets.UTF_8);
            JSONObject estudiante = new JSONObject(contenido);

            System.out.println("Nombre: " + estudiante.getString("nombre"));
            System.out.println("Edad: " + estudiante.getInt("edad"));

            JSONArray asignaturas = estudiante.getJSONArray("asignaturas");
            System.out.println("Asignaturas:");
            for (int i = 0; i < asignaturas.length(); i++) {
                System.out.println(" - " + asignaturas.getString(i));
            }

        } catch (Exception e) {
            System.err.println("Error al leer el archivo JSON");
            e.printStackTrace();
        }
    }
}

