/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Administrador
 */
public class ConsultasAD extends Conexion{
    public boolean ingresar(admision ad){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarAD (?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, ad.getNumero());
            ps.setString(2, ad.getNombre());
            ps.setString(3, ad.getApellido1());
            ps.setString(4, ad.getApellido2());
            ps.setInt(5, ad.getCedula());
            ps.setString(6, ad.getFecha());
            ps.setString(7, ad.getCalidad());
            ps.setString(8, ad.getNivel());
            ps.setInt(9, ad.getCuota());
            ps.setString(10, ad.getEstado());
            ps.setString(11, ad.getRetiro());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean modificar(admision ad){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarAD (?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, ad.getNumero());
            ps.setString(2, ad.getNombre());
            ps.setString(3, ad.getApellido1());
            ps.setString(4, ad.getApellido2());
            ps.setInt(5, ad.getCedula());
            ps.setString(6, ad.getFecha());
            ps.setString(7, ad.getCalidad());
            ps.setString(8, ad.getNivel());
            ps.setInt(9, ad.getCuota());
            ps.setString(10, ad.getEstado());
            ps.setString(11, ad.getRetiro());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminar(admision ad){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarAD (?)";
        
        try{
            ps=con.prepareStatement(sql); 
            ps.setString(1, ad.getNumero());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    public boolean limpiar(admision ad){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarAD ()";
        
        try{
            ps=con.prepareStatement(sql); 
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
}
