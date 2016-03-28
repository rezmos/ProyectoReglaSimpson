/**
 * Esta clase es una libreria de archivos
 *
 * Fecha de creacion: Febrero 28 de 2016
 *
 * @Version 1.2
 * @Author Claudia Marcela Alvarez Ramos
 */

package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Archivo {
	/**
         *  #Method
         *  Este método se encarga de leer el archivo "datos" que se encuentra en el directorio data, cada linea de datos
         *  (Ejemplo, linea de datos: 160,591,114,229,230,270,128,1657,624,1503).
         *  la convierte en un LinkedList<Double> con todos los datos de la linea y esta coleccion es adicionada a la lista 
         *  que contiene todas las lineas de datos hasta el final del archivo.
         * 
         *  @author Claudia Marcela Alvarez Ramos
         *  @return una lista de listas con los set de pruebas
	 */
	public static LinkedList leerArchivo() {
		String filePath = new File("").getAbsolutePath();
		BufferedReader reader;
                String line;
                LinkedList result = new LinkedList();
		try {
			reader = new BufferedReader(new FileReader(filePath + "/src/main/java/data/datos"));
			try {
				while ((line = reader.readLine()) != null && !line.isEmpty()) {
					result.add(convertirDatosALinkedList(line));
				}
			} catch (FileNotFoundException e) {} 
                        finally {
				reader.close();
			}
		} catch (IOException ex) {}
		return result;
	}
	/**
	 *  #Method
         *  Este método se encarga de convertir un String que contiene una lista de numeros,separados por comas en una coleccion de datos.
         *  (Ejemplo, linea de datos: 160,591,114,229,230,270,128,1657,624,1503).
         *  Cada numero es almacenado en la coleccion en el mismo orden que es leido del String.
         * 
         *  @author Claudia Marcela Alvarez Ramos
         *  @param line de datos
         *  @return Lista de Doubles
	 */

	public static LinkedList<Double> convertirDatosALinkedList(String line) {
		LinkedList<Double> result = null;
		if (!line.isEmpty()) {
			List<String> list = Arrays.asList(line.split(","));
			if (list.size() > 0) {
				result = new LinkedList<Double>();
				for (String dato : list) {
					if(LibreriaFuncionesEstadisticas.esNumero(dato))
						result.add(new Double(dato));
					else{
						result = null;
						break;
					}
				}
			}
		}
		return result;
	}
}
