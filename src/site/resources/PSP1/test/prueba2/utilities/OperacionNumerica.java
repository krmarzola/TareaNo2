/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram1.utilities;

import java.util.LinkedList;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class OperacionNumerica /*--*/
{
    
    /**
     * 
     * @param listaDeNumeros
     * @return 
     */
    public double calcularMedia(LinkedList<Double> listaDeNumeros) /*++*/
    { 
        double sumatoria = 0;
        for(double valor : listaDeNumeros)
            sumatoria += valor;
        return ((double)sumatoria/(double)listaDeNumeros.size());    
    }
    
    /**
     * 
     * @param listaDeNumeros
     * @return 
     */
    public double calcularDesviacionEstandar(LinkedList<Double> listaDeNumeros) /*++*/
    {
      double media = calcularMedia(listaDeNumeros);
      double sumatoria= 0;
       for (Double numero : listaDeNumeros)
           sumatoria += Math.pow(numero - media, 2);
      return (Math.sqrt(sumatoria / listaDeNumeros.size()));
    } 
}
