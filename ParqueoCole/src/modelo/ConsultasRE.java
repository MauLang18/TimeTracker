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
public class ConsultasRE extends Conexion{
    
    public boolean ingresar(registro re){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO tb_registro (cedu,espacio,fecha,horaEntrada,horaSalida) VALUES (?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, re.getCedula());
            ps.setInt(2, re.getEspacio());
            ps.setString(3, re.getFecha());
            ps.setString(4, re.getHoraE());
            ps.setString(5, re.getHoraS());
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
    
    public boolean modificar(registro re){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_registro SET cedu=?, espacio=?, fecha=?, horaEntrada=?, horaSalida=? WHERE id=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, re.getCedula());
            ps.setInt(2, re.getEspacio());
            ps.setString(3, re.getFecha());
            ps.setString(4, re.getHoraE());
            ps.setString(5, re.getHoraS());
            ps.setInt(6, re.getId());
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
    
    public boolean eliminar(registro re){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM tb_registro WHERE id=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, re.getId());
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
