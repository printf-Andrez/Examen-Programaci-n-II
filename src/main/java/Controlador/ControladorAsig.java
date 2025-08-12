/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Asignatura;
import Vista.PantallaAsignaturas;
import Vista.PantallaCalificaciones;
import Vista.PantallaEstudiantes;
import Vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author P3E004-K
 */
public class ControladorAsig {
    private PantallaAsignaturas pantalla;
    private PantallaPrincipal principal;
    private PantallaEstudiantes estudiantes;
    private PantallaCalificaciones calificaciones;
    private ArrayList<Asignatura> listaAsignaturas;

    public ControladorAsig(PantallaAsignaturas pantalla, PantallaPrincipal principal
    , PantallaEstudiantes estudiantes, PantallaCalificaciones calificaciones) {
        this.pantalla = pantalla;
        this.principal = principal;
        this.estudiantes = estudiantes;
        this.pantalla.getVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            principal.setVisible(true);
            pantalla.setVisible(false);
        }
        });
        this.listaAsignaturas = new ArrayList<>();
        pantalla.getGuardarAsig().addActionListener(e -> {
            if ((pantalla.getNomAsignatura().getText()).isEmpty() 
                    || (pantalla.getNumCreditos().getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "Aún faltan espacios por llenar");
                return;
            }
            String nombre = pantalla.getNomAsignatura().getText();
            int creditos = Integer.parseInt(pantalla.getNumCreditos().getText());
            int semestre = Integer.parseInt(pantalla.getNumSemestre().getSelectedItem().toString());
            Asignatura asignatura = new Asignatura(nombre, creditos, semestre);
            listaAsignaturas.add(asignatura);
            estudiantes.agregarAsignatura(asignatura);
            calificaciones.agregarAsignatura(asignatura);
            JOptionPane.showMessageDialog(null, "Asignatura añadida con éxito.");
            pantalla.getNomAsignatura().setText("");
            pantalla.getNumCreditos().setText("");
    });
}
}

