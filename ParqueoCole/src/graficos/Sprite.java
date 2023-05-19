/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

/**
 *
 * @author maula
 */
public class Sprite {

    private final int lado;

    private int x;
    private int y;

    public int[] pixeles;
    private HojaSprites hoja;

    //coleccion 
    public static final Sprite VACIO = new Sprite(32, 0);
    public static final Sprite ASFALTO = new Sprite(32, 0, 0, 0, HojaSprites.parqueo);
    public static final Sprite PARED = new Sprite(32, 1, 0, 0, HojaSprites.parqueo);
    public static final Sprite CARRO1 = new Sprite(32, 2, 0, 4, HojaSprites.parqueo);
    public static final Sprite CARRO2 = new Sprite(32, 2, 0, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO1 = new Sprite(32, 3, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO2 = new Sprite(32, 4, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO3 = new Sprite(32, 5, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO4 = new Sprite(32, 6, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO5 = new Sprite(32, 7, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO6 = new Sprite(32, 8, 0, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO7 = new Sprite(32, 9, 0, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO8 = new Sprite(32, 0, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO9 = new Sprite(32, 1, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO10 = new Sprite(32, 2, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO11 = new Sprite(32, 3, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO12 = new Sprite(32, 4, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO13 = new Sprite(32, 5, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO14 = new Sprite(32, 6, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO15 = new Sprite(32, 7, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO16 = new Sprite(32, 8, 1, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO17 = new Sprite(32, 9, 1, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO18 = new Sprite(32, 0, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO19 = new Sprite(32, 1, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO20 = new Sprite(32, 2, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO21 = new Sprite(32, 3, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO22 = new Sprite(32, 4, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO23 = new Sprite(32, 5, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO24 = new Sprite(32, 6, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO25 = new Sprite(32, 7, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO26 = new Sprite(32, 8, 2, 4, HojaSprites.parqueo);
    public static final Sprite ESPACIO27 = new Sprite(32, 9, 2, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO28 = new Sprite(32, 0, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO29 = new Sprite(32, 1, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO30 = new Sprite(32, 2, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO31 = new Sprite(32, 3, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO32 = new Sprite(32, 4, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO33 = new Sprite(32, 5, 3, 5, HojaSprites.parqueo);
    public static final Sprite ESPACIO34 = new Sprite(32, 6, 3, 5, HojaSprites.parqueo);
    public static final Sprite ADMIN = new Sprite(32, 7, 3, 4, HojaSprites.parqueo);
    //fin de la coleccion

    public Sprite(final int lado, final int columna, final int fila, final int version, final HojaSprites hoja) {
        this.lado = lado;

        pixeles = new int[lado * lado];

        this.x = columna * lado;
        this.y = fila * lado;
        this.hoja = hoja;

        cargarSprite(version);
    }

    public Sprite(final int lado, final int color) {
        this.lado = lado;
        pixeles = new int[lado * lado];

        for (int i = 0; i < pixeles.length; i++) {
            pixeles[i] = color;
        }
    }

    public int obtenLado() {
        return lado;
    }

    private void cargarSprite(int version) {
        if (version == 0) {
            cargarNormal();
        } else {
            cargarManipulada(version);
        }
    }

    private void cargarNormal() {
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
            }
        }
    }

    private void cargarManipulada(int version) {
        int[] pixelesTemporales = iniciarPixelesTemporales();

        switch (version) {
            case 1:
                invertirX(pixelesTemporales);
                break;
            case 2:
                invertirY(pixelesTemporales);
                break;
            case 3:
                invertirYX(pixelesTemporales);
                break;
            case 4:
                rotar90I(pixelesTemporales);
                break;
            case 5:
                rotar90D(pixelesTemporales);
                break;
            case 6:
                rotarI90InvertirY(pixelesTemporales);
                break;
            case 7:
                rotarD90InvertirY(pixelesTemporales);
                break;
            default:
                cargarNormal();
        }
    }

    private int[] iniciarPixelesTemporales() {
        int[] pixelesTemporales = new int[lado * lado];
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.obtenAncho()];
            }
        }

        return pixelesTemporales;
    }

    //i
    private void invertirX(int[] pixelesTemporales) {
        int i = 0;
        for (int y = 0; y < lado; y++) {
            for (int x = lado - 1; x > -1; x--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //2
    private void invertirY(int[] pixelesTemporales) {
        int i = 0;
        for (int y = lado - 1; y > -1; y--) {
            for (int x = 0; x < lado; x++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //3
    private void invertirYX(int[] pixelesTemporales) {
        for(int i = 0; i < pixeles.length; i++){
            pixeles[i] = pixelesTemporales[pixelesTemporales.length - 1 - i];
        }
    }

    //4
    private void rotar90I(int[] pixelesTemporales) {
        int i = 0;
        for (int x = lado - 1; x > -1; x--) {
            for (int y = 0; y < lado; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //5
    private void rotar90D(int[] pixelesTemporales) {
        int i = 0;
        for (int x = 0; x < lado; x++) {
            for (int y = lado - 1; y > -1; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //6
    private void rotarI90InvertirY(int[] pixelesTemporales) {
        int i = 0;
        for (int x = 0; x < lado; x++) {
            for (int y = 0; y < lado; y++) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }

    //7
    private void rotarD90InvertirY(int[] pixelesTemporales) {
        int i = 0;
        for (int x = lado - 1; x > -1; x--) {
            for (int y = lado - 1; y > -1; y--) {
                pixeles[i] = pixelesTemporales[x + y * lado];
                i++;
            }
        }
    }
}
