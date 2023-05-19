
package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maula
 */
public class ConsultasAF extends Conexion {
    public boolean ingresar(afiliacion af){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL ingresarAF (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, af.getCedula());
            ps.setString(2, af.getNombre());
            ps.setString(3, af.getApellido1());
            ps.setString(4, af.getApellido2());
            ps.setString(5, af.getCorreo());
            ps.setString(6, af.getNacimiento());
            ps.setInt(7, af.getTelefono());
            ps.setString(8, af.getDireccion());
            ps.setString(9, af.getSeccion());
            ps.setString(10, af.getEspecialidad());
            ps.setString(11, af.getEnfermedad());
            ps.setString(12, af.getBeneficiario());
            ps.setString(13, af.getApellidoB1());
            ps.setString(14, af.getApellidoB2());
            ps.setInt(15, af.getCedulaB());
            ps.setString(16, af.getFuncionario());
            ps.setString(17, af.getCargo());
            ps.setString(18, af.getFechaIn());
            ps.setString(19, af.getNacionalidad());
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
    
    public boolean modificar(afiliacion af){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL modificarAF (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, af.getCedula());
            ps.setString(2, af.getNombre());
            ps.setString(3, af.getApellido1());
            ps.setString(4, af.getApellido2());
            ps.setString(5, af.getCorreo());
            ps.setString(6, af.getNacimiento());
            ps.setInt(7, af.getTelefono());
            ps.setString(8, af.getDireccion());
            ps.setString(9, af.getSeccion());
            ps.setString(10, af.getEspecialidad());
            ps.setString(11, af.getEnfermedad());
            ps.setString(12, af.getBeneficiario());
            ps.setString(13, af.getApellidoB1());
            ps.setString(14, af.getApellidoB2());
            ps.setInt(15, af.getCedulaB());
            ps.setString(16, af.getFuncionario());
            ps.setString(17, af.getCargo());
            ps.setString(18, af.getNacionalidad());
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
    
    public boolean eliminar(afiliacion af){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL eliminarAF (?)";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, af.getCedula());
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
    
    public boolean limpiar(afiliacion af){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="CALL limpiarAF ()";
        
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
