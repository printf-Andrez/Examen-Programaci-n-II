/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.PantallaEstudiantes;
import Modelo.Estudiante;
import Vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P3E004-K
 */
public class ControladorEstu {
    private PantallaEstudiantes pantalla;
    private PantallaPrincipal principal;
    private ControladorPrincipal controladorPrincipal;

    public ControladorEstu(PantallaEstudiantes pantalla,
            PantallaPrincipal principal, ControladorPrincipal controladorPrincipal) {
        this.pantalla = pantalla;
        this.principal = principal;
        this.controladorPrincipal = controladorPrincipal;
        this.pantalla.getVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            principal.setVisible(true);
            pantalla.setVisible(false);
        }
        });
        DefaultTableModel modeloTabla = (DefaultTableModel) pantalla.getTablaEstud().getModel();
         pantalla.getGuardarEstud().addActionListener(e -> {
            if ((pantalla.getNomEstudiante().getText()).isEmpty() 
                    || (pantalla.getApeEstudiante().getText()).isEmpty()
                    || (pantalla.getCodEstudiante().getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "Aún faltan espacios por llenar");
                return;
            }
            String nombre = pantalla.getNomEstudiante().getText();
            String apellido = pantalla.getApeEstudiante().getText();
            String codigo = pantalla.getCodEstudiante().getText();
            String asignatura = pantalla.getAsignaturas().getSelectedItem().toString();
            Estudiante estudiante = new Estudiante(nombre, apellido, codigo, asignatura);
            controladorPrincipal.agregarEstudiante(estudiante);
            modeloTabla.addRow(new Object[]{nombre, apellido, codigo, asignatura});
            JOptionPane.showMessageDialog(null, "Estudiante añadido con éxito.");
            pantalla.getNomEstudiante().setText("");
            pantalla.getApeEstudiante().setText("");
            pantalla.getCodEstudiante().setText("");
    });
}
}
