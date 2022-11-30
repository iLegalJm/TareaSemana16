/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CHATARA_II
 */

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Libro {
    private int id;
    private int id_autor;
    private String autorNombre;
    private String titulo;
    private int paginas;
    private String editorial;     
}
