/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
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
public class ListaGastos extends ListaValor implements Crud {

    private TreeMap<String, ArrayList<Gasto>> listaGastos;

    /**
     * Class constructor
     */
    public ListaGastos() {
        ArrayList<Gasto> j = new ArrayList();
        this.listaGastos = new TreeMap();
        this.listaGastos.put("janeiro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("fevereiro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("marco", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("abril", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("maio", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("junho", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("julho", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("agosto", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("setembro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("outubro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("novembro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("dezembro", (ArrayList<Gasto>) j.clone());
        
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

        try {//String descricao, String local, String formaDePagamento, String horaDoGasto, String diaDoGasto, String mesDoGasto, String anoDoGasto, long numeroValor, String tipo

            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4], data[5], data[6],
                    data[7], data[8]);
            this.listaGastos.get(data[6]).add(gastoBuffer);
            return true;
        } catch (NullPointerException | NumberFormatException e) {
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
            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4], data[5], data[6],
                    data[7], data[8]);
            return this.listaGastos.get(data[6]).remove(gastoBuffer);
        } catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Não foi deletar os gastos");
        }

    }
    
    

}
