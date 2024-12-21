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
public class SkiOprema implements Serializable,OpstiDomenskiObjekat{
    private int idSkiOprema;
    private String naziv;
    private String brend;
    private int cena;

    public SkiOprema() {
    }

    public SkiOprema(int idSkiOprema, String naziv, String brend, int cena) {
        this.idSkiOprema = idSkiOprema;
        this.naziv = naziv;
        this.brend = brend;
        this.cena = cena;
    }

    public int getIdSkiOprema() {
        return idSkiOprema;
    }

    public void setIdSkiOprema(int idSkiOprema) {
        this.idSkiOprema = idSkiOprema;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Override
    public String vratiNazivTabele() {
        return "ski_oprema";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,brend,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
       return "'"+getNaziv()+"','"+getBrend()+"',"+getCena();
    }

    @Override
    public String vratiprimarniKljuc() {
        return "ski_oprema.idSkiOprema="+getIdSkiOprema();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+getNaziv()+"',brend='"+getBrend()+"',cena="+getCena();
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idSkiOprema=rs.getInt("ski_oprema.idSkiOprema");
            String naziv=rs.getString("ski_oprema.naziv");
            String brend=rs.getString("ski_oprema.brend");
            int cena=rs.getInt("ski_oprema.cena");
            
            SkiOprema s=new SkiOprema(idSkiOprema, naziv, brend, cena);
            lista.add(s);
        }
       
        return lista;
    }
    
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
    
    
    
    
}
