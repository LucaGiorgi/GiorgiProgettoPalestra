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
        String[] vociMenu= new String[10];
        Cliente c1 = new Cliente();
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
        Menu menu= new Menu(vociMenu);
        
         switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione terminerà");
                    break;
                }
                case 1:
                {
                    cliente = new Cliente();
                    System.out.println("Codice identificativo --> ");
                    cliente.setCodiceIdentificativo(tastiera.nextInt());
                    System.out.println("Cognome --> ");
                    cliente.setCognome(tastiera.nextLine());
                    System.out.println("Nome --> ");
                    cliente.setNome(tastiera.nextLine());
                    /*
                    System.out.println("Data --> ");
                    cliente.setDataIscrizione(tastiera.);
                    */
                    System.out.println("Corso --> ");
                    cliente.setCorso(tastiera.nextLine());
                }
        
    }
         
    }
}
