/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelos.objetos.FechaRuedaCalendarica;

/**
 *
 * @author jose_
 */
public class FechaRuedaCalendaricaDb {
    
    public void crear(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO RuedaCalendarica"
                    + "(idFechaHaab,idFechaCholqij,Descripcion) VALUES (?,?,?);");
            statement.setInt(1, fecha.getFechaHaab().getId());
            statement.setInt(2, fecha.getFechaCholqij().getId());
            statement.setString(3, fecha.getDescripcion());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE RuedaCalendarica SET"
                    + "idFechaHaab=?, idFechaCholqij=?, descripcion=? WHERE id=?;");
            statement.setInt(1, fecha.getFechaHaab().getId());
            statement.setInt(2, fecha.getFechaCholqij().getId());
            statement.setString(3, fecha.getDescripcion());
            statement.setInt(4, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(FechaRuedaCalendarica fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM RuedaCalendarica WHERE id=?;");
            statement.setInt(1, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
