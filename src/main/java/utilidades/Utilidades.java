/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram2.utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kevin Ray Marzola Otero
 * @since 19/02/207
 * @version 1.0
 */
public class Utilidades 
{
    // Constantes
    public static long contadorTotalDeLineas = 0;
    private File archivoJava;
    private int contadorDeClases = 0;
    private int contadorDeMetodos = 0;
    private int contadorDeLineas = 0;

    //Contructor
    public Utilidades(File archivoJava) 
    {
        this.archivoJava = archivoJava;
    }
    
    /**
     * Método recursivo que obtiene el listado de archivos contenidos en un directorio raiz
     * @param directorioRaiz directorio raiz donde están alojados los archivos
     * @param listaDeArchivosConExtension listaDeArchivos a definir
     * @return Listado de los archivos encontrados
     * @throws Exception Error al leer los archivos
     */
    public static ArrayList<File> obtenerArchivosDeDirectorioRaizRecursivo(File directorioRaiz, ArrayList<File> listaDeArchivosConExtension) throws Exception 
    {
        try 
        {
            for (File buscarArchivosDirectorioRaiz : directorioRaiz.listFiles()) 
            {
                if (buscarArchivosDirectorioRaiz.isDirectory()) 
                {
                    obtenerArchivosDeDirectorioRaizRecursivo(buscarArchivosDirectorioRaiz, listaDeArchivosConExtension);
                }
                if (buscarArchivosDirectorioRaiz.isFile()) 
                {
                    listaDeArchivosConExtension.add(buscarArchivosDirectorioRaiz);
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("pspprogram2.utilidades.obtenerArchivosDeDirectorioRaizRecursivo.obtenerArchivosDeDirectorioRaizRecursivo(): El archivo " + directorioRaiz.getAbsolutePath() + "no fue leido correctamento, por favor"
                    + "valide que es un archivo con extensión .java" + e);
        }
        return listaDeArchivosConExtension;
    }//obtenerArchivosDeCarpetaRaizRecursivo

    /**
     * Se encarga de la lectura de las lineas de codigo de cada archivo y cuenta las clases, métodos y lineas de codigo del mismo
     */    
    public void leerArchivosJava() throws Exception {
        FileReader fr = null;
        BufferedReader br = null;
        String linea;
        try 
        {
            fr = new FileReader(archivoJava);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea != null) 
            {
                if (!validarLineaPatrones(Constantes.COMENTARIOS_ESPACIOS_EN_BLANCO, linea) || !validarLineaPatrones(Constantes.OTROS, linea)) 
                {
                    linea = br.readLine();
                    continue;
                } 
                else if (validarLineas(Constantes.CLASE, linea)) 
                {
                    contadorDeClases++;
                    contadorDeLineas++;                    
                } 
                else if (validarLineas(Constantes.METODO, linea)) 
                {
                    contadorDeMetodos++;
                    contadorDeLineas++;
                } 
                else 
                {
                    contadorDeLineas++;
                }
                linea = br.readLine();
            }
            contadorTotalDeLineas += contadorDeLineas;
            br.close();
            fr.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e.getLocalizedMessage());
            System.exit(0);
            br.close();
            fr.close();
        }
    }//leerArchivosJava

    /**
     * Método que valida que la linea de código leida cumpla con el listado de patrones indicados
     * @param patrones lista de patrones definidos mediante expresiones regulares
     * @param linea linea del codigo a leer 
     * @return Objeto tipo Boolean que retorna true (encaja con el patron) false (no encaja con el patron)
     */    
    private boolean validarLineaPatrones(ArrayList<String> patrones, String linea) 
    {
        Pattern p;
        Matcher m;
        boolean seCuentaLinea = true;
        for (String expresionRegular : patrones) 
        {
            p = Pattern.compile(expresionRegular);
            m = p.matcher(linea);
            while (m.find()) 
            {
                seCuentaLinea = false;
                break;
            }
            if (!seCuentaLinea) 
            {
                break;
            }
        }
        return seCuentaLinea;
    }//validarLineaPatrones

    /**
     * Método que valida que la linea de código leida cumpla con el patron indicado
     * @param patron
     * @param linea
     * @return
     */
    private boolean validarLineas(String patron, String linea) 
    {
        Pattern p;
        Matcher m;
        boolean seCuentaLinea = false;
        p = Pattern.compile(patron);
        m = p.matcher(linea);
        while (m.find()) 
        {
            seCuentaLinea = true;
            break;
        }
        return seCuentaLinea;
    }//validarLineas

    @Override
    public String toString() 
    {
        return archivoJava.getName() + "- Número de clases: " + contadorDeClases +" - Número de metodos: " + contadorDeMetodos + " - Número de Lineas de código: " + contadorDeLineas;
    }//toString

}
