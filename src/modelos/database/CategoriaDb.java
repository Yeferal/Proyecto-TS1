/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import modelos.objetos.Categoria;

/**
 *
 * @author jose_
 */
public class CategoriaDb {
            public void crearCategoria(Categoria categoriaACrear) {//creamos una nueva categoria
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("INSERT INTO Categoria "
                    + "(id, nombre) VALUES (?,?);");
            statement.setInt(1, categoriaACrear.getId());
            statement.setString(2, categoriaACrear.getNombre());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n Ingrese otra categoria, asegurese que el identificador '" + categoriaACrear.getId() + "' no se repita");
        }
    }

    public void actualizarCategoria(Categoria categoriaActualizar) {//actualizamos categoria
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("UPDATE Categoria SET "
                    + "nombre=? WHERE id=? ;");
            statement.setString(1, categoriaActualizar.getNombre());
            statement.setInt(2, categoriaActualizar.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n NO se actualizo la categoria. Asegurese que exista la categoria");
        }

    }

    public void eliminarCategoria(Categoria categoriaEliminar) {//eliminamos categoria
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("DELETE FROM Categoria WHERE id=?;");
            statement.setInt(1, categoriaEliminar.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n No se elimino la categoria. Asegurese que  exista la categoria");
        }
    }

    public LinkedList<Categoria> leerCategorias() { //mostramos todas las categorias  y devolvemos en una lista
        LinkedList<Categoria> listaCategorias = new LinkedList<>();
        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Categoria;");
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                Categoria categoria = convertirACategoria(resultado);
                listaCategorias.add(categoria);
            }
        } catch (SQLException ex) {
            System.out.println("No se leyeron las categorias de la DB");
        }
        return listaCategorias;
    }

    public Categoria leerCategoria(Categoria rolABuscar) {//leemos una categoria en especifico y lo devolvemos
        Categoria rolUsuario = null;

        try {
            PreparedStatement statement = ConexionDb.conexion.prepareStatement("SELECT * FROM Categoria WHERE id= ? ;");
            statement.setInt(1, rolABuscar.getId());
            ResultSet resultado = statement.executeQuery();

            while (resultado.next()) {
                rolUsuario = convertirACategoria(resultado);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: \n no se encontro la categoria ");
        }
        return rolUsuario;
    }

    public Categoria convertirACategoria(ResultSet resultado) {
        Categoria rolDevolver = null;
        try {
            rolDevolver = new Categoria(resultado.getInt(1), resultado.getString("nombre"));
        } catch (SQLException ex) {
            System.out.println("error en conversion de categoria");
        }
        return rolDevolver;
    }

    
}
