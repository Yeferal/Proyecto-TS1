/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jose_
 */
public class ConexionDb {//Aquí la conexion a la base de datos
    
    public static Connection conexion = null;

    //llenar con credenciales de su DB , datos de ejemplo
    final static String nombreBaseDatos = "CalendarioMaya";
    final static String usuario = "root";
    final static String password = "1234";

    //Nos conectamos a nuestra db
    public static  Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        if (conexion == null) {
            try {
                //Buscamos nuestra db por medio de su ubicacion <entorno  local>, mandando el nombre y nuestra password
                Class.forName("com.mysql.jdbc.Driver");
                String stringConnection = "jdbc:mysql://localhost/"+nombreBaseDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
                conexion = DriverManager.getConnection(stringConnection, usuario, password);
                
            }//en caso de que no se encuentre la base de datos 
            catch (SQLException ex) {
                throw new SQLException(ex);
            }//en caso de que no encuentre la libreria 
            catch (ClassNotFoundException ex) {
              throw new ClassCastException(ex.getMessage());
       
            }
        }
        return conexion;
    }

    //cerramos conexion , liberamos nuestra DB 
    public static void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }

}
