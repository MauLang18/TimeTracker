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
public class ConsultasRE2 extends Conexion{
    public boolean ingresar(reservar pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO tb_reserva (cedul,espacio) VALUES (?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pe.getCedula());
            ps.setInt(2, pe.getEspacio());
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
    
    public boolean modificar(reservar pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_reserva SET espacio=? WHERE cedul=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pe.getEspacio());
            ps.setInt(5, pe.getCedula());
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
    
    public boolean eliminar(reservar pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM tb_reserva WHERE cedul=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pe.getCedula());
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
