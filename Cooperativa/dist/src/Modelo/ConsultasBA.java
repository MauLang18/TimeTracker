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
public class ConsultasBA extends Conexion{
    public boolean ingresar(bazar ba){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarBA (?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, ba.getArticulo());
            ps.setString(2, ba.getModelo());
            ps.setInt(3, ba.getPrecio());
            ps.setInt(4, ba.getExistencias());
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
    
    public boolean modificar(bazar ba){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarBA (?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ba.getCodigo());
            ps.setString(2, ba.getArticulo());
            ps.setString(3, ba.getModelo());
            ps.setInt(4, ba.getPrecio());
            ps.setInt(5, ba.getExistencias());
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
    
    public boolean eliminar(bazar ba){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarBA (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ba.getCodigo());
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
    
    public boolean limpiar(bazar ba){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarBA ()";
        
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
