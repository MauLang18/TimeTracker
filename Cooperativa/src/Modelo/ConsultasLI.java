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
public class ConsultasLI extends Conexion{
    public boolean ingresar(libros li){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarLI (?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, li.getLibro());
            ps.setString(2,li.getGrado());
            ps.setInt(3, li.getPrecio());
            ps.setInt(4, li.getExistencias());
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
    
    public boolean modificar(libros li){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarLI (?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, li.getCodigo());
            ps.setString(2, li.getLibro());
            ps.setString(3, li.getGrado());
            ps.setInt(4, li.getPrecio());
            ps.setInt(5, li.getExistencias());
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
    
    public boolean eliminar(libros li){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarLI (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, li.getCodigo());
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
    
    public boolean limpiar(libros li){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarLI ()";
        
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
