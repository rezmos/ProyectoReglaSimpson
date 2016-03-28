/**
 * Esta clase es el punto de entrada a la aplicacion
 *
 * Fecha de creacion: Marzo 10 de 2016
 *
 * @Version 1.1
 * @Author Claudia Marcela Alvarez Ramos
 */
import edu.uniandes.ecos.ASE.app.model.EstructuraSimpson;
import java.util.ArrayList;
import static spark.Spark.*;
import java.util.LinkedList;
import java.util.List;
import util.Archivo;
import static spark.Spark.get;
import util.LibreriaFuncionesEstadisticas;

public class Main {
    /**
     * #Method
     * 
     * Este método es el método principal de la aplicacion
     * 
     * @param args 
     * @author Claudia Marcela Alvarez Ramos
     * @return B0
    
     */
    

   public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        double valoresEsperados [] = {0.35006,0.36757,0.49500};
        get("/simpson-rule", (req, res) -> {
            String retorno;
            List<EstructuraSimpson> casosPrueba = new ArrayList<EstructuraSimpson>();
            LinkedList listaDeDatos = (Archivo.leerArchivo());
            if(listaDeDatos!=null){
                for (Object lista : listaDeDatos) {
                    casosPrueba.add(LibreriaFuncionesEstadisticas.calcularReglaSimpson((LinkedList<Double>)lista));
                }
            }
            //dibujarTablaValores.DibujarReporte(casosPrueba);

            retorno = "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<style>"
                    + "table, th, td {"
                    + "border: 1px solid black;"
                    + "border-collapse: collapse;"
                    + "}"
                    + "th, td {"
                    + "padding: 5px;"
                    + "text-align: left;"
                    + "}"
                    + "table#t01 {"
                    + "width: 100%;    "
                    + "background-color: #A9BCF5;"
                    + "}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table id=\"t01\">"
                    + "<tbody>"
                    + "<tr>"
                    + "<th>x</th>"
                    + "<th>dof</th>"
                    + "<th>p(Expected Value)</th>"
                    + "<th>p(Actual Value)</th>"
                    + "</tr>";
            int i = 0;
            for (EstructuraSimpson casoPrueba : casosPrueba) {
                retorno += "<tr>"
                        + "<td>" + casoPrueba.getNombre() + "</td>"
                        + "<td>" + casoPrueba.getDof()+ "</td>"
                        + "<td>" + casoPrueba.getP()+ "</td>"
                        + "<td>" + valoresEsperados[i]+ "</td>"
                        + "</tr>";
                i++;
            }
            retorno += "</tbody>"
                    + "</table>"
                    + "</body>"
                    + "</html>";
            return retorno;
        });
    }
   
}
