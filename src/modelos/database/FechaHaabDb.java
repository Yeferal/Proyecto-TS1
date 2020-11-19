/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import modelos.objetos.FechaHaab;

/**
 *
 * @author jose_
 */
public class FechaHaabDb {
    
    public void crear(FechaHaab fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO calendariohaab "
                    + "(nahual,winal,nombre,descripcion,fecha) VALUES (?,?,?,?,?);");
            statement.setInt(1,fecha.getNahual().getId());
            statement.setInt(2, fecha.getWinal().getId());
            statement.setString(3, fecha.getNombre());
            statement.setString(4, fecha.getDescripcion());
            statement.setDate(5, fecha.getFecha());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void modificar(FechaHaab fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE calendariohaab"
                    + "SET nahual=?, winal=?, nombre=?, descripcion=?, fecha=? WHERE id=?;");
            statement.setInt(1, fecha.getNahual().getId());
            statement.setInt(2, fecha.getWinal().getId());
            statement.setString(3, fecha.getNombre());
            statement.setString(4, fecha.getDescripcion());
            statement.setDate(5, fecha.getFecha());
            statement.setInt(6, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void eliminar(FechaHaab fecha){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM calendariohaab WHERE id=?;");
            statement.setInt(1, fecha.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<FechaHaab> getFechas(){
        List<FechaHaab> fechas = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM calendariohaab;");
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) fechas.add(instanciarDeResultSet(resultado));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fechas;
    }
    
    public FechaHaab getFecha(int id){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM calendariohaab WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public FechaHaab getFechaEspecifica(LocalDate fecha) {
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM calendariohaab WHERE fecha=?;");
            statement.setDate(1, Date.valueOf(fecha));
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }   
    
    private FechaHaab instanciarDeResultSet(ResultSet resultado) throws SQLException{
        NahualDb accesoNahual = new NahualDb();
        WinalDb accesoWinal = new WinalDb();
        return new FechaHaab(
                resultado.getInt("id"),
                accesoNahual.getNahual(resultado.getInt("nahual")),
                accesoWinal.getWinal(resultado.getInt("winal")),
                resultado.getString("nombre"),
                resultado.getString("descripcion"),
                resultado.getDate("fecha")
        );
    }
}
