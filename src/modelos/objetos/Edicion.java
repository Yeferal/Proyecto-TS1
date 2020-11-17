/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.objetos;

import java.sql.Date;

/**
 *
 * @author jose_
 */
public class Edicion {
    
    private int id;
    private String usuario;
    private HechoHistorico hechoHistorico;
    private Date fecha;
    private boolean creacion;

    public Edicion() {
    }

    public Edicion(int id, String usuario, HechoHistorico hechoHistorico, Date fecha, boolean creacion) {
        this.id = id;
        this.usuario = usuario;
        this.hechoHistorico = hechoHistorico;
        this.fecha = fecha;
        this.creacion = creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public HechoHistorico getHechoHistorico() {
        return hechoHistorico;
    }

    public void setHechoHistorico(HechoHistorico hechoHistorico) {
        this.hechoHistorico = hechoHistorico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isCreacion() {
        return creacion;
    }

    public void setCreacion(boolean creacion) {
        this.creacion = creacion;
    }
    
}
