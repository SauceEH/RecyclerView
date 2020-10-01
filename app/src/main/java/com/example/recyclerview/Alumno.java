package com.example.recyclerview;

public class Alumno {
    // propiedades
    String nombre;
    String apellido;
    String ciclo;
    int curso;

    // constructores
    public Alumno(){}

    public Alumno (String nombre, String apellido, String ciclo, int curso)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciclo = ciclo;
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
