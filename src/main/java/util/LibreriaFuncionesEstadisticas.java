/**
 * Esta clase es una libreria de funciones estadisticas
 *
 * Fecha de creacion: Febrero 28 de 2016
 * Fecha de modificación: Marzo 24 de 2016
 * @Version 1.2
 * @Author Claudia Marcela Alvarez Ramos
 */

package util;
import edu.uniandes.ecos.ASE.app.model.EstructuraSimpson;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;


public class LibreriaFuncionesEstadisticas {
    /**
     * #Method
     * Este método se encarga de sumar todos los datos de la coleccion recibida por paramentros
     * 
     * @param lista
     * @author Claudia Marcela Alvarez Ramos
     * @return el total de la sumatoria
     */
        public static Double sumar(LinkedList<Double> lista){
		Double result= new Double(0);
		for (Double dato : lista) {
			result+=dato;
		}
		return result;
	}
        /**
         * #Method
         * 
         * Este método se encarga de calcular el promedio de la lista de datos recibida por parametros
         * 
         * @param lista
         * @author Claudia Marcela Alvarez Ramos
         * @return el promedio de la lista recibida por parametros
         */
	public static Double calcularMedia(LinkedList<Double> lista){
                Double tamaño = new Double(lista.size());
		if(tamaño > 0){
			return LibreriaFuncionesEstadisticas.redondear(sumar(lista)/tamaño, 4);
		}
		return tamaño;
	}
        
        /**
         * #Method
         * 
         * Este método se encarga de realizar la sumatoria de cada uno de los valores de la lista al cuadrado,
         * 
         * @param lista de datos
         * @author Claudia Marcela Alvarez Ramos
         * @return el total de la sumatoria  
         */
        public static Double calcularCuadrado(LinkedList<Double> lista){
                Double result= new Double(0);
                for (Double dato : lista) {
			result+=Math.pow(dato, 2);
		}
                return result;
        }
        
        /**
         * #Method
         * 
         * Este método se encarga de realizar la sumatoria de el resultado de multiplicar los componentes de dos listas en la misma posicion.
         * 
         * @param lista1
         * @param lista2
         * @author Claudia Marcela Alvarez Ramos
         * @return  el total de la sumatoria
         */
        public static Double calcularMultiplicacionListasDeDatos(LinkedList<Double> lista1, LinkedList<Double> lista2){
                Double result= new Double(0);
                for (int i=0; i< lista1.size(); i++) {
			result+=(lista1.get(i)*lista2.get(i));
		}
                return result;
        }
       
        /**
         * #Method
         * 
         * Este método se encarga de calcular el termino B1
         * 
         * @param producto
         * @param tamaño
         * @param promedioX
         * @param promedioY
         * @param cuadrado
         * @author Claudia Marcela Alvarez Ramos
         * @return B1
         */
        public static Double calcularB1(Double producto, int tamaño, Double promedioX, Double promedioY, Double cuadrado){
            
            return((producto-(tamaño*promedioX*promedioY))/(cuadrado-(tamaño*Math.pow(promedioX, 2))));
        }
        
        /**
         * #Method
         * 
         * Este método se encarga de calcular el termino BO
         * 
         * @param promedioY
         * @param promedioX
         * @param b1
         * @author Claudia Marcela Alvarez Ramos
         * @return B0
         */
         public static Double calcularB0(Double promedioY, Double promedioX, Double b1){
            return(promedioY-(b1*promedioX));
        }
         
         /**
          *  #Method
          * 
          * Este método se encarga de calcular el termino Yk
          * @param b0
          * @param b1
          * @param promedioX
          * @author Claudia Marcela Alvarez Ramos
          * @return yK
          */
        
        public static Double calcularYk(Double b0, Double b1, Double promedioX){
            return(b0+(b1*promedioX));
        }
        
        /**
         * #Method
         * 
         * Este método se encarga de calcular el termino Rxy
         * 
         * @param sumatoriaColeccionX
         * @param sumatoriaColeccionY
         * @param producto
         * @param cuadradoX
         * @param cuadradoY
         * @param tamaño
         * @author Claudia Marcela Alvarez Ramos
         * @return Rxy
         */
         public static Double calcularRxy(Double sumatoriaColeccionX, Double sumatoriaColeccionY, Double producto, Double cuadradoX, Double cuadradoY, int tamaño){
            
            return((tamaño*producto)-(sumatoriaColeccionX*sumatoriaColeccionY))/(Math.sqrt(((tamaño*cuadradoX)-Math.pow(sumatoriaColeccionX, 2))*((tamaño*cuadradoY)-Math.pow(sumatoriaColeccionY, 2))));
        }
         
         /**
          * #Method
          * 
          * Este método se encarga de calcular el cuadrado del termino Rxy 
          * 
          * @param sumatoriaColeccionX
          * @param sumatoriaColeccionY
          * @param producto
          * @param cuadradoX
          * @param cuadradoY
          * @param tamaño
          * @author Claudia Marcela Alvarez Ramos
          * @return 
          */
         public static Double calcularRxy2(Double sumatoriaColeccionX, Double sumatoriaColeccionY, Double producto, Double cuadradoX, Double cuadradoY, int tamaño){
            return Math.pow(LibreriaFuncionesEstadisticas.calcularRxy(sumatoriaColeccionX, sumatoriaColeccionY, producto, cuadradoX,  cuadradoY,  tamaño), 2);
        }
         
        /**
         * #Method
         * 
         * Este método se encarga de calcular la desviacion estandar de los datos de la lista
         * @param lista
         * @author Claudia Marcela Alvarez Ramos
         * @return 
         */
	public static Double calculaDesviacionEstandar(LinkedList<Double> lista){
		Double result= new Double(0);
		Double tamaño = new Double(lista.size());
		Double media = LibreriaFuncionesEstadisticas.calcularMedia(lista);
		for (Double dato : lista) {
			result+=Math.pow((dato - media),2);
		}
		if(tamaño > 0){
			
			return LibreriaFuncionesEstadisticas.redondear(Math.sqrt(result/(tamaño-1)),4);
		}
		return tamaño;
	}
	/**
         * Este método se encarga de calcular la desviacion estandar
         * @param lista
         * @param media
         * @author Claudia Marcela Alvarez Ramos
         * @return 	/**
         * Este método se encarga de calcular la desviacion estandar
         * @param lista
         * @param media
         * @author Claudia Marcela Alvarez Ramos
         * @return 
         */
        
         
	public static Double calculaDesviacionEstandar(LinkedList<Double> lista, Double media){
		Double result= new Double(0);
		Double tamaño = new Double(lista.size());
		for (Double dato : lista) {
			result+=Math.pow((dato - media),2);
		}
		if(tamaño > 0){
			
			return LibreriaFuncionesEstadisticas.redondear(Math.sqrt(result/(tamaño-1)),4);
		}
		return tamaño;
	}
	/**
         * #Method
         * 
         * Este método se encarga de redondear el numero flotante con una cantidad de decimales especifivos 
         * 
         * @param numero
         * @param decimals
         * @author Claudia Marcela Alvarez Ramos
         * @return el numero redondeado
         */
	public static Double redondear(Double numero, int decimals){
		BigDecimal b0p = new BigDecimal(numero);
                return (b0p.setScale(decimals, RoundingMode.HALF_UP)).doubleValue();
	}
         /**
         * #Method
         * 
         * Este método se encarga de calcular el logaritmo natural por elemento de la lista y retorna
         * una nueva lista con todos los elementos con su ln.
         * 
         * @param lista
         * @author Claudia Marcela Alvarez Ramos
         * @return el promedio de la lista recibida por parametros
         */
	public static LinkedList<Double> calcularLnPorElemento(LinkedList<Double> lista){
                LinkedList<Double> lValores = new LinkedList<Double>();
                for (Double valor : lista) {
                    lValores.add(LibreriaFuncionesEstadisticas.redondear(Math.log(valor),4));
                }
		return lValores;
	}
         /**
         * #Method
         * 
         * Este método se encarga de calcular el logaritmo natural por elemento de la lista y retorna
         * una nueva lista con todos los elementos con su ln.
         * 
         * @param lista
         * @author Claudia Marcela Alvarez Ramos
         * @return la estructura simpson 
         */
         public static EstructuraSimpson calcularReglaSimpson(LinkedList<Double> lista){
            EstructuraSimpson e= new EstructuraSimpson((LinkedList<Double>)lista);
            LinkedList<Double> rTemp= new LinkedList<Double>();
            double c1 = 0;
            double c2 = 0;
            double c3 = 0;
            double c4 = 0;
            for (int i = 0; i <= e.getNumSegmentos(); i++) {
                 c1=redondear(i*e.getW(),2);
                 c2=redondear(1+(Math.pow(c1, 2)/e.getDof()),5);
                 c3=redondear(Math.pow(c2, -((e.getDof()+1)/2)),5);
                 c4=redondear(c3*e.getCons(),5);
                 if(i==0 ||i==10)
                    rTemp.add(redondear(e.getW()/3*c4,4));
                 else if(i%2==0)
                     rTemp.add(redondear(e.getW()/3*c4*2,4));
                 else
                     rTemp.add(redondear(e.getW()/3*c4*4,4));
            }
            e.setP(sumar(rTemp));
            return e;
        }
        /**
         * #Method
         * 
         * Este método se encarga de dar formato a un número especifico
         * @param numero
         * @param format
         * @author Claudia Marcela Alvarez Ramos
         * @return el número redondeado
         */
        public static Double darFormato(Double numero, String format){
		DecimalFormat df = new DecimalFormat(format);
		return(new Double((df.format(numero)).replace(',', '.')));
	}

        /**
         * #Method
         * 
         * Este método se encarga de validar si el string es un numero o no
         * 
         * @param str
         * @author Claudia Marcela Alvarez Ramos
         * @return true si es un numero, de lo contrario false
         */
      
	public static boolean esNumero(String str)  
	{  
	  try  
	  {  
	     Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
        /**
         * #Method
         * 
         * Este método se encarga de retornar verdadero si es entero de lo contrario retornara falso
         * 
         * @param str
         * @author Claudia Marcela Alvarez Ramos
         * @return true si es un numero, de lo contrario false
         */
        public static boolean esEntero(Double valor){
            return (valor%1==0?true:false);
        }
        
        /**
         * #Method
         * 
         * Este método se encarga de calcular el valor gamma entero para la regla de simpson
         * 
         * @param gamma
         * @author Claudia Marcela Alvarez Ramos
         * @return el valor gama
         */
        
        public static Double calcularGamaEntera(Double gamma){
            if(gamma==1)
                return gamma;
            else
                return calcularGamaEntera(gamma -1)*(gamma-1);
        }
        
        /**
         * #Method
         * 
         * Este método se encarga de calcular el valor gamma decimal para la regla de simpson
         * 
         * @param gamma
         * @author Claudia Marcela Alvarez Ramos
         * @return el valor gama
         */
        
        public static Double calcularGamaDecimal(Double gamma){
            if(gamma==0.5)
                return (gamma)*Math.sqrt(Math.PI);
            else
                return calcularGamaDecimal(gamma -1)*(gamma);
        }

        
        
       
}
