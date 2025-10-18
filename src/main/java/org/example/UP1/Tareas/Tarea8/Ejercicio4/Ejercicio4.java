package org.example.UP1.Tareas.Tarea8.Ejercicio4;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio4 {

    public static void main(String[] args) {

        Path ruta = Paths.get("./src/Lunes17octubre/estudiante.json");

        try {
            String contenido = Files.readString(ruta, StandardCharsets.UTF_8);
            JSONObject estudiante = new JSONObject(contenido);

            JSONArray asignaturas = estudiante.getJSONArray("asignaturas");

            asignaturas.put("Programación");

            Files.writeString(ruta, estudiante.toString(4), StandardCharsets.UTF_8);
            System.out.println("Asignatura añadida correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
