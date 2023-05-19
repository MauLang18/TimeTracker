/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.mysql.jdbc.Connection;
import datos.*;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import static logica.FechaHora.fecha;
import modelo.Conexion;
import modelo.espacio;
import parquo.Parqueo;

/**
 *
 * @author maula
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    espacio mod = new espacio();
    /*Espacio4 m1 = new Espacio4();
    Espacio5 m2 = new Espacio5();
    Espacio6 m3 = new Espacio6();
    Espacio7 m4 = new Espacio7();
    Espacio8 m5 = new Espacio8();
    Espacio9 m6 = new Espacio9();
    Espacio10 m7 = new Espacio10();
    Espacio11 m8 = new Espacio11();
    Espacio12 m9 = new Espacio12();
    Espacio13 m10 = new Espacio13();
    Espacio14 m11 = new Espacio14();
    Espacio15 m12 = new Espacio15();
    Espacio16 m13 = new Espacio16();
    Espacio17 m14 = new Espacio17();
    Espacio18 m15 = new Espacio18();
    Espacio19 m16 = new Espacio19();
    Espacio20 m17 = new Espacio20();
    Espacio21 m18 = new Espacio21();
    Espacio22 m19 = new Espacio22();
    Espacio23 m20 = new Espacio23();
    Espacio24 m21 = new Espacio24();
    Espacio25 m22 = new Espacio25();
    Espacio26 m23 = new Espacio26();
    Espacio27 m24 = new Espacio27();
    Espacio28 m25 = new Espacio28();
    Espacio29 m26 = new Espacio29();
    Espacio30 m27 = new Espacio30();
    Espacio31 m28 = new Espacio31();
    Espacio32 m29 = new Espacio32();
    Espacio33 m30 = new Espacio33();
    Espacio34 m31 = new Espacio34();*/

    public frmPrincipal() {
        initComponents();

        mod.setFecha(fecha());
        setTitle("Parqueo");
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/parqueo32.png")).getImage());

        /*for (int i = 4; i <= 34; i++) {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConexion();
                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql = "SELECT estado1 FROM tb_asignar WHERE espacio = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, i);
                rs = ps.executeQuery();

                while (rs.next()) {

                    switch (i) {
                        case 4:
                            m1.setE(rs.getInt("estado1"));
                            continue;
                        case 5:
                            m2.setE(rs.getInt("estado1"));
                            continue;
                        case 6:
                            m3.setE(rs.getInt("estado1"));
                            continue;
                        case 7:
                            m4.setE(rs.getInt("estado1"));
                            continue;
                        case 8:
                            m5.setE(rs.getInt("estado1"));
                            continue;
                        case 9:
                            m6.setE(rs.getInt("estado1"));
                            continue;
                        case 10:
                            m7.setE(rs.getInt("estado1"));
                            continue;
                        case 11:
                            m8.setE(rs.getInt("estado1"));
                            continue;
                        case 12:
                            m9.setE(rs.getInt("estado1"));
                            continue;
                        case 13:
                            m10.setE(rs.getInt("estado1"));
                            continue;
                        case 14:
                            m11.setE(rs.getInt("estado1"));
                            continue;
                        case 15:
                            m12.setE(rs.getInt("estado1"));
                            continue;
                        case 16:
                            m13.setE(rs.getInt("estado1"));
                            continue;
                        case 17:
                            m14.setE(rs.getInt("estado1"));
                            continue;
                        case 18:
                            m15.setE(rs.getInt("estado1"));
                            continue;
                        case 19:
                            m16.setE(rs.getInt("estado1"));
                            continue;
                        case 20:
                            m17.setE(rs.getInt("estado1"));
                            continue;
                        case 21:
                            m18.setE(rs.getInt("estado1"));
                            continue;
                        case 22:
                            m19.setE(rs.getInt("estado1"));
                            continue;
                        case 23:
                            m20.setE(rs.getInt("estado1"));
                            continue;
                        case 24:
                            m21.setE(rs.getInt("estado1"));
                            continue;
                        case 25:
                            m22.setE(rs.getInt("estado1"));
                            continue;
                        case 26:
                            m23.setE(rs.getInt("estado1"));
                            continue;
                        case 27:
                            m24.setE(rs.getInt("estado1"));
                            continue;
                        case 28:
                            m25.setE(rs.getInt("estado1"));
                            continue;
                        case 29:
                            m26.setE(rs.getInt("estado1"));
                            continue;
                        case 30:
                            m27.setE(rs.getInt("estado1"));
                            continue;
                        case 31:
                            m28.setE(rs.getInt("estado1"));
                            continue;
                        case 32:
                            m29.setE(rs.getInt("estado1"));
                            continue;
                        case 33:
                            m30.setE(rs.getInt("estado1"));
                            continue;
                        case 34:
                            m31.setE(rs.getInt("estado1"));
                            continue;
                        default:
                            System.out.println("a");
                    }

                }

            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnParqueo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnPersonas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnPersonas1 = new javax.swing.JButton();
        btnAdministrativos = new javax.swing.JButton();
        btnReservacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(18, 110, 130));

        btnParqueo.setBackground(new java.awt.Color(216, 227, 231));
        btnParqueo.setText("Parqueo");
        btnParqueo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParqueoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(216, 227, 231));
        jButton2.setText("Mapa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnPersonas.setBackground(new java.awt.Color(216, 227, 231));
        btnPersonas.setText("Personas");
        btnPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonasActionPerformed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(216, 227, 231));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnPersonas1.setBackground(new java.awt.Color(216, 227, 231));
        btnPersonas1.setText("Registro");
        btnPersonas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonas1ActionPerformed(evt);
            }
        });

        btnAdministrativos.setBackground(new java.awt.Color(216, 227, 231));
        btnAdministrativos.setText("Administrativos");
        btnAdministrativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrativosActionPerformed(evt);
            }
        });

        btnReservacion.setBackground(new java.awt.Color(216, 227, 231));
        btnReservacion.setText("Reservacion");
        btnReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(87, 123, 193));
        jLabel1.setText("Desarrollado por: Maurice Lang Bonilla");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnParqueo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPersonas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdministrativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnParqueo)
                .addGap(72, 72, 72)
                .addComponent(jButton2)
                .addGap(80, 80, 80)
                .addComponent(btnPersonas)
                .addGap(80, 80, 80)
                .addComponent(btnPersonas1)
                .addGap(80, 80, 80)
                .addComponent(btnAdministrativos)
                .addGap(80, 80, 80)
                .addComponent(btnReservacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1208, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Parqueo parqueo = new Parqueo();
        parqueo.iniciar();

        frmBusqueda bus = new frmBusqueda();
        bus.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonasActionPerformed
        fmPersonal af = new fmPersonal();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnPersonasActionPerformed

    private void btnParqueoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParqueoActionPerformed
        fmParqueo af = new fmParqueo();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnParqueoActionPerformed

    private void btnPersonas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonas1ActionPerformed
        fmRegistro af = new fmRegistro();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnPersonas1ActionPerformed

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyPressed

    }//GEN-LAST:event_jPanel1KeyPressed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAdministrativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrativosActionPerformed
        fmAdministrativos af = new fmAdministrativos();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnAdministrativosActionPerformed

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        fmReservacion af = new fmReservacion();
        escritorio.add(af);
        af.show();
    }//GEN-LAST:event_btnReservacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrativos;
    private javax.swing.JButton btnParqueo;
    private javax.swing.JButton btnPersonas;
    private javax.swing.JButton btnPersonas1;
    private javax.swing.JButton btnReservacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
