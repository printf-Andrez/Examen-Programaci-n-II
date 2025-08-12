/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author P3E004-K
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private String numUnico;
    private String asignatura;

    public Estudiante(String nombre, String apellido, String numUnico, String asignatura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numUnico = numUnico;
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
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

    public String getNumUnico() {
        return numUnico;
    }

    public void setNumUnico(String numUnico) {
        this.numUnico = numUnico;
    }
    
    
}
