/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

import java.time.*;

/**
 * Classe cliente
 * @see Palestra
 * @author LucaGiorgi
 */
public class Cliente
{
    /**
     * Attributi:
     * @private codiceIdentificativo--> viene asseganto in automatico ai clienti, String
     * @private anno mese giorno--> indicano la data di iscrizione di un cliente, Int
     * @private nome--> nome del cliente, String
     * @private cognome-->cognome del cliente, String
     * @private corso--> corso del cliente, String
     * @private dataIscrizione--> data dell'iscrizione del cliente, LocalDate
     */
    private int codiceIdentificativo;
    private int anno,mese,giorno;
    private String nome;
    private String cognome;
    private String corso;
    private LocalDate dataIscrizione;
    /**
     * costruttore, da un valore agli attributi
     * param codiceIdentificativo.
     * param nome.
     * param cognome.
     * param corso.
     * param giorno.
     * param mese.
     * param anno.
     */
    public Cliente(int codiceIdentificativo, String nome, String cognome, String corso, int giorno, int mese, int anno) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
        this.dataIscrizione = LocalDate.of(anno,mese,giorno);
    }
    /**
     * costruttore di copia: da un valore agli attributi tramite un Cliente c1
     * param c1. 
     */
    public Cliente (Cliente c1)
    {
        this.codiceIdentificativo = c1.getCodiceIdentificativo();
        this.nome = c1.getNome();
        this.cognome = c1.getCognome();
        this.corso = c1.getCorso();
        this.dataIscrizione = LocalDate.from(c1.getDataIscrizione());
    }
    /**
     * costruttore di default
     * se l'utente non inserisce nessun dato, a cliente verrano asseganti dei parametri 
     * di default
     */
    public Cliente ()
    {
        this.codiceIdentificativo = 0;
        this.nome = "";
        this.cognome = "";
        this.corso = "";
    }
    /**
     * getCodiceIdentificativo, returna il codiceIdentificativo
     * return codiceIdentificativo
     */
    public int getCodiceIdentificativo()
    {
        return codiceIdentificativo;
    }
    /**
     * getNome, restituisce il valore del nome
     * return nome
     */
    public String getNome() 
    {
        return nome;
    }
    /**
     * getCognome, restituisce il valore del cognome
     * return cognome
     */
    public String getCognome() 
    {
        return cognome;
    }
    /**
     * getAnno, restituisce il valore di anno
     * return anno
     */
    public int getAnno() 
    {
        return anno;
    }
    /**
     * getMese, restituisce il valore del mese
     * return mese
     */
    public int getMese() 
    {
        return mese;
    }
    /**
     * getGiorno, restituisce il valore del giorno
     * return girono
     */
    public int getGiorno() 
    {
        return giorno;
    }
    /**
     * getCorso, restituisce il valore del corso
     * return nome
     */
    public String getCorso()
    {
        return corso;
    }
    /**
     * getDataIscrizione, restituisce il valore della dat del'iscrizione del cliente
     * return getDataIscrizione
     */
    public LocalDate getDataIscrizione() 
    {
        return LocalDate.from(dataIscrizione);
    }
    /**
     * setCodiceIdentificativo
     * param codiceIdentificativo 
     */
    public void setCodiceIdentificativo(int codiceIdentificativo) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
    }
    /**
     * setNome, setta il valore di nome
     * param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * setCognome, setta il valore di cognome
     * param cognome 
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }
    /**
     * setAnno, setta il valore di anno
     * param anno 
     */
    public void setAnno(int anno) 
    {
        this.anno = anno;
    }
    /**
     * setMese, setta il valore di mese
     * param mese 
     */
    public void setMese(int mese) 
    {
        this.mese = mese;
    }
    /**
     * setGiorno, setta il valore di giorno
     * param giorno 
     */
    public void setGiorno(int giorno)
    {
        this.giorno = giorno;
    }
    /**
     * setCorso, setta il valore di corso
     * param corso 
     */
    public void setCorso(String corso) 
    {
        this.corso = corso;
    }
    /**
     * setDataIscrizione, setta il valore della data di iscrizione
     * param dataIscrizione 
     */
    public void setDataIscrizione(LocalDate dataIscrizione)
    {
        this.dataIscrizione = dataIscrizione;
    }
    /**
     *  toString, restituisce una stringa contenente tutti i dati un cliente
     * return s, Stringa
     */
    public String toString()
    {
        String s= "";
        s= "Codice identificativo: "+getCodiceIdentificativo()+";\n"+"Nome: "+getNome()+";\n"+"Cognome: "+getCognome()+";\n"+"Corso: "+getCorso()+";\n"+"Data Iscrizione: "+getDataIscrizione()+";\n";
        return s;
    }
    public String toStringCSV()
    {
        String s="";
        s=s+this.getCodiceIdentificativo()+";"+this.getNome()+";"+this.getCognome()+";"+this.getCorso()+";";
        return s;
    }
    
}
