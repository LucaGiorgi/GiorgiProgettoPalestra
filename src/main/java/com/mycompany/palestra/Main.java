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
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[7];
        Palestra p1 = new Palestra();
        Cliente cliente;
        String nomeFileCSV="Palestra.txt";
        String nomeFileBinario="Palestra.bin";
        
        vociMenu[0] = "aggiungi cliente";
        vociMenu[1] = "Rimuovi cliente";
        vociMenu[2] = "Visualizza tutti i clienti";
        vociMenu[3] = "Visualizza cliente";
        vociMenu[4] = "Visualizza clienti di un determinato corso";
        vociMenu[5] = "Esporta i dati in formato CSV";
        vociMenu[6] = "Esci";
        cliente = new Cliente();
        Menu menu= new Menu(vociMenu);
        sceltaUtente=menu.sceltaMenu();
        
    do{
         switch(sceltaUtente)
         {
            
                case 0:
                {
                    System.out.println("Codice identificativo --> ");
                    cliente.setCodiceIdentificativo(tastiera.nextInt());
                    tastiera.nextLine();
                    System.out.println("Cognome --> ");
                    cliente.setCognome(tastiera.nextLine());
                    System.out.println("Nome --> ");
                    /*
                    cliente.setNome(tastiera.nextLine());
                    System.out.println("iscrizione avvenuta:");
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    System.out.println("Corso --> ");
                    */
                    cliente.setCorso(tastiera.nextLine());
                    p1.setCliente(cliente, sceltaUtente);
                    System.out.println("inserimento avvenuto correttamente");
                    break;
                }
                case 1:
                {
                    System.out.println("Inserire il codice indentificativo:");
                    cliente.setCodiceIdentificativo(tastiera.nextInt());
                    if(p1.rimuoviCliente(sceltaUtente)==0)
                        System.out.println("cliente rimosso correttamente");
                    if(p1.rimuoviCliente(sceltaUtente)==-1)
                        System.out.println("cliente non trovato");
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println(p1.visualizzaClienti(cliente));
                    System.out.println("premi un pulsante per continuare.!");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    
                }
                case 4:
                {
                    
                }
                case 5:
                {
                    
                }
                case 6:
                {
                    System.out.println("L'applicazione terminerà");
                    break;
                }
            }
         }while(sceltaUtente!=0);      
    
    }
}
