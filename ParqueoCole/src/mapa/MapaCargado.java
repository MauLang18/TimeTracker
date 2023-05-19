/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

import com.mysql.jdbc.Connection;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import mapa.cuadro.Cuadro;
import datos.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Conexion;

/**
 *
 * @author maula
 */
public class MapaCargado extends Mapa {

    private int[] pixeles;

    public MapaCargado(String ruta, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22, int p23, int p24, int p25, int p26, int p27, int p28, int p29, int p30, int p31, int aa1, int aa2, int aa3, int aa4) {
        super(ruta, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, aa1, aa2, aa3, aa4);
    }

    protected void cargarMapa(String ruta) {
        try {
            BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));

            ancho = imagen.getWidth();
            alto = imagen.getHeight();

            cuadrosCatalogo = new Cuadro[ancho * alto];
            pixeles = new int[ancho * alto];

            imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void generarMapa(int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8, int p9, int p10, int p11, int p12, int p13, int p14, int p15, int p16, int p17, int p18, int p19, int p20, int p21, int p22, int p23, int p24, int p25, int p26, int p27, int p28, int p29, int p30, int p31, int aa1, int aa2, int aa3, int aa4) {
        for (int i = 0; i < pixeles.length; i++) {
            switch (pixeles[i]) {
                case 0xffff9600:
                    cuadrosCatalogo[i] = Cuadro.PARED;
                    continue;
                case 0xfffb0707:
                    switch (aa1) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                    }
                    continue;
                case 0xff356606:
                    switch (aa2) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                    }
                    continue;
                case 0xff345712:
                    switch (aa3) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                    }
                    continue;
                case 0xffdadc47:
                    switch (aa4) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ADMIN;
                    }
                    continue;
                case 0xff37260e:
                    cuadrosCatalogo[i] = Cuadro.ASFALTO;
                    continue;
                case 0xff920d0d:
                    cuadrosCatalogo[i] = Cuadro.ESPACIO1;
                    continue;
                case 0xff750b0b:
                    cuadrosCatalogo[i] = Cuadro.ESPACIO2;
                    continue;
                case 0xff4f0808:
                    cuadrosCatalogo[i] = Cuadro.ESPACIO3;
                    continue;
                case 0xff3c0505:
                    switch (p1) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO4;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO4;
                    }
                    continue;
                case 0xffeb0a6f:
                    switch (p2) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO5;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO5;
                    }
                    continue;
                case 0xffa80b51:
                    switch (p3) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO6;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO6;
                    }
                    continue;
                case 0xff6d0b37:
                    switch (p4) {
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO7;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO7;
                    }
                    continue;
                case 0xff420822:
                    switch (p5) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO8;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO8;
                    }
                    continue;
                case 0xfff011d8:
                    switch (p6) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO9;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO9;
                    }
                    continue;
                case 0xffaa109a:
                    switch (p7) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO10;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO10;
                    }
                    continue;
                case 0xff6b0c61:
                    switch (p8) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO11;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO11;
                    }
                    continue;
                case 0xff3a0534:
                    switch (p9) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO12;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO12;
                    }
                    continue;
                case 0xffbb18f7:
                    switch (p10) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO13;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO13;
                    }
                    continue;
                case 0xff8414ad:
                    switch (p11) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO14;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO15;
                    }
                    continue;
                case 0xff510b6b:
                    switch (p12) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO15;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO15;
                    }
                    continue;
                case 0xff290337:
                    switch (p13) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO16;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO16;
                    }
                    continue;
                case 0xff3618ea:
                    switch (p14) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO17;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO17;
                    }
                    continue;
                case 0xff220bb4:
                    switch (p15) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO18;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO18;
                    }
                    continue;
                case 0xff14085c:
                    switch (p16) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO19;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO19;
                    }
                    continue;
                case 0xff0f0643:
                    switch (p17) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO20;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO20;
                    }
                    continue;
                case 0xff2257ef:
                    switch (p18) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO21;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO21;
                    }
                    continue;
                case 0xff203e92:
                    switch (p19) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO22;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO22;
                    }
                    continue;
                case 0xff112766:
                    switch (p20) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO23;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO23;
                    }
                    continue;
                case 0xff18dcf3:
                    switch (p21) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO24;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO24;
                    }
                    continue;
                case 0xff0ea8ba:
                    switch (p22) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO25;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO25;
                    }
                    continue;
                case 0xff097b89:
                    switch (p23) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO26;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO1;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO26;
                    }
                    continue;
                case 0xff065c66:
                    switch (p24) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO27;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO27;
                    }
                    continue;
                case 0xff04393f:
                    switch (p25) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO28;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO28;
                    }
                    continue;
                case 0xff10e6c0:
                    switch (p26) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO29;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO29;
                    }
                    continue;
                case 0xff11b89b:
                    switch (p27) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO30;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO30;
                    }
                    continue;
                case 0xff0e846f:
                    switch (p28) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO31;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO31;
                    }
                    continue;
                case 0xff0b5145:
                    switch (p29) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO32;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO32;
                    }
                    continue;
                case 0xff08322b:
                    switch (p30) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO33;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO33;
                    }
                    continue;
                case 0xff11dd59:
                    switch (p31) {
                        case 0:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO34;
                            break;
                        case 1:
                            cuadrosCatalogo[i] = Cuadro.CARRO2;
                            break;
                        default:
                            cuadrosCatalogo[i] = Cuadro.ESPACIO34;
                    }
                    continue;
                default:
                    cuadrosCatalogo[i] = Cuadro.VACIO;
            }
        }
    }

}
