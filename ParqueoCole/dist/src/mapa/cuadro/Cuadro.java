/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

/**
 *
 * @author maula
 */
public class Cuadro {
    public int x;
    public int y;
    
    public Sprite sprite;
    
    public static final int lado = 32;
    
    //coleccion
    public static final Cuadro VACIO = new Cuadro(Sprite.VACIO);
    public static final Cuadro ASFALTO = new Cuadro(Sprite.ASFALTO);
    public static final Cuadro PARED = new Cuadro(Sprite.PARED);
    public static final Cuadro CARRO1 = new Cuadro(Sprite.CARRO1);
    public static final Cuadro CARRO2 = new Cuadro(Sprite.CARRO2);
    public static final Cuadro ESPACIO1 = new Cuadro(Sprite.ESPACIO1);
    public static final Cuadro ESPACIO2 = new Cuadro(Sprite.ESPACIO2);
    public static final Cuadro ESPACIO3 = new Cuadro(Sprite.ESPACIO3);
    public static final Cuadro ESPACIO4 = new Cuadro(Sprite.ESPACIO4);
    public static final Cuadro ESPACIO5 = new Cuadro(Sprite.ESPACIO5);
    public static final Cuadro ESPACIO6 = new Cuadro(Sprite.ESPACIO6);
    public static final Cuadro ESPACIO7 = new Cuadro(Sprite.ESPACIO7);
    public static final Cuadro ESPACIO8 = new Cuadro(Sprite.ESPACIO8);
    public static final Cuadro ESPACIO9 = new Cuadro(Sprite.ESPACIO9);
    public static final Cuadro ESPACIO10 = new Cuadro(Sprite.ESPACIO10);
    public static final Cuadro ESPACIO11 = new Cuadro(Sprite.ESPACIO11);
    public static final Cuadro ESPACIO12 = new Cuadro(Sprite.ESPACIO12);
    public static final Cuadro ESPACIO13 = new Cuadro(Sprite.ESPACIO13);
    public static final Cuadro ESPACIO14 = new Cuadro(Sprite.ESPACIO14);
    public static final Cuadro ESPACIO15 = new Cuadro(Sprite.ESPACIO15);
    public static final Cuadro ESPACIO16 = new Cuadro(Sprite.ESPACIO16);
    public static final Cuadro ESPACIO17 = new Cuadro(Sprite.ESPACIO17);
    public static final Cuadro ESPACIO18 = new Cuadro(Sprite.ESPACIO18);
    public static final Cuadro ESPACIO19 = new Cuadro(Sprite.ESPACIO19);
    public static final Cuadro ESPACIO20 = new Cuadro(Sprite.ESPACIO20);
    public static final Cuadro ESPACIO21 = new Cuadro(Sprite.ESPACIO21);
    public static final Cuadro ESPACIO22 = new Cuadro(Sprite.ESPACIO22);
    public static final Cuadro ESPACIO23 = new Cuadro(Sprite.ESPACIO23);
    public static final Cuadro ESPACIO24 = new Cuadro(Sprite.ESPACIO24);
    public static final Cuadro ESPACIO25 = new Cuadro(Sprite.ESPACIO25);
    public static final Cuadro ESPACIO26 = new Cuadro(Sprite.ESPACIO26);
    public static final Cuadro ESPACIO27 = new Cuadro(Sprite.ESPACIO27);
    public static final Cuadro ESPACIO28 = new Cuadro(Sprite.ESPACIO28);
    public static final Cuadro ESPACIO29 = new Cuadro(Sprite.ESPACIO29);
    public static final Cuadro ESPACIO30 = new Cuadro(Sprite.ESPACIO30);
    public static final Cuadro ESPACIO31 = new Cuadro(Sprite.ESPACIO31);
    public static final Cuadro ESPACIO32 = new Cuadro(Sprite.ESPACIO32);
    public static final Cuadro ESPACIO33 = new Cuadro(Sprite.ESPACIO33);
    public static final Cuadro ESPACIO34 = new Cuadro(Sprite.ESPACIO34);
    public static final Cuadro ADMIN = new Cuadro(Sprite.ADMIN);
    //fin
    
    public Cuadro(Sprite sprite){
        this.sprite = sprite;
    }
    
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrarCuadro(x << 5, y << 5, this);
    }
    
    public boolean solido(){
        return false;
    }
}
