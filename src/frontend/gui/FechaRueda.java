/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend.gui;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.database.FechaHaabDb;
import modelos.database.Utilidades;
import modelos.objetos.FechaHaab;
import principal.backend.calendari_cholquij.calcular_fecha.CalcularFecha;

/**
 *
 * @author LENOVO-PC
 */
public class FechaRueda {
    
    FechaHaabDb acceso = new FechaHaabDb();
    int idEnergia, idCargador;
    
    public FechaRuedaCalendarica getFechaRueda(JDateChooser fechaChoose){
        Date fecha = fechaChoose.getDate();
        FechaHaab fechaActual = acceso.getFechaEspecifica(Utilidades.DateToLocalDate(fecha));
        return new FechaRuedaCalendarica(nahual(timeCholqij(fechaChoose.getCalendar().getTime().getTime()))
                , fechaActual.getWinal().getId(), fechaActual.getWinal(), 0, 0);
    }
    
    public int nahual(int cont){
        //System.out.println("Contador " + cont);
        int contador = cont;
        int contadorNahual = -5;
        if (contador < 0) {
            while (contador != 0) {
                if (contadorNahual == 20) {
                    contadorNahual = 1;
                } else {
                    contadorNahual++;
                } contador++;
            } return contadorNahual;
        }
        while (contador != 0) {
            if (contadorNahual == 1) {
                contadorNahual = 20;
            } else {
                contadorNahual--;
            } contador--;
        } return contadorNahual;
        
    }
    
    public int timeCholqij(long date){
        try {
            String string = "Nov 15, 2020 00:00:00 AM";
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.ROOT);
            Date datePivote = sdf.parse(string);
//            System.out.println("DATE PIVOTE " + datePivote);
            long regresar = TimeUnit.DAYS.convert(datePivote.getTime() - date, TimeUnit.MILLISECONDS);
            return (int) regresar;
        } catch (ParseException ex) {
            Logger.getLogger(CalcularFecha.class.getName()).log(Level.SEVERE, null, ex);
        } return 1;
    }
    
//    private void calcularFecha(){
//        int numNahual = nahual(timeCholqij(date.getCalendar().getTime().getTime()));
//        indice = numNahual;
//        pintarNahuales();
//        setPosiciones();
//    }
    
}
