/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Vista.PantallaCalificaciones;
import Vista.PantallaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P3E004-K
 */
public class ControladorCalif {
    private PantallaCalificaciones pantalla;
    private PantallaPrincipal principal;
    private ControladorPrincipal controladorPrincipal;
    private List<Estudiante> listaEstudiantes;

    public ControladorCalif(PantallaCalificaciones pantalla,
           PantallaPrincipal principal, ControladorPrincipal controladorPrincipal) {
        this.pantalla = pantalla;
        this.principal = principal;
        this.controladorPrincipal = controladorPrincipal;
        this.listaEstudiantes = controladorPrincipal.obtenerEstudiantes();
        this.pantalla.getVolver().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            principal.setVisible(true);
            pantalla.setVisible(false);
        }
        });
        DefaultTableModel modeloTabla = (DefaultTableModel) pantalla.getTablaCalif().getModel();
        pantalla.getGuardarCalif().addActionListener(e -> {
          if ((pantalla.getCodigo().getText()).isEmpty() 
                    || (pantalla.getNota1().getText()).isEmpty()
                    || (pantalla.getNota2().getText()).isEmpty()
                    || (pantalla.getNota3().getText()).isEmpty()){
                JOptionPane.showMessageDialog(null, "Aún faltan espacios por llenar");
                return;
            } 
          String codigo = pantalla.getCodigo().getText();
          String asignatura = pantalla.getAsignaturas().getSelectedItem().toString();
          boolean comprobacion = listaEstudiantes.stream().anyMatch(est -> est.getNumUnico()
                  .equalsIgnoreCase(codigo));
          if (!comprobacion) {
        JOptionPane.showMessageDialog(null, "El código ingresado no corresponde a ningún estudiante registrado");
        return; 
        }
          int nota1 = Integer.parseInt(pantalla.getNota1().getText());
          int nota2 = Integer.parseInt(pantalla.getNota2().getText());
          int nota3 = Integer.parseInt(pantalla.getNota3().getText());
          String estado = "";
          if ((nota1 + nota2) >= 28) {
              pantalla.getNota3().setText("0");
              nota3 = 0;
              estado = "Exonerado";
              JOptionPane.showMessageDialog(null, "Estudiante exonerado.");
          } else if ((nota1 + nota2) < 24){
              pantalla.getNota3().setText("0");
              nota3 = 0;
              estado = "Fallido";
              JOptionPane.showMessageDialog(null, "Estudiante fallido.");
          } else if (((nota1 + nota2 + nota3) / 3) >= 24){
              estado = "Aprueba";
              JOptionPane.showMessageDialog(null, "Estudiante aprobado.");
          } else if (((nota1 + nota2 + nota3) / 3) < 24){
              estado = "Fallido";
              JOptionPane.showMessageDialog(null, "Estudiante fallido.");   
          }
          modeloTabla.addRow(new Object[]{codigo, asignatura, nota1, nota2, nota3, estado});
          pantalla.getCodigo().setText("");
          pantalla.getNota1().setText("");
          pantalla.getNota2().setText("");
          pantalla.getNota3().setText("");
        });
        
    
    
}
}
