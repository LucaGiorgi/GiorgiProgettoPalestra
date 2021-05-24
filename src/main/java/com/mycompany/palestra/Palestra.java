/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

import com.mycompany._progettolibreria.Scaffale;
import eccezioni.*;
import file.fileExeption;
import file.TextFile;
import java.io.*;
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

    public static void setN_MAX_CLIENTI(int N_MAX_CLIENTI)
    {
        Palestra.N_MAX_CLIENTI = N_MAX_CLIENTI;
    }
    
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
    public void aggiornaPosizioneClienti(int posizione)
    {
        for (int i=posizione;i<getNumClienti();i++)
        {
            clienti[posizione]=clienti[posizione+1];
        }
    }        
            
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
    public void esportaClientiCsv(String nomeFile) throws IOException, EccezionePosizioneNonValida, fileExeption
    {
      TextFile f1= new TextFile(nomeFile, 'W');
      String rigaDaScrivere="";
      Cliente c;
      for(int i=0;i<getNumClienti();i++)
      {
              if(getCliente(i)!=null)
              {
                  c=getCliente(i);
                  rigaDaScrivere=i+"; "+c.getNome()+"; "+c.getCognome()+"; "+c.getAnno()+"; "+c.getMese()+"; "+c.getGiorno()+"; ";
                  
                  try 
                  {
                      f1.toFile(rigaDaScrivere);
                  } 
                  catch (fileExeption ex) 
                  {
                      f1.close();
                      throw new fileExeption("Errore in scrittura!");
                  }
              }
          
      }
      f1.close();      
   }
      public  Cliente caricaClienti(String nomeFile) throws FileNotFoundException, IOException, fileExeption 
  {
      FileInputStream f1=new FileInputStream(nomeFile);
      ObjectInputStream inputStream=new ObjectInputStream(f1);
      Scaffale s;
       try 
       {
           s=(Cliente)inputStream.readObject();
           inputStream.close();
            return s;
       } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new fileExeption("Errore nella lettura del file");
       }
  }
}
