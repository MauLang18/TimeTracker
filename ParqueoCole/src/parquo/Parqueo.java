/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquo;

import com.mysql.jdbc.Connection;
import contol.Teclado;
import datos.*;
import graficos.Pantalla;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logica.Acciones;
import mapa.Mapa;
import mapa.MapaCargado;
import mapa.MapaGenerado;
import modelo.Conexion;
import vista.frmBusqueda;

/**
 *
 * @author maula
 */
public class Parqueo extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    private static final int ANCHO = 800;
    private static final int ALTO = 600;

    private static volatile boolean enFuncionamiento = false;

    private static final String NOMBRE = "Parqueo";

    private static String CONTADOR_APS = "";
    private static String CONTADOR_FPS = "";

    private static int aps = 0;
    private static int fps = 0;

    private static int x = 0;
    private static int y = 0;

    private static JFrame ventana;
    private static Thread thread;
    private static Teclado teclado;
    private static Pantalla pantalla;
    private static Acciones acciones;

    Espacio4 m1 = new Espacio4();
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
    Espacio34 m31 = new Espacio34();

    EspacioA1 a1 = new EspacioA1();
    EspacioA2 a2 = new EspacioA2();
    EspacioA3 a3 = new EspacioA3();
    EspacioA4 a4 = new EspacioA4();

    public int p1;
    public int p2;
    public int p3;
    public int p4;
    public int p5;
    public int p6;
    public int p7;
    public int p8;
    public int p9;
    public int p10;
    public int p11;
    public int p12;
    public int p13;
    public int p14;
    public int p15;
    public int p16;
    public int p17;
    public int p18;
    public int p19;
    public int p20;
    public int p21;
    public int p22;
    public int p23;
    public int p24;
    public int p25;
    public int p26;
    public int p27;
    public int p28;
    public int p29;
    public int p30;
    public int p31;

    public int aa1;
    public int aa2;
    public int aa3;
    public int aa4;

    private static Mapa mapa;

    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();

    public Parqueo() {
        setPreferredSize(new Dimension(ANCHO, ALTO));

        pantalla = new Pantalla(ANCHO, ALTO);

        for (int i = 4; i <= 34; i++) {
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
                            System.out.println("m");
                    }

                }

            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }

        p1 = m1.getE();
        p2 = m2.getE();
        p3 = m3.getE();
        p4 = m4.getE();
        p5 = m5.getE();
        p6 = m6.getE();
        p7 = m7.getE();
        p8 = m8.getE();
        p9 = m9.getE();
        p10 = m10.getE();
        p11 = m11.getE();
        p12 = m12.getE();
        p13 = m13.getE();
        p14 = m14.getE();
        p15 = m15.getE();
        p16 = m16.getE();
        p17 = m17.getE();
        p18 = m18.getE();
        p19 = m19.getE();
        p20 = m20.getE();
        p21 = m21.getE();
        p22 = m22.getE();
        p23 = m23.getE();
        p24 = m24.getE();
        p25 = m25.getE();
        p26 = m26.getE();
        p27 = m27.getE();
        p28 = m28.getE();
        p29 = m29.getE();
        p30 = m30.getE();
        p31 = m31.getE();

        for (int i = 1; i <= 4; i++) {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConexion();
                PreparedStatement ps = null;
                ResultSet rs = null;

                String sql = "SELECT estado1 FROM tb_administrativos WHERE espacio = ?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, i);
                rs = ps.executeQuery();

                while (rs.next()) {

                    switch (i) {
                        case 1:
                            a1.setE(rs.getInt("estado1"));
                            continue;
                        case 2:
                            a2.setE(rs.getInt("estado1"));
                            continue;
                        case 3:
                            a3.setE(rs.getInt("estado1"));
                            continue;
                        case 4:
                            a4.setE(rs.getInt("estado1"));
                            continue;
                        default:
                            System.out.println("a");
                    }

                }

            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }
        }

        aa1 = a1.getE();
        aa2 = a2.getE();
        aa3 = a3.getE();
        aa4 = a4.getE();

        //mapa = new MapaGenerado(128, 128);
        mapa = new MapaCargado("/recuroso/mapaParqueo.png", p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, aa1, aa2, aa3, aa4);

        teclado = new Teclado();
        addKeyListener(teclado);

        acciones = new Acciones(x, y);

        ventana = new JFrame(NOMBRE);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setLayout(new BorderLayout());
        ventana.add(this, BorderLayout.CENTER);
        ventana.setUndecorated(true);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);

    }

    public static void main(String[] args) {
        Parqueo parqueo = new Parqueo();
        parqueo.iniciar();

        frmBusqueda bus = new frmBusqueda();
        bus.setVisible(true);
    }

    public synchronized void iniciar() {
        enFuncionamiento = true;

        thread = new Thread(this, "Graficos");
        thread.start();
    }

    private synchronized void detener() {
        enFuncionamiento = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actualizar() {
        teclado.actualizar();

        if (teclado.arriba) {
            y--;
        }
        if (teclado.abajo) {
            y++;
        }
        if (teclado.derecha) {
            x++;
        }
        if (teclado.izquierda) {
            x--;
        }
        if (teclado.salir) {
            ventana.dispose();
            
        }
        if (teclado.a) {
            System.out.println("4: " + p1);
            System.out.println("5: " + p2);
        }

        aps++;
    }

    private void mostrar() {
        BufferStrategy estrategia = getBufferStrategy();

        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }

        pantalla.limpiar();
        mapa.mostrar(x, y, pantalla);

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);

        Graphics g = estrategia.getDrawGraphics();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.white);
        //g.fillRect(ANCHO / 2, ALTO / 2, 32, 32);
        g.drawString(CONTADOR_APS, 10, 20);
        g.drawString(CONTADOR_FPS, 10, 35);
        g.dispose();

        estrategia.show();

        fps++;
    }

    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido;
        double delta = 0;

        requestFocus();

        while (enFuncionamiento) {
            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

            while (delta >= 1) {
                actualizar();
                delta--;
            }

            mostrar();

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                CONTADOR_APS = "APS: " + aps;
                CONTADOR_FPS = "FPS: " + fps;

                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

}
