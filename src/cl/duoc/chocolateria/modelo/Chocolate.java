/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.chocolateria.modelo;

/**
 *
 * @author LEARNING CENTER
 */
public class Chocolate {
    private Integer codigoChoc;
    private String nombre, descripcion;
    private Integer precio, cantidad;
    private String tipoChoc,tipoSabor, marca;
    private String azucar;
    private Integer codigomarca;

    public Chocolate() {
    }

    public Chocolate(Integer codigoChoc, String nombre, String descripcion, 
                    Integer precio, Integer cantidad, String tipoChoc, String tipoSabor, 
                    String marca, String azucar, Integer codigomarca ) {
        this.codigoChoc = codigoChoc;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.tipoChoc = tipoChoc;
        this.tipoSabor = tipoSabor;
        this.marca = marca;
        this.azucar = azucar;
        this.codigomarca =codigomarca;
    }

    public Chocolate(Integer codigoChoc, String nombre, String descripcion,
                    Integer precio, String azucar) {
        this.codigoChoc = codigoChoc;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.azucar = azucar;
    }

    public void setCodigoChoc(Integer codigoChoc) {
        this.codigoChoc = codigoChoc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public void setTipoChoc(String tipoChoc) {
        this.tipoChoc = tipoChoc;
    }
    public void setTipoSabor(String tipoSabor) {
        this.tipoSabor = tipoSabor;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setAzucar(String azucar) {
        this.azucar = azucar;
    }

    public void setCodigomarca(Integer codigomarca) {
        this.codigomarca = codigomarca;
    }

    
    
    public Integer getCodigoChoc() {
        return codigoChoc;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Integer getPrecio() {
        return precio;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public String getTipoChoc() {
        return tipoChoc;
    }
    public String getTipoSabor() {
        return tipoSabor;
    }
    public String getMarca() {
        return marca;
    }
    public String getAzucar() {
        return azucar;
    }

    public Integer getCodigomarca() {
        return codigomarca;
    }

    
    @Override
    public String toString() {
        return "Chocolate{" + "codigoChoc=" + codigoChoc + ", nombre=" + nombre 
                + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" 
                + cantidad + ", tipoChoc=" + tipoChoc + ", tipoSabor=" + tipoSabor 
                + ", marca=" + marca + ", azucar=" + azucar + '}';
    }
    
    
    
    
    
}
