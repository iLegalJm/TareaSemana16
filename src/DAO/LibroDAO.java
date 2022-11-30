/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidad.Libro;
import Interface.CrudSimple;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author CHATARA_II
 */
public class LibroDAO implements CrudSimple<Libro>{

    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public LibroDAO() {
        cx = Conexion.getInstancia();
    }
        
    @Override
    public List<Libro> listar(String texto) {
        List<Libro> registros=new ArrayList();
        
        try {
            ps = cx.conectar().prepareStatement("Select l.id, l.id_autor, a.nombres, l.titulo, l.paginas, l.editorial from libro l inner join autor a on a.id = l.id_autor where l.titulo like ?");
            ps.setString(1, "%" + texto +"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                registros.add(new Libro(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps = null;
            rs = null;
            cx.desconectar();
        }
        
        return registros;
    }

    @Override
    public boolean insertar(Libro obj) {       
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("insert into libro (id_autor, titulo, paginas, editorial) values (?, ?, ?, ?)");
            ps.setInt(1, obj.getId_autor());
            ps.setString(2, obj.getTitulo());
            ps.setInt(3, obj.getPaginas());
            ps.setString(4, obj.getEditorial());
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
            ps.close();           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps = null;          
            cx.desconectar();
        }        
        return resp;
    }

    @Override
    public boolean eliminar(Libro obj) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("delete from libro where id=?");
            ps.setInt(1, obj.getId());
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
            ps.close();           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps = null;          
            cx.desconectar();
        }        
        return resp;
    }

    @Override
    public boolean actualizar(Libro obj) {
        resp = false;
        try {
            ps = cx.conectar().prepareStatement("update libro set id_autor=?,titulo=?, paginas=?, editorial=? where id=?");
            ps.setInt(1, obj.getId_autor());
            ps.setString(2, obj.getTitulo());
            ps.setInt(3, obj.getPaginas());
            ps.setString(4, obj.getEditorial());     
            ps.setInt(5, obj.getId());
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
            ps.close();           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally{
            ps = null;          
            cx.desconectar();
        }        
        return resp;
    }
    
}
