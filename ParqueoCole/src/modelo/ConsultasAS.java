/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author maula
 */
public class ConsultasAS extends Conexion{
    public boolean insetar(asignar as){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_asignar SET cedula=?, horaEntrada=?, estado=?, estado1=? WHERE espacio=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, as.getCedula());
            ps.setString(2, as.getHoraE());
            ps.setString(3, as.getEstado());
            ps.setInt(4, 1);
            ps.setInt(5, as.getEspacio());
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
    
    public boolean salir(asignar as){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_asignar SET cedula=?, horaSalida=?, estado=? WHERE espacio=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, as.getCedula());
            ps.setString(2, as.getHoraS());
            ps.setString(3, as.getEstado());
            ps.setInt(4, as.getEspacio());
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
    
    public boolean modificar(asignar as){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_asignar SET cedula=?, horaSalida=?, estado=?, horaEntrada=? WHERE espacio=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, as.getCedula());
            ps.setString(2, as.getHoraS());
            ps.setString(3, as.getEstado());
            ps.setString(4, as.getHoraE());
            ps.setInt(5, as.getEspacio());
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
    
    public boolean eliminar(asignar as){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM tb_asignar WHERE espacio=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, as.getEspacio());
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
