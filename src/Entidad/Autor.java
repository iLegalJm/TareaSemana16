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
public class Autor {
    private int id;
    private String nombres;
    private String apellidos;
    private String pais;

    public Autor(int id, String nombres) {
        this.id = id;
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return nombres;
    }
    
    
}
