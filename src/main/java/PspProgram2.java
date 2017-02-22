/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import pspprogram2.vista.InterfazVista;
import pspprogram2.utilidades.Utilidades;
/**
 * Clase de tipo controlador que selecciona las carpetas y el proceso de conteo
 * de lineas de código
 * @author Kevin Ray Marzola Otero
 * @since 19/02/2017
 * @version  1.0
 */
public class PspProgram2 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Utilidades> listaArchivos = new ArrayList<Utilidades>();
        ArrayList<File> listaDeArchivosConExtension = new ArrayList<File>();
        try
        {
            File directorioRaiz = new File(new InterfazVista().LeerRutaDirectorioRaiz());
            ArrayList<File> listaDeArchivos = Utilidades.obtenerArchivosDeDirectorioRaizRecursivo(directorioRaiz, listaDeArchivosConExtension);
            if(listaDeArchivos.size() > 0)
            {
                for (File archivo : listaDeArchivos)
                {
                   Utilidades objTemporal = new Utilidades(archivo);
                   objTemporal.leerArchivosJava();
                   listaArchivos.add(objTemporal);
                }
            }
            else
            {
                System.out.println("El directorio seleccionado no contiene archivos");
            }
        }
        catch (Exception e)
        {
             System.out.println("Error: " + e.getMessage());	
        }
        imprimirResultado(listaArchivos);
    }
    
    /**
     * Imprime el resultado esperado
     * @param lista 
     */
    private static void imprimirResultado(List<Utilidades> lista)
    {  
        for(Utilidades objTemporal : lista)
            System.out.println(objTemporal);   
       System.out.println("Total Lineas: " + Utilidades.contadorTotalDeLineas); 
    }//imprimirResultado
    
}
