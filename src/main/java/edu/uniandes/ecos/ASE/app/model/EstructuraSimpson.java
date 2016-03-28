/**
 * Esta clase representa la estructura de campos para el calculo de la regla de simpson
 *
 * Fecha de creacion: Marzo 26 de 2016
 *
 * @Version 1.1
 * @Author Claudia Marcela Alvarez Ramos
 */package edu.uniandes.ecos.ASE.app.model;

import java.util.LinkedList;
import util.LibreriaFuncionesEstadisticas;

 public class EstructuraSimpson {
    private double rangoInicial;
    private double rangoFinal;
    private double numSegmentos;
    private double w;
    private double dof;
    private double gP;
    private double gS;
    private double p;
    private double cons;
    private String nombre;
            
    /**
     * #Method. Constructor
     * @param lista 
     */
    public EstructuraSimpson(LinkedList<Double> lista){
       this.rangoInicial=lista.get(0);
       this.rangoFinal = lista.get(1);
       this.numSegmentos =lista.get(2);
       this.dof=lista.get(3); 
       this.w = LibreriaFuncionesEstadisticas.redondear((this.rangoFinal/this.numSegmentos),2 );
       this.gP = this.calcularGamas((this.dof+1)/2.0);
       this.gS = this.calcularGamas((this.dof)/2.0);
       this.cons = LibreriaFuncionesEstadisticas.redondear((this.gP/(Math.pow((this.dof*Math.PI), 0.5)*this.gS)), 3);
       this.nombre = " "+this.rangoInicial+" to x="+this.rangoFinal;
    }
    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor gamma entero o decimal de acuerdo al valor ingresado.
     * Si el valo ingresado es entero entonces calculara la gamma entera, en caso contrario calculara la gama decimal.
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return gamma
     */

    public Double calcularGamas(Double gamma){
        if(LibreriaFuncionesEstadisticas.esEntero(gamma))
            return LibreriaFuncionesEstadisticas.calcularGamaEntera(gamma);
        else
            return LibreriaFuncionesEstadisticas.calcularGamaDecimal(gamma-1);
    }
    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del rango Inicial
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return rangoInicial
     */

    public double getRangoInicial() {
        return rangoInicial;
    }

    
    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino RangoInicial
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param RangoInicial
     */

    public void setRangoInicial(double rangoInicial) {
        this.rangoInicial = rangoInicial;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del rango Final
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return B0
     */

    public double getRangoFinal() {
        return rangoFinal;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino RangoFinal
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param RangoFinal
     */
    public void setRangoFinal(double rangoFinal) {
        this.rangoFinal = rangoFinal;
    }
    
    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del numero segmentos
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return numero de segmentos
     */

    public double getNumSegmentos() {
        return numSegmentos;
    }

     /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino número de segmentos
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param numeroSegmentos
     */
    public void setNumSegmentos(double numSegmentos) {
        this.numSegmentos = numSegmentos;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro w
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return w
     */

    public double getW() {
        return w;
    }

     /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino w
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param  w
     */
    public void setW(double w) {
        this.w = w;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro dof
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return dof
     */

    public double getDof() {
        return dof;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino dof
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param dof
     */

    public void setDof(double dof) {
        this.dof = dof;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro GP
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return GP
     */

    public double getGP() {
        return gP;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino GP (gama entero)
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param GP
     */

    public void setGP(double gP) {
        this.gP = gP;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro gS (gama decimal)
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return 
     */

    public double getGS() {
        return gS;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino número de segmentos
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param numeroSegmentos
     */

    public void setGS(double gS) {
        this.gS = gS;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro P
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return P
     */    
    public double getP() {
        return p;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino P
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param P
     */

    public void setP(double p) {
        this.p = p;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del parametro Cons
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return Cons
     */    
    public double getCons() {
        return cons;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del termino CONS
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param cons
     */
    public void setCons(double cons) {
        this.cons = cons;
    }

    /**
     * #Method
     * 
     * Este método se encarga de obtener el valor del nombre
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @return nombre
     */    
    public String getNombre() {
        return nombre;
    }

    /**
     * #Method
     * 
     * Este método se encarga de modificar la valor del nombre
     * 
     * @author Claudia Marcela Alvarez Ramos
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    @Override
    public String toString() {
        return ""+this.getNombre()+"Ri: "+this.getRangoInicial()+", rf:"+this.getRangoFinal()+", dof:"+this.getDof()+", w:"+this.getW()+", cons:"+this.getCons()+", p:"+this.p;
    }
    
}
