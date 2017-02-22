/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pspprogram2.vista;

import javax.swing.JFileChooser;

/**
 *
 * @author Kevin Ray Marzola Otero
 */
public class InterfazVista 
{   
    /**
     * Muestra el dialog para seleccionar la ruta del directorio raiz
     * @return 
     */
    public String LeerRutaDirectorioRaiz()
    {
        String direccion;
        javax.swing.JFileChooser j = new javax.swing.JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        j.showOpenDialog(j);
        direccion = j.getSelectedFile().getAbsolutePath();
        if(direccion.equals(null) || direccion.equals(""))
        {
                javax.swing.JOptionPane.showMessageDialog(j, "El programa ha finalizado.");
                System.exit(0);
        }
        return direccion;
    }
    
    
}
