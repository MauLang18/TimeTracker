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
public class ConsultasPE extends Conexion{
    public boolean ingresar(personal pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO tb_personal (cedula,nombre,apellido1,apellido2,placa) VALUES (?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, pe.getCedula());
            ps.setString(2, pe.getNombre());
            ps.setString(3, pe.getApellido1());
            ps.setString(4, pe.getApellido2());
            ps.setString(5, pe.getPlaca());
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
    
    public boolean modificar(personal pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_personal SET nombre=?, apellido1=?, apellido2=?, placa=? WHERE cedula=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, pe.getNombre());
            ps.setString(2, pe.getApellido1());
            ps.setString(3, pe.getApellido2());
            ps.setString(4, pe.getPlaca());
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
    
    public boolean eliminar(personal pe){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM tb_personal WHERE cedula=?";
        
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
