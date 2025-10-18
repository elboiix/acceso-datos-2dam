package org.example.UP1.Tarea8.Ejercicio5;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio5 {

    public static void main(String[] args) {

        JSONArray estudiantes = new JSONArray()
                .put(new JSONObject().put("nombre", "Carlos").put("calificacion", 8.5))
                .put(new JSONObject().put("nombre", "Lucía").put("calificacion", 9.2))
                .put(new JSONObject().put("nombre", "Pedro").put("calificacion", 7.8));

        JSONObject profesor = new JSONObject()
                .put("nombre", "Silvia")
                .put("departamento", "Informática")
                .put("estudiantes", estudiantes);

        Path salida = Paths.get("./src/Lunes17octubre/profesor.json");

        try {
            Files.createDirectories(salida.getParent());
            Files.writeString(salida, profesor.toString(4), StandardCharsets.UTF_8);
            System.out.println("Archivo profesor.json creado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}