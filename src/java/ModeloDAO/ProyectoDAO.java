
package ModeloDAO;

import config.Conexion;
import Interface.CRUDproyecto;
import Modelo.Persona;
import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements CRUDproyecto{
    
   Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Proyecto p=new Proyecto(); 
    Persona per=new Persona();

    @Override
    public List listar() {
       ArrayList<Proyecto>list=new ArrayList<>();
        String sql="select * from proyecto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Proyecto pro=new Proyecto();
                pro.setIdpro(rs.getInt("idproyecto"));
                pro.setDesc(rs.getString("descproyecto"));
                pro.setId(rs.getInt("id"));
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list; 
    }

    @Override
    public Proyecto list(int id) {
       String sql="select * from proyecto where idproyecto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setIdpro(rs.getInt("idproyecto"));
                p.setDesc(rs.getString("descproyecto"));
                p.setId(rs.getInt("id"));
                
            }
        } catch (Exception e) {
        }
        return p;
    }
    @Override
    public Proyecto buscarpersona(int id) {
       String sql="select * from persona where id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
                      
                per.setNom(rs.getString("nom"));
                
                
            
        } catch (Exception e) {
        }
        return p;
    }
    
    @Override
    public boolean add(Proyecto pro) {
       String sql="insert into proyecto(descproyecto, id)values('"+pro.getDesc()+"','"+pro.getId()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false; 
    }

    @Override
    public boolean edit(Proyecto pro) {
        String sql="update proyecto set descproyecto='"+pro.getDesc()+"',id='"+pro.getId()+"' where idproyecto='"+pro.getIdpro()+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from proyecto where idproyecto="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
