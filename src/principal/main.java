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
import principal.menu.MenuPrincipal;

/**
 *
 * @author luisGonzalez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
    }
}
