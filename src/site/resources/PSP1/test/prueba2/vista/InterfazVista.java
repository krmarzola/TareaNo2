/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram1.vista;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import pspprogram1.utilities.LectorDeArchivo;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class InterfazVista /*--*/
{
   /**
    * Método que emula el comportamiento de una vista donde se carga el archivo
    * @return lista enlazada de tipo double con el listado de numeros
    * @throws IOException Error en la lectura del archivo 
    */ 
   public LinkedList<Double> cargaArchivos() throws IOException /*++*/
   {
    javax.swing.JFileChooser j = new javax.swing.JFileChooser();
    File archivoCargado;
    j.showOpenDialog(j);
    try 
    {
        String path = j.getSelectedFile().getAbsolutePath();
        LinkedList<Double> listadoDeNumeros = new LinkedList<Double>();
        archivoCargado = new File(path);
        try 
        {
            LectorDeArchivo archivo = new LectorDeArchivo();
            listadoDeNumeros = archivo.leerArchivoPlano(archivoCargado);
        } 
        catch (IOException e) 
        {
          javax.swing.JOptionPane.showMessageDialog(j, "Error en la lectura del archivo: " + e.getMessage());
          System.exit(0);
        } 
            return listadoDeNumeros;
        } 
    catch (NullPointerException e) 
    {
       javax.swing.JOptionPane.showMessageDialog(j, "Ha finalizado la ejecución");
        System.exit(0);
    }
    return null;
   }//cargaArchivos
}
