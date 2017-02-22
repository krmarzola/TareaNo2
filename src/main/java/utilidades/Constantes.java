/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram2.utilidades;

import java.util.ArrayList;

/**
 *
 * @author Kevin Ray Marzola Otero
 * @since 19/02/2017
 * @version 1.0
 */
public class Constantes
{
    //Expresión regular definida para la lectura de las clases /*--*/
    public static final String CLASE = ".+\\/\\*--\\*\\/$";
    //Expresión regular definida para la lectura de los métodos /*--*/
    public static final String METODO = ".+\\/\\*\\+\\+\\*\\/$";
    
    // Listado de expresiones regulares para los comentarios y espacios en blanco
    public static ArrayList<String> COMENTARIOS_ESPACIOS_EN_BLANCO = new ArrayList<String>()
    {
        private static final long serialVersionUID = 1L;
        {
            add("^(\\s+)?\\/\\*{2}(.+)?(\\s+)?$"); // Validacion /** Comentarios
            add("^(\\s+)?\\*(\\s+|.+)?$"); // Validacion * Comentarios
            add("^(\\s+)?\\*\\/(\\s+)?$"); // Validacion */ Comentarios
            add("^(\\s+)?\\/\\*(.+)?(\\s+)?$"); // Validacion /* Comentarios
            add("^(\\s+)?$"); // Validacion Espacio en Blanco
            add("^(\\s+)?(\\/\\/)(.+)?(\\s+)?$"); // Validacion //
        }
    };
    
    //Listado de expresiones regulares para las etiquetas y los imports y paqueteria
    public static ArrayList<String> OTROS = new ArrayList<String>()
    {
        private static final long serialVersionUID = 1L;
        {
                add("^(\\s+)?(@\\w+)((\\s+)?(\\w+))+?(\\s+)?$"); // etiqueta @
                //add("^(\\s+)?(import|package)\\D+(;)(\\s+)?$"); // Validacion import y paqueteria
        }
    };

}
