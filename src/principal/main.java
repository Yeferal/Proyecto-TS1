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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.database.ConexionDb;
import api.login.Login;

/**
 *
 * @author luisGonzalez
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            
            //INICIAMOS CONECTANDO  DB  
            ConexionDb.obtenerConexion();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
            
            
            //CERRAMOS CONEXION DB
            ConexionDb.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO code application logic here
        Login logeo = new Login();
        logeo.setVisible(true);
    }
}
