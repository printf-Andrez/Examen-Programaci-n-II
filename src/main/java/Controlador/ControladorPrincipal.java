/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Vista.PantallaAsignaturas;
import Vista.PantallaCalificaciones;
import Vista.PantallaEstudiantes;

import Vista.PantallaPrincipal;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author P3E004-K
 */
public class ControladorPrincipal {
    private PantallaPrincipal pantalla;
    private ControladorPrincipal controladorPrinc;
    private PantallaAsignaturas pantallaAsignaturas;
    private ControladorAsig controladorAsig;
    private PantallaCalificaciones pantallaCalificaciones;
    private ControladorCalif controladorCalif;
    private PantallaEstudiantes pantallaEstudiantes;
    private ControladorEstu controladorEstu;
    private ArrayList<Estudiante> listaEstudiantes;
    
    public void agregarEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }
        public List<Estudiante> obtenerEstudiantes() {
        return Collections.unmodifiableList(listaEstudiantes);
    }

    public ControladorPrincipal(PantallaPrincipal pantalla, 
            PantallaAsignaturas pantallaAsignaturas,
            PantallaCalificaciones pantallaCalificaciones,
            PantallaEstudiantes pantallaEstudiantes) {
        this.pantalla = pantalla;
        this.pantallaAsignaturas = pantallaAsignaturas;
        this.pantallaCalificaciones = pantallaCalificaciones;
        this.pantallaEstudiantes = pantallaEstudiantes;
        this.listaEstudiantes = new ArrayList<>();
        this.pantalla.getAbrirAsignaturas().addActionListener(e -> {
            controladorAsig = new ControladorAsig(pantallaAsignaturas,
                    pantalla, pantallaEstudiantes, pantallaCalificaciones);
            pantallaAsignaturas.setLocationRelativeTo(null);
            pantallaAsignaturas.setVisible(true);
            pantalla.setVisible(false);
        });
        this.pantalla.getAbrirCalificaciones().addActionListener(e -> {
            controladorCalif = new ControladorCalif(pantallaCalificaciones, pantalla, this);
            pantallaCalificaciones.setLocationRelativeTo(null);
            pantallaCalificaciones.setVisible(true);
            pantalla.setVisible(false);
        });
        this.pantalla.getAbrirEstudiantes().addActionListener(e -> {
            controladorEstu = new ControladorEstu(pantallaEstudiantes, pantalla, this);
            pantallaEstudiantes.setLocationRelativeTo(null);
            pantallaEstudiantes.setVisible(true);
            pantalla.setVisible(false);
        });
    }
    
}
