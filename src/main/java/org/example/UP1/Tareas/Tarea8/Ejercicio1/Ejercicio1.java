package org.example.UP1.Tareas.Tarea8.Ejercicio1;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio1 {

    public static void main(String[] args) {

        JSONObject estudiante = new JSONObject()
                .put("nombre", "Carlos")
                .put("edad", 18)
                .put("asignaturas", new JSONArray()
                .put("Programación")
                .put("Bases de datos")
                .put("Lenguaje de marcas"));

        Path salida = Paths.get("src/main/java/org/example/UP1/Tarea8/estudiante.json");

        try {
            Files.createDirectories(salida.getParent());
            Files.writeString(salida, estudiante.toString(4), StandardCharsets.UTF_8);
            System.out.println("Archivo JSON creado en: " + salida.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}