/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import br.unicamp.si400.login.Login;
import br.unicamp.si400.valor.*;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Kaulitz
 */
public class Usuario implements Serializable {

    private String nome;

    private String email;

    private Login login;

    private ListaGastos listagastos;

    /**
     * Get the value of gastos
     *
     * @return the value of gastos
     */
    public ListaGastos getGastos() {
        return this.listagastos;
    }

    /**
     * Get the object Login
     *
     * @return the login user
     */
    public Login getLogin() {
        return login;
    }

    /**
     * Class constructor
     *
     * @param nome
     * @param email
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.listagastos = new ListaGastos();
        this.login = new Login();
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set username
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Set email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Return the user email
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getEmail();
    }

    /**
     * Verify if the objects has the same email
     *
     * @param anObject
     * @return
     */
    @Override
    public boolean equals(Object anObject) {


        /* Check if o is an instance of Usuario or not
          "null instanceof [type]" also returns false */
        if (!(anObject instanceof Usuario)) {
            return false;
        } else {
            // typecast o to Complex so thsat we can compare data members 
            Usuario compare = (Usuario) anObject;

            // Compare the data members and return accordingly 
            return this.toString().equals(compare.toString());
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.email);
        return hash;
    }

}
