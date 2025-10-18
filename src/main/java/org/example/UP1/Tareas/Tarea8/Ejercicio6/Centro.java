package org.example.UP1.Tareas.Tarea8.Ejercicio6;

import java.util.List;

public class Centro {

    private String equipoDocente;
    private String instituto;
    private int fundado;
    private String curso;
    private boolean activo;
    private List<Profesor> profesores;

    public Centro(String equipoDocente, String instituto, int fundado, String curso, boolean activo, List<Profesor> profesores) {
        this.equipoDocente = equipoDocente;
        this.instituto = instituto;
        this.fundado = fundado;
        this.curso = curso;
        this.activo = activo;
        this.profesores = profesores;
    }

    public String getEquipoDocente() {
        return equipoDocente;
    }

    public void setEquipoDocente(String equipoDocente) {
        this.equipoDocente = equipoDocente;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public int getFundado() {
        return fundado;
    }

    public void setFundado(int fundado) {
        this.fundado = fundado;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }
}