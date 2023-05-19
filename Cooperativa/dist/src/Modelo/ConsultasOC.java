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
public class ConsultasOC extends Conexion{
    public boolean ingresar(ocacional oc){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarOC (?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, oc.getActividad());
            ps.setString(2,oc.getDia());
            ps.setInt(3, oc.getRecaudacion());
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
    
    public boolean modificar(ocacional oc){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarOC (?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, oc.getCodigo());
            ps.setString(2, oc.getActividad());
            ps.setString(3, oc.getDia());
            ps.setInt(4, oc.getRecaudacion());
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
    
    public boolean eliminar(ocacional oc){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarOC (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, oc.getCodigo());
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
    
    public boolean limpiar(ocacional oc){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarOC ()";
        
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
