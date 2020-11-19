/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jose_
 */
public class AccesoDB {
    
    private Connection conexion;
    private CargadorDB cargadorDb;
    private CategoriaDB categoriaDb;
    private DiaCholqijDB diaCholqijDb;
    private EdicionDB edicionDb;
    private HechoHistoricoDB hechoHistoricoDb;
    private NahualDB nahualDb;
    private RolDB rolDb;
    private Rueda1DB rueda1Db;
    private Rueda2DB rueda2Db;
    private Rueda3DB rueda3Db;
    private RuedaCalendaricaDB ruedaCalendaricaDb;
    private UsuarioDB usuarioDb;
    private WinalDB winalDb;
    
    //CARGA EL ESQUEMA QUE SE VA A UTILIZAR PARA LA BASE DE DATOS.
    public void cargarConexion() throws SQLException{
        Statement creaEsquema = conexion.createStatement();
        creaEsquema.executeUpdate("USE CalendarioMaya");
    }
    
    //INICIA SESION EN LA BASE DE DATOS
    public void iniciarSesion(String user, String password) throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
	String stringConnection = "jdbc:mysql://localhost/?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        conexion = DriverManager.getConnection(stringConnection, user, password);
        cargarConexion();
    }
    
    //public List<Usuario> getUsuarios(){ return usuarioDb.getUsuarios(); }
    
    //public Usuario getUsuario(String username, String password){ return usuarioDb.getUsuario(username, password); }
    
    //public void modificarUsuario(Usuario usuario){ usuarioDb.modificarUsuario(usuario); }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
