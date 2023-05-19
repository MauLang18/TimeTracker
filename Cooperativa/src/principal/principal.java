/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Controlador.*;
import Modelo.*;
import Vista.*;

/**
 *
 * @author maula
 */
public class principal {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        afiliacion mod = new afiliacion();
        ConsultasAF modC = new ConsultasAF();
        admision ad = new admision();
        ConsultasAD adC = new ConsultasAD();
        aportacion ap = new aportacion();
        ConsultasAP apC = new ConsultasAP();
        ahorro ah= new ahorro();
        ConsultasAH ahC = new ConsultasAH();
        bazar ba = new bazar();
        ConsultasBA baC = new ConsultasBA();
        libros li = new libros();
        ConsultasLI liC = new ConsultasLI();
        ocacional oc = new ocacional();
        ConsultasOC ocC = new ConsultasOC();
        ventas ve = new ventas();
        ConsultasVE veC = new ConsultasVE();
        fmHome2 frm = new fmHome2();
        fmAfiliacion fmAF = new fmAfiliacion();
        fmAdmision fmAD = new fmAdmision();
        fmAportacion fmAP = new fmAportacion();
        fmAhorro fmAH = new fmAhorro();
        fmBazar fmBA = new fmBazar();
        fmLibros fmLI = new fmLibros();
        fm fmLo = new fm();
        
        Ctrl ctr = new Ctrl(mod,ad,modC,adC,ap,apC,ah,ahC,ba,baC,li,liC,oc,ocC,ve,veC,frm,fmAF,fmAD,fmAP,fmAH,fmBA,fmLI,fmLo);
        ctr.iniciar();
        fmLo.setVisible(true);
    }
    
}
