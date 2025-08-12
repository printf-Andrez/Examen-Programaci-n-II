/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenprogra;

import Controlador.ControladorPrincipal;
import Vista.PantallaAsignaturas;
import Vista.PantallaCalificaciones;
import Vista.PantallaEstudiantes;
import Vista.PantallaPrincipal;

/**
 *
 * @author P3E004-K
 */
public class Main {

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        PantallaAsignaturas pantallaAsignaturas = new PantallaAsignaturas();
        PantallaCalificaciones pantallaCalificaciones = new PantallaCalificaciones();
        PantallaEstudiantes pantallaEstudiantes = new PantallaEstudiantes();
        ControladorPrincipal controlador = new ControladorPrincipal(principal,
                pantallaAsignaturas, pantallaCalificaciones, pantallaEstudiantes);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
