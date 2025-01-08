/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author janja
 */
public class Zaposleni implements Serializable,OpstiDomenskiObjekat{
    private int idZaposleni;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Zaposleni() {
    }

    public Zaposleni(String korisnickoIme, String sifra) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    

    public Zaposleni(int idZaposleni, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idZaposleni = idZaposleni;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    

    public int getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(int idZaposleni) {
        this.idZaposleni = idZaposleni;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,korisnickoIme,sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+getIme()+"','"+getPrezime()+"','"+getKorisnickoIme()+"','"+getSifra()+"'";
    }

    @Override
    public String vratiprimarniKljuc() {
        return "zaposleni.idZaposleni="+getIdZaposleni();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+getIme()+"',prezime='"+getPrezime()+"',korisnickoIme='"+getKorisnickoIme()+"',sifra='"+getSifra()+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idZaposleni=rs.getInt("zaposleni.idZaposleni");
            String ime=rs.getString("zaposleni.ime");
            String prezime=rs.getString("zaposleni.prezime");
            String korisnickoIme=rs.getString("zaposleni.korisnickoIme");
            String sifra=rs.getString("zaposleni.sifra");
            
            Zaposleni z=new Zaposleni(idZaposleni, ime, prezime,korisnickoIme,sifra);
            lista.add(z);
        }
       
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "idZaposleni=" + idZaposleni + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", sifra=" + sifra + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }
    
    
}
