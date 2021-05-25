/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

import java.util.Scanner;
import eccezioni.*;
import file.fileExeption;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LucaGiorgi
 */
public class Main
{
    public static void main(String[] args)
    {
        int sceltaUtente =-1;
        int CodiceIdentificativo=0;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[7];
        Palestra p1 = new Palestra();
        String nomeFileCSV="Palestra.txt";
        String nomeFileBinario="Palestra.bin";
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "aggiungi cliente";
        vociMenu[2] = "Rimuovi cliente";
        vociMenu[3] = "Visualizza tutti i clienti";
        vociMenu[4] = "Visualizza cliente";
        vociMenu[5] = "Visualizza clienti di un determinato corso";
        vociMenu[6] = "Esporta i dati in formato CSV";
        Menu menu= new Menu(vociMenu);
        Cliente c1;
        try 
        {
            
            p1=p1.caricaClienti(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        catch (fileExeption ex) 
        {
            System.out.println("Errore di lettura dal file. I dati non sono stati caricati");
        }
        
        
    do{
        sceltaUtente=menu.sceltaMenu();
         switch(sceltaUtente)
         {
            
                case 1:
                {
                    String nome,cognome,corso;
                    int giorno,mese,anno;
                    
                    System.out.println("INSERIMENTO NUOVO CLIENTE\n");
                    System.out.println("Cognome:");
                    cognome=tastiera.nextLine();
                    System.out.println("Nome:");
                    nome=tastiera.nextLine();
                    System.out.println("Corso:");
                    corso=tastiera.nextLine();
                    System.out.println("DATA ISCRIZIONE\n");
                    System.out.println("Giorno:");
                    giorno=tastiera.nextInt();
                    System.out.println("Mese:");
                    mese=tastiera.nextInt();
                    System.out.println("Anno:");
                    anno=tastiera.nextInt();
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    c1=new Cliente(CodiceIdentificativo,nome,cognome,corso,giorno,mese,anno);
                    p1.setCliente(c1, CodiceIdentificativo);
                    CodiceIdentificativo++;
                    break;
                }
                case 2:
                {
                    int codiceDaEliminare;
                    System.out.println("Inserire il codice indentificativo:");
                    codiceDaEliminare=tastiera.nextInt();
                    if(p1.rimuoviCliente(codiceDaEliminare)==0)
                        System.out.println("cliente rimosso correttamente");
                    if(p1.rimuoviCliente(codiceDaEliminare)==-1)
                        System.out.println("cliente non trovato");
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    System.out.println(p1.visualizzaClienti());
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 4:
                {
                    String cognome, nome;
                    System.out.println("cognome:");
                    cognome=tastiera.nextLine();
                    System.out.println("nome:");
                    nome=tastiera.nextLine();
                    System.out.println(p1.visualizzaCliente(cognome, nome));
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 5:
                {
                    String corso;
                    System.out.println("corso da visualizzare:");
                    corso=tastiera.nextLine();
                    System.out.println(p1.visualizzaCorsoCliente(corso));                  
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 6:
                {
                    
                    System.out.println("esportazione avvenuta correttamente!");
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 0:
                {
                    System.out.println("L'applicazione terminerà");
                    break;
                }
            }
         }while(sceltaUtente!=0);      
    
    }
}
