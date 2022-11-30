/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DAO.AutorDAO;
import DAO.LibroDAO;
import Entidad.Autor;
import Entidad.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHATARA_II
 */
public class AutorControl {

    private final AutorDAO DATOS;
    private Autor objAutor;
    private DefaultTableModel modeloTabla;
    
    public AutorControl() {
        this.DATOS = new AutorDAO();
        this.objAutor = new Autor();
    }
    
    public DefaultTableModel listar(String texto){
        List<Autor> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "NOMBRES", "APELLIDOS", "PAIS"}; 
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro= new String[4];
        
        for (Autor item: lista) {
            
            registro[0]=Integer.toString(item.getId());   
            registro[1]=item.getNombres();
            registro[2]=item.getApellidos();
            registro[3]=item.getPais();
            
            this.modeloTabla.addRow(registro);
        }
        
        return this.modeloTabla;
    }
    
    
}
