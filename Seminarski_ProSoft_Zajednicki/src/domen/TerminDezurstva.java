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
public class TerminDezurstva implements Serializable,OpstiDomenskiObjekat{
    private int idTerminDezurstva;
    private LocalTime vremeOd;
    private LocalTime vremeDo;
    private LocalDate datum;

    public TerminDezurstva() {
    }

    public TerminDezurstva(int idTerminDezurstva, LocalTime vremeOd, LocalTime vremeDo, LocalDate datum) {
        this.idTerminDezurstva = idTerminDezurstva;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
        this.datum = datum;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }

    public int getIdTerminDezurstva() {
        return idTerminDezurstva;
    }

    public void setIdTerminDezurstva(int idTerminDezurstva) {
        this.idTerminDezurstva = idTerminDezurstva;
    }

    @Override
    public String vratiNazivTabele() {
        return "termin_dezurstva";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "vremeOd,vremeDo,datum";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+String.valueOf(getVremeOd())+"','"+String.valueOf(getVremeDo())+"','"+String.valueOf(getDatum())+"'";
    }

    @Override
    public String vratiprimarniKljuc() {
        return "termin_dezurstva.idTerminDezurstva="+getIdTerminDezurstva();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "vremeOd='"+String.valueOf(getVremeOd())+"',vremeDo='"+String.valueOf(getVremeDo())+"',datum='"+String.valueOf(getDatum())+"'";
    }
    
    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idTerminDezurstva=rs.getInt("termin_dezurstva.idTerminDezurstva");
            LocalTime vremeOd=LocalTime.parse(rs.getString("termin_dezurstva.vremeOd"));
            LocalTime vremeDo=LocalTime.parse(rs.getString("termin_dezurstva.vremeDo"));
            LocalDate datum=LocalDate.parse(rs.getString("termin_dezurstva.datum"));
             
             TerminDezurstva t=new TerminDezurstva(idTerminDezurstva, vremeOd, vremeDo, datum);
             lista.add(t);
        }
       
        return lista;
    }
    
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
    
}
