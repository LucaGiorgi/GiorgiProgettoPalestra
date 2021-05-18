/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.palestra;

import java.time.*;

/**
 *
 * @author LucaGiorgi
 */
public class Cliente
{
    private int codiceIdentificativo;
    private String nome;
    private String cognome;
    private String corso;
    private LocalDateTime dataIscrizione;

    public Cliente(int codiceIdentificativo, String nome, String cognome, String corso, LocalDateTime dataIscrizione) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
        this.dataIscrizione = dataIscrizione;
    }
    
    public Cliente (Cliente c1)
    {
        this.codiceIdentificativo = getCodiceIdentificativo();
        this.nome = getNome();
        this.cognome = getCognome();
        this.corso = getCorso();
        this.dataIscrizione = getDataIscrizione();
    }
    public Cliente ()
    {
        this.codiceIdentificativo = 0;
        this.nome = "";
        this.cognome = "";
        this.corso = "";
    }
    public int getCodiceIdentificativo()
    {
        return codiceIdentificativo;
    }

    public String getNome() 
    {
        return nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public String getCorso()
    {
        return corso;
    }

    public LocalDateTime getDataIscrizione() 
    {
        return dataIscrizione;
    }
    
    public void setCodiceIdentificativo(int codiceIdentificativo) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public void setCorso(String corso) 
    {
        this.corso = corso;
    }

    public void setDataIscrizione(LocalDateTime dataIscrizione)
    {
        this.dataIscrizione = dataIscrizione;
    }
    
    public String toString()
    {
        String s= "";
        s= "Codice identificativo: "+getCodiceIdentificativo()+";"+"Nome: "+getNome()+";"+"Cognome: "+getCognome()+";"+"Corso: "+getCorso()+";"+"Data Iscrizione. "+getDataIscrizione()+";";
        return s;
    }
    
}
