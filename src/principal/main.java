/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import principal.frontend.gui.calendari_cholquij.FrameCalendario;

/**
 *
 * @author luisGonzalez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // TODO code application logic here
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra el estilo, por lo tanto se utlizara por defecto..");
        }        
        FrameCalendario calendarioCholquij = new FrameCalendario();
        calendarioCholquij.setVisible(true);
    }
}
