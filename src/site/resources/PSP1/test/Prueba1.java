/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram1;

import java.io.IOException;
import java.util.LinkedList;
import pspprogram1.utilities.OperacionNumerica;
import pspprogram1.vista.InterfazVista;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class PspProgram1 /*--*/
{

    /**
     *  Clase Principal que cumple las funciones de controlador de la aplicación
     * @author Kevin Ray Marzola Otero
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException /*++*/
    {
        try
        {
            // TODO code application logic here
            int numeroDePruebas = 2;
            for(int prueba = 0; prueba < numeroDePruebas ; prueba++)
            {
                LinkedList<Double> listaDeDatos = new InterfazVista().cargaArchivos();
                OperacionNumerica resultado = new OperacionNumerica();
                double media = resultado.calcularMedia(listaDeDatos);
                double desviacionEstandar = resultado.calcularDesviacionEstandar(listaDeDatos);
                System.out.println("La media de los datos para la prueba " + prueba + 1 + " es:" +  media + " con una desviación estandar de: " + desviacionEstandar + ".\n");
            }    
        }
        catch(IOException e)
        {
            System.out.println("Error al cargar archivo " + e.getMessage());		
		}
    }

	private void test() /*++*/
	{
		if(true)
		 System.out.println(":)");
		else
		 System.out.println(";(";
	}	
}
