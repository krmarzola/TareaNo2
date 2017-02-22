/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram1.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author PERSONAL
 */
public class LectorDeArchivo/*--*/
{ 
    
    /**
     * Método que lee el archivo cargado
     * @param archivo Objeto de tipo File con información del archivo cargado
     * @return lista enlazada de tipo Double con el listado de datos
     * @throws IOException Error al leer el archivo
     */
    public LinkedList<Double> leerArchivoPlano(File archivo) throws IOException /*++*/
    {
        LinkedList<Double> listaDeDatos = new LinkedList<Double>();
        String linea;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader(archivo)); 
            try
            {
                while ((linea = br.readLine()) != null) 
                {
                   Double numeroReal = Double.parseDouble(linea);
                   listaDeDatos.add(numeroReal);
                }
            }
             catch (IOException ex) 
            {
                System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): Error al leer el archivo " + archivo.getAbsolutePath() + ex.getMessage());
            }
            finally 
            {
              br.close();
            }
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("pspprogram1.utilities.LectorDeArchivo.LectorDeArchivo(): El archivo " + archivo.getAbsolutePath() + "no fue leido correctamento, por favor"
                    + "valide que es un archivo con extensión .txt");
        }
       return listaDeDatos;
    }//leerArchivoPlano
    
}
