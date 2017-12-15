/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.chocolateria.modelo;


import cl.duoc.chocolateria.controlador.Controlador;
import cl.duoc.chocolateria.datos.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Estudio
 */
public class MetodosCRUD {
    
    private static MetodosCRUD aux;
    
    private MetodosCRUD(){};
    
    public static MetodosCRUD metodo(){
        if(aux == null){
            aux = new MetodosCRUD();
        }
        return aux;
    }
    
    public void agregarMarca(Marca lib){
        
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            
            String sentencia = "INSERT INTO TBl_Marca (codigomarca,marca)"
            + "VALUES("+lib.getCodigoMarca()+",'"+lib.getNombre()+"')";
            
            s.execute(sentencia);
            
            System.out.println("Insertado con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar Marca");
        }
    }
    
    public void agregarChocolate(Chocolate rev){
        
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            
            String sentencia = "INSERT INTO TBl_chocolate (codigo,nombre,descripcion,precio,"
                    + "cantidad,tipochocolate,tiposabor,codigomarca,azucar)"
            + "VALUES("+rev.getCodigoChoc()+",'"+rev.getNombre()+"','"+rev.getDescripcion()+"',"+rev.getPrecio()+","
                    +rev.getCantidad()+",'"+rev.getTipoChoc()+"','"+rev.getTipoSabor()+"',"+rev.getCodigomarca()+",'"
                    +rev.getAzucar()+"')";            
            s.execute(sentencia);

            System.out.println("Insertado con exito");
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar chocolate");
        }
    }
    
    public void cargarChocolateria(){
        String sentencia = "SELECT codigo,nombre,descripcion,precio,cantidad,tipochocolate,tiposabor,codigomarca,azucar  FROM TBl_chocolate ORDER BY CODIGO ASC";

        Statement s;
        try {
            s = Conexion.obtenerInstancia().createStatement();
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia);
            
            
            
            while (resultado.next()){
                Integer codigoChoc = resultado.getInt("codigo");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                Integer precio = resultado.getInt("precio");
                Integer cantidad = resultado.getInt("cantidad");
                String tipoChocolate = resultado.getString("tipochocolate");
                String tipoSabor = resultado.getString("tiposabor");
                Integer codigomarca = resultado.getInt("codigomarca");
                String azucar = resultado.getString("azucar");
                String marca = Controlador.generar1().getMarca(codigomarca).getNombre();
                
            
                Chocolate lib = new Chocolate( codigoChoc,  nombre,  descripcion,
                     precio,cantidad,tipoChocolate,tipoSabor,marca, azucar,codigomarca);
                    Controlador.generar1().agregarChocolate(lib);
                
            }
        } catch (SQLException ex) {
            System.out.println("Error en la carga de datos");
        }    
    }
    
    public void cargarMarcas(){
        String sentencia2 = "SELECT codigomarca,marca FROM tbl_marca ORDER BY codigomarca ASC";
        Statement s;
        try {
            s = Conexion.obtenerInstancia().createStatement();
            System.out.println(" Cargando datos...");
            ResultSet resultado=s.executeQuery(sentencia2);
            Controlador.generar1().vaciar();
           
            while (resultado.next()){
                Integer codigoMarca = resultado.getInt("codigomarca");
                String nombre = resultado.getString("marca");
                
           
                Marca rev = new Marca(codigoMarca,  nombre);
                Controlador.generar1().agregarMarca(rev);
                
            }
        } catch (SQLException exo) {
            System.out.println("Error en la carga de datos 2");
        }
    }
    
    public void borrarChocolate(Integer codigo){
        
        String sentencia="DELETE FROM tbl_chocolate WHERE CODIGO='"+codigo+"'";
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            s.executeUpdate(sentencia);
            System.out.println(" registro borrado...");
        } catch (SQLException ex) {
            System.out.println("Error al borrar");
        }
    }
    
        public void modificarChocolate(Chocolate a){
        
        String sentencia="UPDATE FROM tbl_chocolate set nombre="+a.getNombre()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia1="UPDATE FROM tbl_chocolate set descripcion="+a.getDescripcion()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia2="UPDATE FROM tbl_chocolate set precio="+a.getPrecio()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia3="UPDATE FROM tbl_chocolate set cantidad="+a.getCantidad()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia4="UPDATE FROM tbl_chocolate set tipochocolate="+a.getTipoChoc()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia5="UPDATE FROM tbl_chocolate set tiposabor="+a.getTipoSabor()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia6="UPDATE FROM tbl_chocolate set marca="+a.getMarca()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        String sentencia7="UPDATE FROM tbl_chocolate set azucar="+a.getAzucar()+ "WHERE CODIGO='"+a.getCodigoChoc()+"'";
        try {
            Statement s = Conexion.obtenerInstancia().createStatement();
            s.executeUpdate(sentencia);
            s.executeUpdate(sentencia1);
            s.executeUpdate(sentencia2);
            s.executeUpdate(sentencia3);
            s.executeUpdate(sentencia4);
            s.executeUpdate(sentencia5);
            s.executeUpdate(sentencia6);
            s.executeUpdate(sentencia7);
            System.out.println(" registro modificado...");
        } catch (SQLException ex) {
            System.out.println("Error al modificar");
        }
        
        
        
    }
}
