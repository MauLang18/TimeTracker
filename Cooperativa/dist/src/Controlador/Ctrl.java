/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author maula
 */
public class Ctrl implements ActionListener{
    private afiliacion mod;
    private ConsultasAF modC;
    private admision ad;
    private ConsultasAD adC;
    private aportacion ap;
    private ConsultasAP apC;
    private ahorro ah;
    private ConsultasAH ahC;
    private bazar ba;
    private ConsultasBA baC;
    private libros li;
    private ConsultasLI liC;
    private ocacional oc;
    private ConsultasOC ocC;
    private ventas ve;
    private ConsultasVE veC;
    private fmHome2 frm;
    private fmAfiliacion fmAF;
    private fmAdmision fmAD;
    private fmAportacion fmAP;
    private fmAhorro fmAH;
    private fmBazar fmBA;
    private fmLibros fmLI;
    private fm fmLo;
    
    public Ctrl(afiliacion mod, admision ad, ConsultasAF modC, ConsultasAD adC, aportacion ap, ConsultasAP apC, ahorro ah, ConsultasAH ahC, bazar ba, ConsultasBA baC, libros li, ConsultasLI liC, ocacional oc, ConsultasOC ocC, ventas ve, ConsultasVE veC, fmHome2 frm, fmAfiliacion fmAF, fmAdmision fmAD, fmAportacion fmAP, fmAhorro fmAH, fmBazar fmBA, fmLibros fmLI, fm fmLo){
        this.mod=mod;
        this.modC=modC;
        this.ad=ad;
        this.adC=adC;
        this.frm=frm;
        this.ap=ap;
        this.apC=apC;
        this.ah=ah;
        this.ahC=ahC;
        this.ba=ba;
        this.baC=baC;
        this.li=li;
        this.liC=liC;
        this.oc=oc;
        this.ocC=ocC;
        this.ve=ve;
        this.veC=veC;
        this.fmAF=fmAF;
        this.fmAD=fmAD;
        this.fmAP=fmAP;
        this.fmAH=fmAH;
        this.fmBA=fmBA;
        this.fmLI=fmLI;
        this.fmLo=fmLo;
    }
    
    
    public void iniciar(){
        fmLo.setTitle("Cooperativa");
        fmLo.setLocationRelativeTo(null);
    }
    
    public void iniciar2(){
        frm.setTitle("Cooperativa");
        frm.setLocationRelativeTo(null);
    }
 
    @Override
    public void actionPerformed(ActionEvent e){
        
        /*if(e.getSource()==frm.btnModificar8){
            ve.setId(Integer.parseInt(frm.txtID8.getText()));
            ve.setProducto(frm.txtProducto.getText());
            ve.setGrado(frm.txtGrado8.getSelectedItem().toString());
            ve.setPrecio(Integer.parseInt(frm.txtPrecio8.getText()));
            ve.setCantidad(Integer.parseInt(frm.txtCantidad8.getText()));
            
            if(veC.modificar(ve)){
                JOptionPane.showMessageDialog(null,"Modificado con exito");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnEliminar8){
            ve.setId(Integer.parseInt(frm.txtID8.getText()));
            
            if(veC.eliminar(ve)){
                JOptionPane.showMessageDialog(null,"Eliminado con exito");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al eliminar");
                limpiar();
            }
        }
        
        if(e.getSource()==frm.btnLimpiar8){
            
            if(veC.limpiar(ve)){
                JOptionPane.showMessageDialog(null,"Limpiado con exito");
                limpiar();
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al limpiar");
                limpiar();
            }
        }*/
    }
    
    public static String fecha(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }
    
    public void limpiar(){
        /*frm.txtProducto.setText(null);
        frm.txtPrecio8.setText(null);
        frm.txtCantidad8.setText(null);
        frm.txtID8.setText(null);*/
    }
}
