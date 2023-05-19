/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import graficos.Pantalla;
import mapa.cuadro.Cuadro;

/**
 *
 * @author maula
 */
public abstract class Mapa {

    protected int ancho;
    protected int alto;

    protected int[] cuadros;
    protected Cuadro[] cuadrosCatalogo;

    public Mapa(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        cuadros = new int[ancho * alto];
        //generarMapa();
    }

    public Mapa(String ruta,int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22, int p23, int p24, int p25, int p26, int p27, int p28, int p29, int p30, int p31, int aa1, int aa2, int aa3, int aa4) {
        cargarMapa(ruta);
        generarMapa(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,aa1,aa2,aa3,aa4);
    }

    protected void generarMapa(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22, int p23, int p24, int p25, int p26, int p27, int p28, int p29, int p30, int p31, int aa1, int aa2, int aa3, int aa4) {

    }

    protected void cargarMapa(String ruta) {

    }

    public void actualizar() {

    }

    public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {
        pantalla.estableceDiferencia(compensacionX, compensacionY);

        int o = compensacionX >> 5;
        int est = (compensacionX + pantalla.obtenAncho() + Cuadro.lado) >> 5;
        int n = compensacionY >> 5;
        int s = (compensacionY + pantalla.obtenAlto() + Cuadro.lado) >> 5;

        for (int y = n; y < s; y++) {
            for (int x = o; x < est; x++) {
                //obtenCuadro(x, y).mostrar(x, y, pantalla);
                if(x < 0 || y < 0 || x >= ancho || y >= alto){
                    Cuadro.VACIO.mostrar(x, y, pantalla);
                }else{
                    cuadrosCatalogo[x + y * ancho].mostrar(x, y, pantalla);
                }
            }
        }
    }

    public Cuadro obtenCuadro(final int x, final int y) {
        if (x < 0 || y < 0 || x >= ancho || y >= alto) {
            return Cuadro.VACIO;
        }
        switch (cuadros[x + y * ancho]) {
            case 0:
                return Cuadro.ASFALTO;
            case 1:
                return Cuadro.PARED;
            case 2:
                return Cuadro.CARRO1;
            case 3:
                return Cuadro.ESPACIO1;
            case 4:
                return Cuadro.ESPACIO2;
            case 5:
                return Cuadro.ESPACIO3;
            case 6:
                return Cuadro.ESPACIO4;
            case 7:
                return Cuadro.ESPACIO5;
            case 8:
                return Cuadro.ESPACIO6;
            case 9:
                return Cuadro.ESPACIO7;
            case 10:
                return Cuadro.ESPACIO8;
            case 11:
                return Cuadro.ESPACIO9;
            case 12:
                return Cuadro.ESPACIO10;
            case 13:
                return Cuadro.ESPACIO11;
            case 14:
                return Cuadro.ESPACIO12;
            case 15:
                return Cuadro.ESPACIO13;
            case 16:
                return Cuadro.ESPACIO14;
            case 17:
                return Cuadro.ESPACIO15;
            case 18:
                return Cuadro.ESPACIO16;
            case 19:
                return Cuadro.ESPACIO17;
            case 20:
                return Cuadro.ESPACIO18;
            case 21:
                return Cuadro.ESPACIO19;
            case 22:
                return Cuadro.ESPACIO20;
            case 23:
                return Cuadro.ESPACIO21;
            case 24:
                return Cuadro.ESPACIO22;
            case 25:
                return Cuadro.ESPACIO23;
            case 26:
                return Cuadro.ESPACIO24;
            case 27:
                return Cuadro.ESPACIO25;
            case 28:
                return Cuadro.ESPACIO26;
            case 29:
                return Cuadro.ESPACIO27;
            case 30:
                return Cuadro.ESPACIO28;
            case 31:
                return Cuadro.ESPACIO29;
            case 32:
                return Cuadro.ESPACIO30;
            case 33:
                return Cuadro.ESPACIO31;
            case 34:
                return Cuadro.ESPACIO32;
            case 35:
                return Cuadro.ESPACIO33;
            case 36:
                return Cuadro.ESPACIO34;
            case 37:
                return Cuadro.ADMIN;
            default:
                return Cuadro.VACIO;
        }
    }
}
