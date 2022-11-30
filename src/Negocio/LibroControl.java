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
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHATARA_II
 */
public class LibroControl {

    private final LibroDAO DATOS;
    private final AutorDAO DATOSAUTOR;
    private Libro objLibro;
    private DefaultTableModel modeloTabla;
    
    public LibroControl() {
        this.DATOS = new LibroDAO();
        this.objLibro = new Libro();
        this.DATOSAUTOR= new AutorDAO();
    }
    
    public DefaultTableModel listar(String texto){
        List<Libro> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        String[] titulos = {"ID", "ID AUTOR", "AUTOR", "TITULO", "PAGINAS", "EDITORIAL"}; 
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro= new String[6];
        
        for (Libro item: lista) {
            
            registro[0]=Integer.toString(item.getId());
            registro[1]=Integer.toString(item.getId_autor());
            registro[2]=item.getAutorNombre();
            registro[3]=item.getTitulo();
            registro[4]=Integer.toString(item.getPaginas());
            registro[5]=item.getEditorial();
            
            this.modeloTabla.addRow(registro);
        }
        
        return this.modeloTabla;
    }
    
    public String insertar(int id_autor, String titulo, int numPaginas, String editorial){
        
        objLibro.setId_autor(id_autor);
        objLibro.setTitulo(titulo);
        objLibro.setPaginas(numPaginas);
        objLibro.setEditorial(editorial);
        
        if (DATOS.insertar(objLibro)) {
            return "OK";
        } else {
            return "Error al insertar registro";            
        }
    }
    
    public DefaultComboBoxModel seleccionar(){
        DefaultComboBoxModel items=new DefaultComboBoxModel();
        List<Autor> lista=new ArrayList();
        lista=DATOSAUTOR.seleccionar();
        for (Autor item: lista) {
            items.addElement(new Autor(item.getId(), item.getNombres()));
        }
        return items;
    }
    
    public String actualizar(String titulo, int numPaginas, String editorial){
              
        objLibro.setTitulo(titulo);
        objLibro.setPaginas(numPaginas);
        objLibro.setEditorial(editorial);
        
        if (DATOS.actualizar(objLibro)) {
            return "OK";
        } else {
            return "Error al actualizar registro";            
        }
    }
}
