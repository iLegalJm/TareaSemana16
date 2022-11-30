/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import Entidad.Autor;
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
public class AutorDAO implements CrudSimple<Autor>{

    private final Conexion cx;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public AutorDAO() {
        cx = Conexion.getInstancia();
    }
        
    @Override
    public List<Autor> listar(String texto) {
        List<Autor> registros=new ArrayList();
        
        try {
            ps = cx.conectar().prepareStatement("Select a.id, a.nombres, a.apellidos, a.pais from autor a where a.nombres like ?");
            ps.setString(1, "%" + texto +"%");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                registros.add(new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
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
    
    public List<Autor> seleccionar() {
        List<Autor> registros = new ArrayList();
        try {
            ps = cx.conectar().prepareStatement("select id, nombres from autor order by nombres asc");
            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Autor(rs.getInt(1), rs.getString(2)));
            }
            
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            cx.desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Autor obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Autor obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
