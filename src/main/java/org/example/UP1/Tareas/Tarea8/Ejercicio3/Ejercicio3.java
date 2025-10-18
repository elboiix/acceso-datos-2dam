package org.example.UP1.Tareas.Tarea8.Ejercicio3;

import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejercicio3 {

    public static void main(String[] args) {

        Path ruta = Paths.get("src/main/java/org/example/UP1/Tarea8/Ejercicio1/estudiante.json");

        try {
            String contenido = Files.readString(ruta, StandardCharsets.UTF_8);
            JSONObject estudiante = new JSONObject(contenido);

            estudiante.put("curso", "2º DAM");

            Files.writeString(ruta, estudiante.toString(4), StandardCharsets.UTF_8);
            System.out.println("Propiedad 'curso' añadida correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
