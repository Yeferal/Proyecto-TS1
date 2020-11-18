/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Informacion> getInformaciones(){
        List<Informacion> informaciones = new ArrayList();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Informacion;");
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()) informaciones.add(instanciarDeResultSet(resultado));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return informaciones;
    }
    
    public Informacion getInformacion(String titulo){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Informacion WHERE titulo=?;");
            statement.setString(1, titulo);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public Informacion getInformacion(int id){
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Informacion WHERE id=?;");
            statement.setInt(1, id);
            ResultSet resultado = statement.executeQuery();
            if(resultado.next()) return instanciarDeResultSet(resultado);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private Informacion instanciarDeResultSet(ResultSet resultado) throws SQLException{
        return new Informacion(
                resultado.getInt("id"),
                resultado.getString("titulo"),
                resultado.getString("descripcion")
        );
    }
}
