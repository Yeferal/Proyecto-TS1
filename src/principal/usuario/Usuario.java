/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal.usuario;

import java.util.Date;

/**
 *
 * @author sergio
 */
public class Usuario {
    private String username;
    private String email;
    private String nombre;
    private String apellido;    
    private Date fechaDeNacimiento;
    private String telefono;
    private int role;
    public static final int ADMIN_ROLE=1;

    public Usuario(String username, String email, String nombre, String apellido, Date fechaDeNacimiento, String telefono,int role) {
        this.username = username;
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.telefono = telefono;
        this.role=role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getRole() {
        return role;
    }
    
    
    
    
}
