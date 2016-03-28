package edu.uniandes.ecos.ASE.app;


import edu.uniandes.ecos.ASE.app.model.EstructuraSimpson;
import java.util.LinkedList;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import util.Archivo;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
    private LinkedList listaDeDatos = Archivo.leerArchivo();
    private EstructuraSimpson eSimpson = null;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    /**
     * #Method
     * 
     * TestCase1. La linea leida debe tener 4 elementos unicamente (0. Rango Inicial, 1. Rango Final, 2. numero de segmentos, 3. dof)
     * 
     * @author Claudia Marcela Alvarez Ramos
     */
    public void testCase1()
    {
        if(listaDeDatos!=null){
            assertEquals(((LinkedList<Double>)listaDeDatos.get(0)).size()==4, true);
            assertEquals(((LinkedList<Double>)listaDeDatos.get(1)).size()==4, true);
            assertEquals(((LinkedList<Double>)listaDeDatos.get(2)).size()==4, true);
        }
    }
    
     /**
     * #Method
     * 
     * TestCase2 Evaluar que el rango sea valido (Esto quiere decir, donde el primer valor del rango sea mayor o igual a cero
     * y el segundo valor del rango sea mayor al primero)
     * 
     * @author Claudia Marcela Alvarez Ramos
     * 
     */
    public void testCase2()
    {
        LinkedList<Double> listaValores = ((LinkedList<Double>)listaDeDatos.get(0));
        if(listaValores.get(0)>=0 && listaValores.get(1)>listaValores.get(0))
            assertTrue(true);
        
    }
    
     /**
     * #Method
     * 
     * TestCase3. Evaluar que numero de segmentos sea positivo mayor que cero
     * 
     * @author Claudia Marcela Alvarez Ramos
     */
    
      public void testCase3(){
        LinkedList<Double> listaValores = ((LinkedList<Double>)listaDeDatos.get(0));
        assertEquals(listaValores.get(2)>0,true);
    }
    
     /**
     * #Method
     * 
     * TestCase4. Evaluar que la variable dof sea positivo mayor que cero
     * 
     * @author Claudia Marcela Alvarez Ramos
     */
    
    public void testCase4()
    {
        LinkedList<Double> listaValores = ((LinkedList<Double>)listaDeDatos.get(0));
        assertEquals(listaValores.get(3)>0,true);
    }
    
      /**
     * #Method
     * 
     * TestCase5.  Si el valor del resultado actual cumple con un margen de error de 0.05
     * 
     * @author Claudia Marcela Alvarez Ramos
     */
    
    public void testCase5()
    {
        EstructuraSimpson e1 = new EstructuraSimpson(((LinkedList<Double>)listaDeDatos.get(0)));
        EstructuraSimpson e2 = new EstructuraSimpson(((LinkedList<Double>)listaDeDatos.get(1)));
        EstructuraSimpson e3 = new EstructuraSimpson(((LinkedList<Double>)listaDeDatos.get(2)));
        assertEquals((e1.getP()-0.35006)<0.05,true);
        assertEquals((e2.getP()-0.36757)<0.05,true);
        assertEquals((e3.getP()-0.49500)<0.05,true);
    }
    
    
}

