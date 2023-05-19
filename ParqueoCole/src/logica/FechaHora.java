/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author maula
 */
public class FechaHora {
    public static String fecha(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }
    
    public static String hora(){
        Date hora=new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("HH:mm:ss");
        return formatoFecha.format(hora);
    }
}
