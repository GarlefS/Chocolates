/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.chocolateria.controlador;

import cl.duoc.chocolateria.modelo.Chocolate;
import cl.duoc.chocolateria.modelo.Marca;
import cl.duoc.chocolateria.modelo.MetodosCRUD;
import java.util.ArrayList;

/**
 *
 * @author LEARNING CENTER
 */
public class Controlador {
    private static ArrayList<Chocolate> chocs;
    private static ArrayList<Marca> marcas;
    private static Controlador auxiliar1;
//    private static Controlador auxiliar2;
    
    private  Controlador() {
        chocs = new ArrayList<>();
        marcas = new ArrayList<>();
        System.out.println("Arreglos creados..");
        
//        return cursos,estudiantes,listas;
    }
   
    public static Controlador generar1(){
        if(auxiliar1==null){
            auxiliar1 = new Controlador();
        }
        return auxiliar1;
    }
    
//    public static Controlador generar2(){
//        if(auxiliar2==null){
//            auxiliar2 = new Controlador();
//        }
//        return auxiliar2;
//    }

    
    
    public static ArrayList<Chocolate> getChocs() {
        return chocs;
    }
    public static ArrayList<Marca> getMarcas() {
        return marcas;
    }

    
    public static void setChocs(ArrayList<Chocolate> chocs) {
        Controlador.chocs = chocs;
    }

    public static void setMarcas(ArrayList<Marca> marcas) {
        Controlador.marcas = marcas;
    }
    
    
    
    
    //buscar boolean
    public boolean buscarMarca(Integer codigoMarca){
        for(Marca tmp: Controlador.getMarcas()){
            if(tmp.getCodigoMarca().equals(codigoMarca)){
               return true;
            }
        }
       return false;
    }
    
    public boolean buscarChocolate(Integer codigoChoc){
        for(Chocolate tmp: Controlador.getChocs()){
            if(tmp.getCodigoChoc().equals(codigoChoc)){
               return true;
            }
        }
       return false;
    }
    
    // get  chocolate y marca
    public Chocolate getChocolate(Integer codigoChoc){
        Chocolate aux = new Chocolate();
        for(Chocolate tmp: Controlador.getChocs()){
             if(tmp.getCodigoChoc().equals(codigoChoc)){
               aux = tmp;
            }           
        }
        return aux;
    }
    
    public Marca getMarca(Integer codigoMarca){
        Marca aux = new Marca();
        for(Marca tmp: Controlador.getMarcas()){
             if(tmp.getCodigoMarca().equals(codigoMarca)){
               aux = tmp;
            }           
        }
        return aux;
    }
    
    
    
    //agregar 
    
    
    public boolean agregarChocolate(Chocolate a){
        
        if((buscarChocolate(a.getCodigoChoc()))){
            System.out.println("El Chocolate ya está agregado.");
            return false;
        }else{
           Controlador.chocs.add(a);
           MetodosCRUD.metodo().agregarChocolate(a);
           return true;
        }
    }
    
    public boolean agregarMarca(Marca a){
        
        if((buscarMarca(a.getCodigoMarca()))){
            System.out.println("La marca ya está agregada.");
            return false;
        }else{
           Controlador.marcas.add(a);
           MetodosCRUD.metodo().agregarMarca(a);
           return true;
        }
    }
    
    //borrar
    
    public boolean BorrarChoc(Integer codigoChoc){
        
        
        for(Chocolate temp: Controlador.chocs){
            if(temp.getCodigoChoc().equals(codigoChoc)){
                Controlador.chocs.remove(temp);
                MetodosCRUD.metodo().borrarChocolate(codigoChoc);
                return true;
            }
        }
        System.out.println("El Chocolate no se encuentra en los registros.");
        return false;
    }
    
    public boolean BorrarMarca(Integer codigoMarca){
        
        for(Marca temp: Controlador.marcas){
            if(temp.getCodigoMarca().equals(codigoMarca)){
                Controlador.marcas.remove(temp);
                //MetodosCRUD.metodo().borrarSemilla(codigoChoc);
                return true;
            }
        }
        System.out.println("La marca no se encuentra en los registros.");
        return false;
    }
    
    //modificar
    public boolean modificarChoc(Chocolate b){
        if(buscarChocolate(b.getCodigoChoc())){
            Chocolate aux = getChocolate(b.getCodigoChoc());
            Integer indice = Controlador.chocs.indexOf(b);
            
            aux.setNombre(b.getNombre());
            aux.setDescripcion(b.getDescripcion());
            aux.setPrecio(b.getPrecio());
            aux.setCantidad(b.getCantidad());
            aux.setTipoChoc(b.getTipoChoc());
            aux.setTipoSabor(b.getTipoSabor());
            aux.setMarca(b.getMarca());
            aux.setAzucar(b.getAzucar());
            
            Controlador.chocs.set(indice, aux);
            MetodosCRUD.metodo().modificarChocolate(b);
            System.out.println("Chocolate modificado. ");
            return true;
        }
        
        return false;
    }
    
    public boolean modificarMarca(Marca b){
        if(buscarMarca(b.getCodigoMarca())){
            Marca aux = getMarca(b.getCodigoMarca());
            Integer indice = Controlador.marcas.indexOf(b);
            
            aux.setNombre(b.getNombre());
           
            Controlador.marcas.set(indice, aux);
            System.out.println("Marca modificada. ");
            return true;
        }
        
        return false;
    }
        
    public ArrayList ListarPorMarca(Integer codigoMarca){
        ArrayList<Chocolate> ests = new ArrayList<>();
        for(Marca tmp: marcas){
            if(tmp.getCodigoMarca().equals(codigoMarca)){
                ests = tmp.getChocos();
                return ests;
            }
        }
        System.out.println("La Marca no tiene choloates registrados. ");
        return ests;

    }
    
    public void cargarChocolateria(){
        MetodosCRUD.metodo().cargarMarcas();
        MetodosCRUD.metodo().cargarChocolateria();
        
    }
    
    
    public void vaciar(){
        chocs.removeAll(chocs);
        marcas.removeAll(marcas);
    }
}
