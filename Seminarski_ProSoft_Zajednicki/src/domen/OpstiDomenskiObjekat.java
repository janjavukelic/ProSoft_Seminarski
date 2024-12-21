/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domen;
import java.sql.ResultSet;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author janja
 */
public interface OpstiDomenskiObjekat extends Serializable {
    public String vratiNazivTabele();
    public String vratiKoloneZaUbacivanje();
    public String vratiVrednostiZaUbacivanje();
    public String vratiprimarniKljuc();
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception;
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception;
    public String vratiVrednostiZaIzmenu();
    
}
