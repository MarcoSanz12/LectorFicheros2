/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivocsv;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author belen
 */
public class ArchivoCSV {

	private static String readFile = System.getProperty("user.dir") + "/src/main/java/archivocsv/eventos-octubre.csv";
	private static String writeFile = System.getProperty("user.dir") + "/src/main/java/archivocsv/resultado.csv";
    //leer archivos
    public static ArrayList<DatosCSV> readCSV() throws FileNotFoundException {
        ArrayList<DatosCSV> listaDatos = new ArrayList<>();
        
        if (new File(readFile).isFile()) {
            BufferedReader reader = new BufferedReader(new FileReader(readFile));
            String fila;
           
            try {
				while ((fila = reader.readLine()) != null) {
				    String[] datos = fila.split(";");
				    System.out.println(Arrays.toString(datos));
				    listaDatos.add(new DatosCSV(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]));
				}
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
           
        } else {
            System.out.println(System.getProperty("Error"));
        }

        return listaDatos;
    }
    
    
    
    // escribir archivos CSV
     
public static void writeCSV(DatosCSV obj) throws Exception {
        FileWriter writer = new FileWriter(writeFile, true);
        writer.append(obj.getDato1() + ",");
        writer.append(obj.getDato2() + ",");
        writer.append(obj.getDato3() + ",");
        writer.append(obj.getDato4() + ",");
        writer.append(obj.getDato5() + ",");
        writer.append(obj.getDato6());
        writer.append("\n");

        writer.flush();
        writer.close();
        
        Desktop.getDesktop().open(new File(writeFile));
    }

}
