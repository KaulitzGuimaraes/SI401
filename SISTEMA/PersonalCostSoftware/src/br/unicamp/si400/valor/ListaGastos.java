/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import java.time.LocalDate;
import java.time.Month;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class ListaGastos extends ListaValor  {

    private  TreeMap<Month, ArrayList<Gasto>> listaGastos;

    /**
     * Class constructor
     */
    public ListaGastos() {
        ArrayList<Gasto> j = new ArrayList();
        this.listaGastos = new TreeMap();
        this.listaGastos.put(Month.JANUARY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.FEBRUARY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.MARCH, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.APRIL, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.MAY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.JUNE, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.JULY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.AUGUST, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.SEPTEMBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.OCTOBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.NOVEMBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.DECEMBER, (ArrayList<Gasto>) j.clone());
        
    }
    /**
     * This method receives a String array and 
     *creates a new Gasto object, then this new object
     * is placed in the class Map.
     * @param data
     * @return boolean
     * @throws ExceptionDefault 
     */
    @Override
    public boolean create(String[] data) throws ExceptionDefault {

        try {//String local, String formaDePagamento, double numeroValor, LocalDate data, LocalTime hora

            Gasto gastoBuffer = new Gasto(data[0], data[1], data[3],Double.parseDouble(data[4]), LocalDate.parse(data[4].subSequence(0, data[4].length()-1)), LocalTime.parse(data[6].subSequence(0, data[6].length()-1)));
            return this.listaGastos.get(LocalDate.parse(data[4].subSequence(0, data[4].length()-1)).getMonth()).add(gastoBuffer);
            
          
        } catch (NullPointerException | NumberFormatException|DateTimeParseException   e) {
            throw new ExceptionDefault("Não foi adicionar os gastos");
        }
    }
    /**
     * This method retrieves the Array list that corresponds
     * to the key received.
     * @param data
     * @return ArrayList
     * @throws ExceptionDefault 
     */
    @Override
    public ArrayList retrieve(String data) throws ExceptionDefault {
        try {
            return this.listaGastos.get(data);
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Não foi recuperar os gastos");

        }

    }
    /**
     * This method is not supported. 
     * @param data
     * @return 
     */
    @Override
    public boolean update(String[] data) {
        throw new UnsupportedOperationException("You can't update a cost"); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * This method clear the Array list that corresponds
     * the key received.
     * @param data
     * @return boolean
     * @throws ExceptionDefault 
     */
    @Override
    public boolean delete(String data) throws ExceptionDefault {
        try {
            this.listaGastos.get(data).clear();
            return true;
        } catch (NullPointerException e) {

            throw new ExceptionDefault("Não foi deletar os gastos");

        }

    }
    /**
     * delete a specific object Gasto that is 
     * into the ArrayList at the specific key 
     * received.
     * @param data
     * @return
     * @throws ExceptionDefault 
     */
    public boolean delete(String data[]) throws ExceptionDefault {
        try {//String descricao, String local, String formaDePagamento, String horaDoGasto, String diaDoGasto, String mesDoGasto, String anoDoGasto, long numeroValor, String tipo
            Gasto gastoBuffer = new Gasto(data[0], data[1], data[3],Double.parseDouble(data[4]), LocalDate.parse(data[4].subSequence(0, data[5].length()-1)), LocalTime.parse(data[6].subSequence(0, data[5].length()-1)));
            
            return this.listaGastos.get(LocalDate.parse(data[4].subSequence(0, data[4].length()-1)).getMonth()).remove(gastoBuffer);
        } catch (NullPointerException | NumberFormatException | DateTimeParseException e) {
            throw new ExceptionDefault("Não foi deletar os gastos");
        }

    }
    
    

}
