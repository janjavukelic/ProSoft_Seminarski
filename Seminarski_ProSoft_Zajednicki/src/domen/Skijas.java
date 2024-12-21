/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janja
 */
public class Skijas implements Serializable,OpstiDomenskiObjekat{
    private int idSkijas;
    private String ime;
    private String prezime;
    private String brTelefona;
    private NivoSkijanja nivoSkijanja;

    public Skijas() {
    }

    public Skijas(int idSkijas, String ime, String prezime, String brTelefona, NivoSkijanja nivoSkijanja) {
        this.idSkijas = idSkijas;
        this.ime = ime;
        this.prezime = prezime;
        this.brTelefona = brTelefona;
        this.nivoSkijanja = nivoSkijanja;
    }

    public int getIdSkijas() {
        return idSkijas;
    }

    public void setIdSkijas(int idSkijas) {
        this.idSkijas = idSkijas;
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

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public NivoSkijanja getNivoSkijanja() {
        return nivoSkijanja;
    }

    public void setNivoSkijanja(NivoSkijanja nivoSkijanja) {
        this.nivoSkijanja = nivoSkijanja;
    }

    @Override
    public String vratiNazivTabele() {
        return "skijas";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,brTelefona,idNivoSkijanja";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+getIme()+"','"+getPrezime()+"','"+getBrTelefona()+"',"+getNivoSkijanja();
    }

    @Override
    public String vratiprimarniKljuc() {
        return "skijas.idSkijas="+getIdSkijas();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+getIme()+"',prezime='"+getPrezime()+"',brtelefona='"+getBrTelefona()
                +"',idNivoSkijanja="+getNivoSkijanja().getIdNivoSkijanja();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idSkijas=rs.getInt("skijas.idSkijas");
            String ime=rs.getString("skijas.ime");
            String prezime=rs.getString("skijas.prezime");
            String brTelefona=rs.getString("skijas.brTelefona");
            NivoSkijanja nivoSkijanja=new NivoSkijanja(rs.getInt("nivo_skijanja.idNivoSkijanja"), 
                    rs.getInt("nivo_skijanja.nivo"), rs.getString("nivo_skijanja.opis"));
            
            Skijas s=new Skijas(idSkijas, ime, prezime, brTelefona, nivoSkijanja);
            lista.add(s);
        }
       
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
