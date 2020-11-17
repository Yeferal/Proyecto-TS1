/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.objetos.Cargador;

/**
 *
 * @author jose_
 */

public class CargadorDb {
    
    public void crear(Cargador cargador){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO Cargador "
                    + "(nombre,descripcion) VALUES (?,?);");
            statement.setString(1, cargador.getNombre());
            statement.setString(2, cargador.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(Cargador cargador){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Cargador SET "
                    + "descripcion=? WHERE nombre=?;");
            statement.setString(1, cargador.getNombre());
            statement.setString(2, cargador.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(Cargador cargador){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM Cargador WHERE nombre=?");
            statement.setString(1, cargador.getNombre());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
