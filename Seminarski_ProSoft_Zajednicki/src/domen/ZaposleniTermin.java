/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janja
 */
public class ZaposleniTermin implements Serializable,OpstiDomenskiObjekat{
    private Zaposleni zaposleni;
    private TerminDezurstva termin;

    public ZaposleniTermin() {
    }

    public ZaposleniTermin(Zaposleni zaposleni, TerminDezurstva termin) {
        this.zaposleni = zaposleni;
        this.termin = termin;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public TerminDezurstva getTermin() {
        return termin;
    }

    public void setTermin(TerminDezurstva termin) {
        this.termin = termin;
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni_termin";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idZaposleni,idTerminDezurstva";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return getZaposleni().getIdZaposleni()+","+getTermin().getIdTerminDezurstva();
    }

    @Override
    public String vratiprimarniKljuc() {
        return "zaposleni_termin.idZaposleni="+getZaposleni().getIdZaposleni()+" and zaposleni_termin.idTerminDezurstva="
                +getTermin().getIdTerminDezurstva();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idZaposleni="+getZaposleni().getIdZaposleni()+",idTerminDezurstva="+getTermin().getIdTerminDezurstva();
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
            
            int idTerminDezurstva=rs.getInt("termin_dezurstva.idTerminDezurstva");
            LocalTime vremeOd=LocalTime.parse(rs.getString("termin_dezurstva.vremeOd"));
            LocalTime vremeDo=LocalTime.parse(rs.getString("termin_dezurstva.vremeDo"));
            LocalDate datum=LocalDate.parse(rs.getString("termin_dezurstva.datum"));
             
            TerminDezurstva t=new TerminDezurstva(idTerminDezurstva, vremeOd, vremeDo, datum);
            Zaposleni z=new Zaposleni(idZaposleni, ime, prezime,korisnickoIme,sifra);
            
            ZaposleniTermin zt=new ZaposleniTermin(z, t);
            lista.add(zt);
        }
       
        return lista;
    }
    
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
    
    
}
