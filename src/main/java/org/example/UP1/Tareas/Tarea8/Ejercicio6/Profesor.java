package org.example.UP1.Tareas.Tarea8.Ejercicio6;

import java.util.List;

public class Profesor {

    private String nombre;
    private String apellidos;
    private List<Integer> cursos;
    private List<String> modulos;

    public Profesor(String nombre, String apellidos, List<Integer> cursos, List<String> modulos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cursos = cursos;
        this.modulos = modulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Integer> getCursos() {
        return cursos;
    }

    public void setCursos(List<Integer> cursos) {
        this.cursos = cursos;
    }

    public List<String> getModulos() {
        return modulos;
    }

    public void setModulos(List<String> modulos) {
        this.modulos = modulos;
    }
}
