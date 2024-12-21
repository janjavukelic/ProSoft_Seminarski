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
public class NivoSkijanja implements Serializable,OpstiDomenskiObjekat{
    private int idNivoSkijanja;
    private int nivo;
    private String opis;

    public NivoSkijanja() {
    }

    public NivoSkijanja(int idNivoSkijanja, int nivo, String opis) {
        this.idNivoSkijanja = idNivoSkijanja;
        this.nivo = nivo;
        this.opis = opis;
    }

    public int getIdNivoSkijanja() {
        return idNivoSkijanja;
    }

    public void setIdNivoSkijanja(int idNivoSkijanja) {
        this.idNivoSkijanja = idNivoSkijanja;
    }

    public int getNivo() {
        return nivo;
    }

    public void setNivo(int nivo) {
        this.nivo = nivo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public String vratiNazivTabele() {
        return "nivo_skijanja";
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "nivo,opis";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return getNivo()+",'"+getOpis()+"'";
    }

    @Override
    public String vratiprimarniKljuc() {
        return "nivo_skijanja.idNivoSkijanja="+getIdNivoSkijanja();
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "nivo="+getNivo()+",opis='"+getOpis()+"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         List<OpstiDomenskiObjekat> lista=new ArrayList<>();
        
        while(rs.next()){
            int idNivoSkijanja=rs.getInt("nivo_skijanja.idNivoSkijanja");
            int nivo=rs.getInt("nivo_skijanja.nivo");
            String opis=rs.getString("nivo_skijanja.opis");
            NivoSkijanja nivoSkijanja=new NivoSkijanja(idNivoSkijanja, nivo, opis);

            lista.add(nivoSkijanja);
        }
       
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
