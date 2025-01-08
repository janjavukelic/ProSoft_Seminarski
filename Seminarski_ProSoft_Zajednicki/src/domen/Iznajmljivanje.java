/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;

import java.util.List;

/**
 *
 * @author janja
 */
public class Iznajmljivanje implements Serializable,OpstiDomenskiObjekat{
    private int idIznajmljivanje;
    private LocalDate datumUzimanja;
    private LocalDate datumVracanja;
    private int cena;
    private Zaposleni zaposleni;
    private Skijas skijas;
    private List<StavkaIznajmljivanja> stavke;

    public Iznajmljivanje() {
        
    }

    public Iznajmljivanje(int idIznajmljivanje, LocalDate datumUzimanja, LocalDate datumVracanja, int cena, Zaposleni zaposleni, Skijas skijas, List<StavkaIznajmljivanja> stavke) {
        this.idIznajmljivanje = idIznajmljivanje;
        this.datumUzimanja = datumUzimanja;
        this.datumVracanja = datumVracanja;
        this.cena = cena;
        this.zaposleni = zaposleni;
        this.skijas = skijas;
        this.stavke = stavke;
    }

    public List<StavkaIznajmljivanja> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
    }

    public int getIdIznajmljivanje() {
        return idIznajmljivanje;
    }

    public void setIdIznajmljivanje(int idIznajmljivanje) {
        this.idIznajmljivanje = idIznajmljivanje;
    }

    public LocalDate getDatumUzimanja() {
        return datumUzimanja;
    }

    public void setDatumUzimanja(LocalDate datumUzimanja) {
        this.datumUzimanja = datumUzimanja;
    }

    public LocalDate getDatumVracanja() {
        return datumVracanja;
    }

    public void setDatumVracanja(LocalDate datumVracanja) {
        this.datumVracanja = datumVracanja;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Skijas getSkijas() {
        return skijas;
    }

    public void setSkijas(Skijas skijas) {
        this.skijas = skijas;
    }

    @Override
    public String vratiNazivTabele() {
        return "iznajmljivanje";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumUzimanja,datumVracanja,cena,idZaposleni,idSkijas";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+String.valueOf(getDatumUzimanja())+"','"+String.valueOf(getDatumVracanja())+"',"+getCena()+","
                +getZaposleni().getIdZaposleni()+","+getSkijas().getIdSkijas();
    }

    @Override
    public String vratiprimarniKljuc() {
        return "iznajmljivanje.idIznajmljivanje="+getIdIznajmljivanje();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumUzimanja='"+String.valueOf(getDatumUzimanja())+"',datumVracanja='"+
                String.valueOf(getDatumVracanja())+"',cena="+getCena()+",idZaposleni="+getZaposleni().getIdZaposleni()
                +",idSkijas="+getSkijas().getIdSkijas();
    }
   
    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiSK() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
