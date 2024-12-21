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
public class StavkaIznajmljivanja implements Serializable,OpstiDomenskiObjekat{
    private Iznajmljivanje iznajmljivanje;
    private int rb;
    private SkiOprema skiOprema;

    public StavkaIznajmljivanja() {
    }

    public StavkaIznajmljivanja(int rb, SkiOprema skiOprema) {
        this.rb = rb;
        this.skiOprema = skiOprema;
    }

    
    public StavkaIznajmljivanja(Iznajmljivanje iznajmljivanje, int rb, SkiOprema skiOprema) {
        this.iznajmljivanje = iznajmljivanje;
        this.rb = rb;
        this.skiOprema = skiOprema;
    }

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }

    public void setIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        this.iznajmljivanje = iznajmljivanje;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public SkiOprema getSkiOprema() {
        return skiOprema;
    }

    public void setSkiOprema(SkiOprema skiOprema) {
        this.skiOprema = skiOprema;
    }

    @Override
    public String vratiNazivTabele() {
        return "stavka_iznajmljivanja";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "idIznajmljivanje,rb,idSkiOprema";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return getIznajmljivanje().getIdIznajmljivanje()+","+getRb()+","+getSkiOprema().getIdSkiOprema();
    }

    @Override
    public String vratiprimarniKljuc() {
        return "stavka_iznajmljivanja.idIznajmljivanja="+getIznajmljivanje().getIdIznajmljivanje()+" and stavka_iznajmljivanja.rb="+getRb();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "idIznajmljivanje="+getIznajmljivanje().getIdIznajmljivanje()+",rb="+getRb()+",idSkiOprema="+getSkiOprema().getIdSkiOprema();
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
            
            StavkaIznajmljivanja si=new StavkaIznajmljivanja(rb, s);
            
            lista.add(si);
        }
       
        return lista;
    }
    
    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    
    
}
