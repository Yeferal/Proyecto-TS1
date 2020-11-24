
package gui.infonahuales;

import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import modelos.database.ConexionDb;
import modelos.database.NahualDb;
import modelos.objetos.Nahual;

public class VentanaInfoNahuales extends javax.swing.JFrame {
    
    //ManejadorNahualGUI manejadorNahualGUI = new ManejadorNahualGUI();
    private NahualDb nahualDb = new NahualDb();
    private ArrayList<Nahual> listaNahuales = null;
    private ConexionDb conexionDb = new ConexionDb();
    private int indice = 0;
    
    public VentanaInfoNahuales() {
        
            initComponents();
            this.setLocationRelativeTo(null);
            ImageIcon imIconAnterior = new ImageIcon("./src/gui/imagenes/anterior.png");
            Icon iconoAnterior = new ImageIcon(imIconAnterior.getImage().getScaledInstance(botonAnterior.getWidth(), botonAnterior.getHeight(), Image.SCALE_DEFAULT));
            botonAnterior.setIcon(iconoAnterior);
            ImageIcon imIconSiguiente = new ImageIcon("./src/gui/imagenes/siguiente.png");
            Icon iconoSiguiente = new ImageIcon(imIconSiguiente.getImage().getScaledInstance(botonSiguiente.getWidth(), botonSiguiente.getHeight(), Image.SCALE_DEFAULT));
            botonSiguiente.setIcon(iconoSiguiente);
            
            //Levantamos el listado de nahuales en la db y lo agragamos y lista ya estaria fucionando al 100
            //conexionDb.obtenerConexion();
            listaNahuales = (ArrayList<Nahual>) nahualDb.getNahuales();
            pintar();
        
    }
    
    private boolean verificarNahuales(){
        if(listaNahuales!=null && listaNahuales.size()>2){
            return true;
        }
        return false;
    }
    
    private Icon getIconNahual(Nahual nahual, JLabel label){
        ImageIcon imIcon = new ImageIcon(nahual.getImagen().getDirEscritorio());
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        return icono;
    }
    
    public void pintarNahueles(){
        if(indice == 0){
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(listaNahuales.size()-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice+1), labelDerecha));
        }else if(indice == listaNahuales.size()-1){
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(0), labelDerecha));
        }else{
            labalIzquierda.setIcon(getIconNahual(listaNahuales.get(indice-1), labalIzquierda));
            labelPrincipal.setIcon(getIconNahual(listaNahuales.get(indice), labelPrincipal));
            labelDerecha.setIcon(getIconNahual(listaNahuales.get(indice+1), labelDerecha));
        }
        textPaneDes.setText(listaNahuales.get(indice).getDescripcion());
        textPaneSig.setText(listaNahuales.get(indice).getSignificado());
        labelNombre.setText(listaNahuales.get(indice).getId()+". "+listaNahuales.get(indice).getNombre());
    }
    private void pintar(){
        if(verificarNahuales()){
            pintarNahueles();
        }
    }
    
    private void anterior(){
        if(indice==0)
            indice = listaNahuales.size()-1;
        else
            indice--;
    }
    private void siguiente(){
        if(indice==(listaNahuales.size()-1))
            indice = 0;
        else
            indice++;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelNav = new javax.swing.JPanel();
        labelDerecha = new javax.swing.JLabel();
        labalIzquierda = new javax.swing.JLabel();
        labelPrincipal = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        botonSiguiente = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        labelDescripcion = new javax.swing.JLabel();
        labelSignificado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneDes = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneSig = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelDerecha.setEnabled(false);
        labelDerecha.setOpaque(true);

        labalIzquierda.setEnabled(false);
        labalIzquierda.setOpaque(true);

        labelNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        botonSiguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSiguienteMouseClicked(evt);
            }
        });

        botonAnterior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAnteriorMouseClicked(evt);
            }
        });

        labelDescripcion.setText("Descripcion");

        labelSignificado.setText("Significado");

        textPaneDes.setEditable(false);
        jScrollPane1.setViewportView(textPaneDes);

        textPaneSig.setEditable(false);
        jScrollPane2.setViewportView(textPaneSig);

        javax.swing.GroupLayout PanelNavLayout = new javax.swing.GroupLayout(PanelNav);
        PanelNav.setLayout(PanelNavLayout);
        PanelNavLayout.setHorizontalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNavLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(labelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelDescripcion)
                    .addComponent(labelSignificado)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNavLayout.setVerticalGroup(
            PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNavLayout.createSequentialGroup()
                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addGroup(PanelNavLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelDerecha, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labalIzquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PanelNavLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(labelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(botonAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelNavLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(botonSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(labelSignificado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        getContentPane().add(PanelNav, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAnteriorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAnteriorMouseClicked
        if(verificarNahuales()){
            anterior();
            pintarNahueles();
        }
    }//GEN-LAST:event_botonAnteriorMouseClicked

    private void botonSiguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSiguienteMouseClicked
        if(verificarNahuales()){
            siguiente();
            pintarNahueles();
        }
    }//GEN-LAST:event_botonSiguienteMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelNav;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labalIzquierda;
    private javax.swing.JLabel labelDerecha;
    private javax.swing.JLabel labelDescripcion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPrincipal;
    private javax.swing.JLabel labelSignificado;
    private javax.swing.JTextPane textPaneDes;
    private javax.swing.JTextPane textPaneSig;
    // End of variables declaration//GEN-END:variables
}
