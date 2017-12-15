/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.chocolateria.modelo;

import java.util.ArrayList;

/**
 *
 * @author LEARNING CENTER
 */
public class Marca {
    private Integer codigoMarca;
    private String nombre;
    private ArrayList<Chocolate> chocos;

    public Marca() {
    }

    public Marca(Integer codigoMarca, String nombre, ArrayList<Chocolate> chocos) {
        this.codigoMarca = codigoMarca;
        this.nombre = nombre;
        this.chocos = chocos;
    }

    public Marca(Integer codigoMarca, String nombre) {
        this.codigoMarca = codigoMarca;
        this.nombre = nombre;
    }
    
    

    public void setCodigoMarca(Integer codigoMarca) {
        this.codigoMarca = codigoMarca;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setChocos(ArrayList<Chocolate> chocos) {
        this.chocos = chocos;
    }

    
    public Integer getCodigoMarca() {
        return codigoMarca;
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Chocolate> getChocos() {
        return chocos;
    }

    @Override
    public String toString() {
        return "Marca{" + "codigoMarca=" + codigoMarca + ", nombre=" + nombre + '}';
    }
    
    
    
    
    
}
