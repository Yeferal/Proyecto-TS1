
package api.login;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Login extends javax.swing.JFrame {

    FondoPanel fondoPanel = new FondoPanel();
    
    public Login() {
        this.setContentPane(fondoPanel);
        initComponents();
        this.setLocationRelativeTo(null);
        ImageIcon imIcon = new ImageIcon("src/api/login/imagenes/icono.png");
        Icon icono = new ImageIcon(imIcon.getImage().getScaledInstance(labelIcono.getWidth(), labelIcono.getHeight(), Image.SCALE_DEFAULT));
        labelIcono.setIcon(icono);
        ImageIcon imIconExit = new ImageIcon("src/api/login/imagenes/salir.png");
        Icon iconoExit = new ImageIcon(imIconExit.getImage().getScaledInstance(botonSalir.getWidth(), botonSalir.getHeight(), Image.SCALE_DEFAULT));
        botonSalir.setIcon(iconoExit);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new FondoPanel();
        labelIcono = new javax.swing.JLabel();
        textFieldCorreo = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonSingIn = new javax.swing.JButton();
        botonSingUp = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        checkBoxRecordar = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        textFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldCorreojTextField2ActionPerformed(evt);
            }
        });

        correo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setText("Correo");

        jLabel28.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Contraseña");

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setForeground(new java.awt.Color(255, 255, 255));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirbuttonExitActionPerformed(evt);
            }
        });

        botonSingIn.setBackground(new java.awt.Color(247, 228, 22));
        botonSingIn.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        botonSingIn.setText("SING IN");
        botonSingIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSingInActionPerformed(evt);
            }
        });

        botonSingUp.setBackground(new java.awt.Color(158, 247, 22));
        botonSingUp.setText("SING UP");

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        checkBoxRecordar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        checkBoxRecordar.setForeground(new java.awt.Color(255, 255, 255));
        checkBoxRecordar.setText("Recordar Sesion");
        checkBoxRecordar.setOpaque(false);
        checkBoxRecordar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxRecordarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(247, 228, 22));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(209, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textFieldCorreo)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(correo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(checkBoxRecordar)
                        .addGap(65, 65, 65)
                        .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 204, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(botonSingUp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(196, 196, 196))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(correo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkBoxRecordar)
                    .addComponent(botonSingIn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSingUp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirbuttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirbuttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_botonSalirbuttonExitActionPerformed

    private void textFieldCorreojTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldCorreojTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldCorreojTextField2ActionPerformed

    private void checkBoxRecordarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxRecordarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkBoxRecordarActionPerformed

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            //LOGUEAR
            botonSingIn.doClick();
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void botonSingInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSingInActionPerformed
        JOptionPane.showMessageDialog(null, "Hola");
    }//GEN-LAST:event_botonSingInActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JButton botonSingIn;
    private javax.swing.JButton botonSingUp;
    private javax.swing.JCheckBox checkBoxRecordar;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelIcono;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField textFieldCorreo;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel{
        
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("imagenes/tikal.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
    
    
    
}
