
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author maula
 */
public class Consultas extends Conexion{
    
    public boolean ingresar(inventario inve){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="INSERT INTO inventario (codigo,descripcion,marca,modelo,serie,ubicacion,observacion,revision,estado) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, inve.getCodigo());
            ps.setString(2, inve.getDescripcion());
            ps.setString(3, inve.getMarca());
            ps.setString(4, inve.getModelo());
            ps.setString(5, inve.getSerie());
            ps.setString(6, inve.getUbicacion());
            ps.setString(7, inve.getObservacion());
            ps.setInt(8, inve.getRevision());
            ps.setString(9, inve.getEstado());
            
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
    
    public boolean modificar (inventario inve) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE inventario SET descripcion=?,marca=?,modelo=?,serie=?,ubicacion=?,observacion=?,revision=?,estado=? WHERE codigo=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, inve.getDescripcion());
            ps.setString(2, inve.getMarca());
            ps.setString(3, inve.getModelo());
            ps.setString(4, inve.getSerie());
            ps.setString(5, inve.getUbicacion());
            ps.setString(6, inve.getObservacion());
            ps.setInt(7, inve.getRevision());
            ps.setString(8, inve.getEstado());
            ps.setString(9, inve.getCodigo());
            
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
    
    public boolean eliminar (inventario inve) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM inventario WHERE codigo=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, inve.getCodigo());
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
    
    public boolean limpiar (inventario inve) {
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="DELETE FROM inventario";
        
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
