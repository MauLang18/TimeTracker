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
public class ConsultasCO extends Conexion{
    public boolean ingresar(cone re){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO tb_conexion (ce,espacio,fecha,horaEntrada,horaSalida) VALUES (?,?,?,?,?)";
        
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
}
