package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maula
 */
public class SqlUsuarios extends Conexion{
    public boolean login(usuarios usr){
        PreparedStatement ps=null;
        ResultSet rs= null;
        Connection con = getConexion();
        
        String sql = "SELECT u.ide, u.usuario, u.pass, u.afiliacion, u.admision, u.aportacion, u.ahorro, u.bazar, u.libros, u.ocasional, u.ventas, u.registro, u.id_tipo, t.tipo FROM tb_usuario AS u INNER JOIN tb_tipo AS t ON u.id_tipo=t.id WHERE usuario=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                if(usr.getPassword().equals(rs.getString(3))){
                    usr.setIde(rs.getInt(1));
                    usr.setAf(rs.getInt(4));
                    usr.setAd(rs.getInt(5));
                    usr.setAp(rs.getInt(6));
                    usr.setAh(rs.getInt(7));
                    usr.setBa(rs.getInt(8));
                    usr.setLi(rs.getInt(9));
                    usr.setOc(rs.getInt(10));
                    usr.setVe(rs.getInt(11));
                    usr.setRe(rs.getInt(12));
                    usr.setId_tipo(rs.getInt(13));
                    usr.setTipo(rs.getString(14));
                    
                    return true;
                }
                else{
                    return false;
                }
            }
            
            return false;
        }catch(SQLException ex){
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
    }
    
    public boolean afi(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET afiliacion=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getAf());
            ps.setInt(2, usr.getIde());
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
    
    public boolean adm(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET admision=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getAd());
            ps.setInt(2, usr.getIde());
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
    
    public boolean aho(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET ahorro=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getAh());
            ps.setInt(2, usr.getIde());
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
    
    public boolean apo(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET aportacion=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getAp());
            ps.setInt(2, usr.getIde());
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
    
    public boolean baz(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET bazar=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getBa());
            ps.setInt(2, usr.getIde());
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
    
    public boolean lib(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET libros=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getLi());
            ps.setInt(2, usr.getIde());
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
    
    public boolean oca(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET ocasional=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getOc());
            ps.setInt(2, usr.getIde());
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
    
    public boolean ven(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET ventas=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getVe());
            ps.setInt(2, usr.getIde());
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
    
    public boolean reg(usuarios usr){
        PreparedStatement ps=null;
        Connection con = getConexion();
        
        String sql="UPDATE tb_usuario SET registro=? WHERE ide=?";
        
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, usr.getRe());
            ps.setInt(2, usr.getIde());
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
