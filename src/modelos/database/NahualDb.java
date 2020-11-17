/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.objetos.Nahual;

/**
 *
 * @author jose_
 */
public class NahualDb {
    
    public void crear(Nahual nahual){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO Nahual "
                    + "(nombre,rutaImagen,signficado,descripcion,fechaInicio,fechaFinalizacion) VALUES (?,?,?,?,?,?)");
            statement.setString(1, nahual.getNombre());
            statement.setString(2, nahual.getRutaImagen());
            statement.setString(3, nahual.getSignificado());
            statement.setString(4, nahual.getDescripcion());
            statement.setDate(5, nahual.getFechaInicio());
            statement.setDate(6, nahual.getFechaFinalizacion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(Nahual nahual){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Nahual SET "
                    + "nombre=?, rutaImagen=?, significado=?, descripcion=?, fechaInicio=?, fechaFinalizacion=? WHERE id=?;");
            statement.setString(1, nahual.getNombre());
            statement.setString(2, nahual.getRutaImagen());
            statement.setString(3, nahual.getSignificado());
            statement.setString(4, nahual.getDescripcion());
            statement.setDate(5, nahual.getFechaInicio());
            statement.setDate(6, nahual.getFechaFinalizacion());
            statement.setInt(7, nahual.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(Nahual nahual){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM Nahual WHERE id=?;");
            statement.setInt(1, nahual.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
