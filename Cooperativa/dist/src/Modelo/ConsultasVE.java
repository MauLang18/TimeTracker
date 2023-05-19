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
public class ConsultasVE extends Conexion{
    public boolean modificarLI(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarLIVE (?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID());
            ps.setString(2, ve.getProducto());
            ps.setString(3, ve.getGrado());
            ps.setInt(4, ve.getPrecio());
            ps.setInt(5, ve.getCantidad());
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
    
    public boolean modificarBA(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarBAVE (?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID());
            ps.setString(2, ve.getProducto());
            ps.setInt(3, ve.getPrecio());
            ps.setInt(4, ve.getCantidad());
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
    
    public boolean eliminar(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarVE (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID());
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
    
    public boolean limpiar(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarVE ()";
        
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
    
    public boolean bazar(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL exis(?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID());
            ps.setInt(2, ve.getCantidad());
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
    
    public boolean libros(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL exis1(?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID());
            ps.setInt(2, ve.getCantidad());
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
    
    public boolean bazar2(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL exis(?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID_BA());
            ps.setInt(2, ve.getCantidad());
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
    
    public boolean libros2(ventas ve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL exis1(?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ve.getID_LI());
            ps.setInt(2, ve.getCantidad());
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
