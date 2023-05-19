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
 * @author maula
 */
public class ConsultasAP extends Conexion{
    public boolean ingresar(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarAP (?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, ap.getNumero());
            ps.setString(2, ap.getNombre());
            ps.setString(3, ap.getApellido1());
            ps.setString(4, ap.getApellido2());
            ps.setInt(5, ap.getAcumulacion());
            ps.setString(6, ap.getMes());
            ps.setString(7, ap.getRecibo());
            ps.setString(8, ap.getFecha());
            ps.setString(9, ap.getCertificados());
            ps.setInt(10, ap.getTotal());
            ps.setString(11, ap.getYear()); 
            ps.setInt(12, ap.getMonto());
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
    
    public boolean modificar(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarAP (?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ap.getID());
            ps.setString(2, ap.getNumero());
            ps.setString(3, ap.getNombre());
            ps.setString(4, ap.getApellido1());
            ps.setString(5, ap.getApellido2());
            ps.setInt(6, ap.getAcumulacion());
            ps.setString(7, ap.getMes());
            ps.setString(8, ap.getRecibo());
            ps.setString(9, ap.getFecha());
            ps.setString(10, ap.getCertificados());
            ps.setString(11, ap.getYear());
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
    
    public boolean eliminar(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarAP (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ap.getID());
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
    
    public boolean limpiar(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarAP ()";
        
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
    
    public boolean resta(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL resta(?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ap.getMonto());
            ps.setInt(2, ap.getID());
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
    
    public boolean suma(aportacion ap){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL suma (?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ap.getMonto());
            ps.setInt(2, ap.getID());
            ps.setInt(3, ap.getAcumulacion());
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