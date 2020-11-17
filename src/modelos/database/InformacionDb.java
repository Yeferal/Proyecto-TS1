/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.objetos.Informacion;

/**
 *
 * @author jose_
 */
public class InformacionDb {
    
    public void crear(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO Informacion "
                    + "(titulo,descripcion) VALUES (?,?);");
            statement.setString(1, informacion.getTitulo());
            statement.setString(2, informacion.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Informacion SET "
                    + "titulo=?, descripcion=? WHERE id=?;");
            statement.setString(1, informacion.getTitulo());
            statement.setString(2, informacion.getDescripcion());
            statement.setInt(3, informacion.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(Informacion informacion){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELTE FROM Informacion WHERE id=?;");
            statement.setInt(1, informacion.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
