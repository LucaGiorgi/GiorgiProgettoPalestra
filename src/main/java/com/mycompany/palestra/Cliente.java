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
    private int anno,mese,giorno;
    private String nome;
    private String cognome;
    private String corso;
    private LocalDate dataIscrizione;

    public Cliente(int codiceIdentificativo, String nome, String cognome, String corso, int giorno, int mese, int anno) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
        this.nome = nome;
        this.cognome = cognome;
        this.corso = corso;
        this.dataIscrizione = LocalDate.of(anno,mese,giorno);
    }
    
    public Cliente (Cliente c1)
    {
        this.codiceIdentificativo = getCodiceIdentificativo();
        this.nome = getNome();
        this.cognome = getCognome();
        this.corso = getCorso();
        this.dataIscrizione = LocalDate.from(c1.getDataIscrizione());
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

    public int getAnno() 
    {
        return anno;
    }

    public int getMese() 
    {
        return mese;
    }

    public int getGiorno() 
    {
        return giorno;
    }
    
    public String getCorso()
    {
        return corso;
    }

    public LocalDate getDataIscrizione() 
    {
        return LocalDate.from(dataIscrizione);
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

    public void setAnno(int anno) 
    {
        this.anno = anno;
    }

    public void setMese(int mese) 
    {
        this.mese = mese;
    }

    public void setGiorno(int giorno)
    {
        this.giorno = giorno;
    }
    
    public void setCorso(String corso) 
    {
        this.corso = corso;
    }

    public void setDataIscrizione(LocalDate dataIscrizione)
    {
        this.dataIscrizione = dataIscrizione;
    }
    
    public String toString()
    {
        String s= "";
        s= "Codice identificativo: "+getCodiceIdentificativo()+";\n"+"Nome: "+getNome()+";\n"+"Cognome: "+getCognome()+";\n"+"Corso: "+getCorso()+";\n"+"Data Iscrizione: "+getDataIscrizione()+";\n";
        return s;
    }
    
}
