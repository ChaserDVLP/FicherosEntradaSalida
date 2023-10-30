/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ad_ejercicioficheros1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author xChas
 */
public class AD_EjercicioFicheros1 {

    public static void main(String[] args) {

        String linea;
        String[] lista;
        String resultado;
        BufferedReader entrada = null;
        BufferedWriter salida = null;
        
        try {
            entrada = new BufferedReader(new FileReader("alumnosNotas.txt"));
            salida = new BufferedWriter(new FileWriter("AlumnosMedias.txt"));
            linea = entrada.readLine();
            while (linea != null) {
                int notaMedia = 0;
                lista = linea.split(":");
                
                for (int i = 1; i < lista.length; i++) {
                    int nota = Integer.parseInt(lista[i]);
                    notaMedia += nota;
                }
                notaMedia /= 3;
                resultado = "La nota de "+lista[0]+" es "+notaMedia+"\n";
                System.out.print(resultado);
                salida.write(resultado);
                
                linea = entrada.readLine();

            }
            
            
        } catch (IOException ex) {
            System.out.println("No se ha encontrado el archivo");
            
        } finally {
            
            try {
                if(entrada != null) {
                entrada.close();
            }
                if(salida != null) {
                    salida.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
        
    }
    
}
