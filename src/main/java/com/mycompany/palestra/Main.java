/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

import java.util.Scanner;

/**
 *
 * @author LucaGiorgi
 */
public class Main
{
    public static void main(String[] args)
    {
        int sceltaUtente =-1;
        int CodiceIdentificativo=1;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[7];
        Palestra p1 = new Palestra();
        String nomeFileCSV="Palestra.txt";
        String nomeFileBinario="Palestra.bin";
        
        vociMenu[0] = "aggiungi cliente";
        vociMenu[1] = "Rimuovi cliente";
        vociMenu[2] = "Visualizza tutti i clienti";
        vociMenu[3] = "Visualizza cliente";
        vociMenu[4] = "Visualizza clienti di un determinato corso";
        vociMenu[5] = "Esporta i dati in formato CSV";
        vociMenu[6] = "Esci";
        Menu menu= new Menu(vociMenu);
        Cliente c1;
        
    do{
        sceltaUtente=menu.sceltaMenu();
         switch(sceltaUtente)
         {
            
                case 0:
                {
                    String nome,cognome,corso;
                    int giorno,mese,anno;
                    
                    System.out.println("INSERIMENTO NUOVO CLIENTE");
                    tastiera.nextLine();
                    System.out.println("Nome:");
                    nome=tastiera.nextLine();
                    System.out.println("Cognome:");
                    cognome=tastiera.nextLine();
                    System.out.println("Corso:");
                    corso=tastiera.nextLine();
                    System.out.println("DATA ISCRIZIONE");
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
                case 1:
                {
                    int codiceDaEliminare;
                    System.out.println("Inserire il codice indentificativo:");
                    codiceDaEliminare=tastiera.nextInt();
                    if(p1.rimuoviCliente(codiceDaEliminare)==0)
                        System.out.println("cliente rimosso correttamente");
                    if(p1.rimuoviCliente(sceltaUtente)==-1)
                        System.out.println("cliente non trovato");
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println(p1.visualizzaClienti());
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 4:
                {
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 5:
                {
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 6:
                {
                    System.out.println("L'applicazione terminerà");
                    break;
                }
            }
         }while(sceltaUtente!=6);      
    
    }
}
