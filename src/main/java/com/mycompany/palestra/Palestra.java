/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

/**
 *
 * @author LucaGiorgi
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
    public Cliente[] getClienti()
    {
        return clienti;
    }

    public static int getN_MAX_CLIENTI() 
    {
        return N_MAX_CLIENTI;
    }
    
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
    
    public Cliente getCliente(int posizione)
    {
        if(posizione<0 || posizione>=getN_MAX_CLIENTI())
            return null;
        if (clienti[posizione]==null)
            return null;
        return clienti[posizione];
    }
    
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
    public int rimuoviCliente(int codiceIdentificativo)
    {
        for(int i=0;i<getNumClienti();i++)
        {
            if(codiceIdentificativo== clienti[i].getCodiceIdentificativo())
                clienti[i]=null;
            else
                return 0;
        }
                        return -1;
    }
        
    public  String visualizzaClienti(Cliente clienti)
    {
        String s="";
        if(this.getNumClienti() == 0)
        {
            s="Nessun cliente presete";
        }
        for(int i=0;i<this.getNumClienti();i++)
        {
            s=clienti.toString();
        }
        return s;
    }
    
    public  int visualizzaCliente(String Cognome, String Nome)
    {
        String s="";
        for(int i=0;i<getNumClienti();i++)
        {
            if(Cognome==clienti[i].getCognome() && Nome==clienti[i].getNome())
                return 0; 
        }
        return -1;
    }

    
}
