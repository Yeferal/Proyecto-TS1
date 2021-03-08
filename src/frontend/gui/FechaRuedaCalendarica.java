/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.gui;

import modelos.objetos.Winal;

/**
 *
 * @author LENOVO-PC
 */
public class FechaRuedaCalendarica {
    private int idNahual, idWinal, idCargador, idEnergia;
    private Winal winal;

    public FechaRuedaCalendarica(int idNahual, int idWinal, int idCargador, int idEnergia) {
        this.idNahual = idNahual;
        this.idWinal = idWinal;
        this.idCargador = idCargador;
        this.idEnergia = idEnergia;
    }

    public FechaRuedaCalendarica(int idNahual, int idWinal, Winal winal, int idCargador, int idEnergia) {
        this.idNahual = idNahual;
        this.idWinal = idWinal;
        this.idCargador = idCargador;
        this.idEnergia = idEnergia;
        this.winal = winal;
    }
    
    

    public int getIdNahual() {
        return idNahual;
    }

    public void setIdNahual(int idNahual) {
        this.idNahual = idNahual;
    }

    public int getIdWinal() {
        return idWinal;
    }

    public void setIdWinal(int idWinal) {
        this.idWinal = idWinal;
    }

    public int getIdCargador() {
        return idCargador;
    }

    public void setIdCargador(int idCargador) {
        this.idCargador = idCargador;
    }

    public int getIdEnergia() {
        return idEnergia;
    }

    public void setIdEnergia(int idEnergia) {
        this.idEnergia = idEnergia;
    }
    
    
    
}
