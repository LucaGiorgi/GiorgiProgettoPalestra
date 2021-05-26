/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;
import eccezioni.*;
import file.fileExeption;
import file.TextFile;
import java.io.*;

/**
 * 
 * @author LucaGiorgi
 * Classe Palestra, array di clienti
 */
public class Palestra 
{
    private Cliente[] clienti;
    private static int N_MAX_CLIENTI=1500;
    //costruttore
    public Palestra()
     {
       clienti = new Cliente[N_MAX_CLIENTI];
     }
    /**
    *costruttore
    * param elencoClienti, array di clienti
    * 
    **/
    public Palestra(Cliente elencoClienti[])
    {
        clienti=new Cliente[N_MAX_CLIENTI];
        int numeroClienti=0;
        //se elenco libri non contiene libri
        if(elencoClienti.length==0)
            return;
        if(elencoClienti.length>getN_MAX_CLIENTI())
            numeroClienti=getN_MAX_CLIENTI();
        else
            numeroClienti=elencoClienti.length;
        
        for(int i=0;i<numeroClienti;i++)
        {
            if(elencoClienti[i]!=null)
            {
                clienti[i]=new Cliente(elencoClienti[i]);
            }
        }
    }
    /**
     * getClienti, restituisce il valore di clienti
     * return clienti
     * 
     **/
    public Cliente[] getClienti()
    {
        return clienti;
    }
    /**
     * getN_MAX_CLIENTI, restituisce il valore del numero massimo di clienti
     * registrabili nell'array
     * return getN_MAX_CLIENTI
     * 
     **/
    public static int getN_MAX_CLIENTI() 
    {
        return N_MAX_CLIENTI;
    }
    /**
     * getNumClienti, restituisce un contatore c, si incrementi ogni qualvolta si aggiunge un cliente in palestra
     * return c
     * 
     **/
    public int getNumClienti()
    {
        int c=0;
        for(int i=0; i<getN_MAX_CLIENTI();i++)
        {
            if (clienti[i]!=null)
                c++;
        }
        return c;
    }
    /**
     * getCliente
     * param posizione, posizione cliente
     * return clienti[], se va tutto ok
     * return null 
     * 
     **/
    public Cliente getCliente(int posizione)
    {
        if(posizione<0 || posizione>=getN_MAX_CLIENTI())
            return null;
        if (clienti[posizione]==null)
            return null;
        return clienti[posizione];
    }
    /**
     * setCliente, inserimento nuovo cliente
     * param Cliente 
     * param posizione
     * return -1 se la posizione non è valida
     * return -2 se posizone occupata 
     * return 0, ok cliente inserito
     **/
    public int setCliente (Cliente cliente, int posizione)
    {
        if (posizione<0 || posizione>getNumClienti())
            return -1;  //pos non valida*/
        
        try
        {
            if(clienti[posizione]!=null)
            return -2;  //pos occupata
        
        //se posizione libera
        clienti[posizione]=new Cliente(cliente);
        
        return posizione;
        }
        catch(ArrayIndexOutOfBoundsException posizioneNonValida)
        {
                return -1;     
        }
        
    }
    /**
     * setN_MAX_CLIENTI
     * non restituisce niente
     * 
     * param N_MAX_CLIENTI 
     */
    public static void setN_MAX_CLIENTI(int N_MAX_CLIENTI)
    {
        Palestra.N_MAX_CLIENTI = N_MAX_CLIENTI;
    }
    /**
     * rimumoviCliente, rimuove un cliente in base al codiceIdentificativo
     * param codiceDaEliminare
     * return 0, se cliente rimosso correttamente
     * return -1, se cliente non rimosso correttamente
     */
    public int rimuoviCliente(int codiceDaEliminare)
    {
        for(int i=0;i<getNumClienti();i++)
        {
            if(clienti[i]!=null)
            {
                if(clienti[i].getCodiceIdentificativo()==codiceDaEliminare)
                {
                    clienti[i]=null;
                    aggiornaPosizioneClienti(i);
                    return 0;
                }
            }
        }
        return -1;
    }
    /**
     * aggiornaPosizioneCliente, aggiorna la posizione di un cliente
     * param posizione 
     */
    public void aggiornaPosizioneClienti(int posizione)
    {
        for (int i=posizione;i<getNumClienti();i++)
        {
            clienti[posizione]=clienti[posizione+1];
        }
    }        
    /**
     * visualizzaClienti: visualizza tutti i clienti dell'array
     *
     * return, s (stringa) 
     */        
    public  String visualizzaClienti()
    {

        String s="";
        if(getNumClienti() == 0)
        {
            s="Nessun cliente presente";
        }
        for(int i=0;i<getNumClienti();i++)
        {
            
            s+="\n"+clienti[i].toString();
        }           
        return s;
    }
    /**
     * visualizzaCliente, visualizza un cliente con un determinato nome e cognome
     * param cognome
     * param nome
     * return s (stringa)
     */
    public  String visualizzaCliente(String cognome, String nome)
    {
        String s="";
        for(int i=0;i<getNumClienti();i++)
        {
            if(clienti[i].getCognome().compareToIgnoreCase(cognome)==0 && clienti[i].getNome().compareToIgnoreCase(nome)==0)
            {
                return clienti[i].toString(); 
            }
            else
            {
                s="Cliente non trovato!";
            }
        }
        return s;
    }
    /**
     * visualizzaCorsoCliente, visualizza i clienti iscritti ad un determinato coros
     * param corso
     *
     * return s (stringa)
     */
    public String visualizzaCorsoCliente(String corso)
    {
        String s="";
        for(int i=0;i<getNumClienti();i++)
        {
            if(clienti[i].getCorso().compareToIgnoreCase(corso)==0)
            {
                s+=clienti[i].toString(); 
            }
            else
            {
                s="nessun cliente con quel corso";
            }
        }
        return s;
    }
    //salva dati csv
}
