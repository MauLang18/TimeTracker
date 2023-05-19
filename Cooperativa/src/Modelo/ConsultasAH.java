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
public class ConsultasAH extends Conexion{
    public boolean ingresar(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarAH (?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, ah.getNumero());
            ps.setString(2, ah.getNombre());
            ps.setString(3, ah.getApellido1());
            ps.setString(4, ah.getApellido2());
            ps.setInt(5, ah.getCedula());
            ps.setInt(6, ah.getMonto());
            ps.setString(7, ah.getFecha());
            ps.setDouble(8, ah.getTotal());
            ps.setString(9, ah.getCorte());
            ps.setDouble(10, ah.getFinaly());
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
    
    public boolean modificar(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarAH (?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ah.getID());
            ps.setString(2, ah.getNumero());
            ps.setString(3, ah.getNombre());
            ps.setString(4, ah.getApellido1());
            ps.setString(5, ah.getApellido2());
            ps.setInt(6, ah.getCedula());
            ps.setInt(7, ah.getMonto());
            ps.setString(8, ah.getFecha());
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
    
    public boolean eliminar(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarAH (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ah.getID());
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
    
    public boolean limpiar(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarAH ()";
        
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
    
    public boolean logica(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL total(?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ah.getMonto());
            ps.setDouble(2, ah.getInteres());
            ps.setInt(3, ah.getID());
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
    
    public boolean retiro(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql=("CALL retiro(?,?)");
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ah.getCedula());
            ps.setInt(2, ah.getMonto());
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
    
    public boolean finaly(ahorro ah){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql=("CALL totalfinal(?,?)");
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, ah.getCedula());
            ps.setDouble(2, ah.getTotal());
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
