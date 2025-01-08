/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koordinator;

import domen.Skijas;
import domen.Zaposleni;
import forme.GlavnaForma;
import forme.KreirajIzmeniSkijasaForma;
import forme.KreirajPromeniZaposleniForma;
import forme.LoginFroma;
import forme.PrikaziIznajmljivanjeForma;
import forme.PrikaziSkijasaForma;
import forme.PrikaziZaposlenogForma;
import forme.tabele.ModelTabeleZaposleni;
import java.util.List;
import komunikacija.Komunikacija;
import kontroleri.GlavnaKontroler;
import kontroleri.KreirajIzmeniSkijasaKontroler;
import kontroleri.KreirajPromeniZaposleniKontroler;
import kontroleri.LoginKontroler;
import kontroleri.PrikazIznajmljivanjaKontroler;
import kontroleri.PrikazSkijasaKontroler;
import kontroleri.PrikazZaposlenihKontroler;

/**
 *
 * @author janja
 */
public class Koordinator {
    private static Koordinator instanca;
    private static Zaposleni ulogovani;
    
    private LoginKontroler loginKontroler;
    private GlavnaKontroler glavnaKontroler;
    private PrikazSkijasaKontroler prikazSkijasaKontroler;
    private PrikazIznajmljivanjaKontroler prikaziIznajmljivanjaKontroler;
    private KreirajIzmeniSkijasaKontroler kreirajIzmeniSkijasaKontroler;
    private PrikazZaposlenihKontroler prikazZaposlenihKontroler;
    private KreirajPromeniZaposleniKontroler kreirajPromeniZaposleniKontroler;

    private Koordinator() {
    }

    public static Koordinator getInstanca() {
        if(instanca==null)instanca=new Koordinator();
        return instanca;
    }
    

    public void otvoriLoginFormu(){
        loginKontroler=new LoginKontroler(new LoginFroma());
        loginKontroler.otvoriFormu();
    }
    
    public void otvoriGlavnuFormu(){
        glavnaKontroler=new GlavnaKontroler(new GlavnaForma());
        glavnaKontroler.otvoriGlavnuFormu();
    }

    public void otvoriPrikazSkijasaFormu(){
        prikazSkijasaKontroler=new PrikazSkijasaKontroler(new PrikaziSkijasaForma());
        prikazSkijasaKontroler.otvoriPrikazSkijasaFormu();
    }
    
    public void otvoriPrikazIznajmljivanjaFormu(){
        prikaziIznajmljivanjaKontroler=new PrikazIznajmljivanjaKontroler(new PrikaziIznajmljivanjeForma());
        prikaziIznajmljivanjaKontroler.otvoriFormu();
    }
    
    public void otvoriKreirajSkijasaFormu(){
        kreirajIzmeniSkijasaKontroler=new KreirajIzmeniSkijasaKontroler(new KreirajIzmeniSkijasaForma());
        kreirajIzmeniSkijasaKontroler.otvoriFormu();
    }
    
    public void otvoriIzmeniSkijasaFormu(Skijas skijas){
        kreirajIzmeniSkijasaKontroler=new KreirajIzmeniSkijasaKontroler(skijas,new KreirajIzmeniSkijasaForma());
        kreirajIzmeniSkijasaKontroler.otvoriFormu();
    }
    
    public void otvoriPrikazZaposlenihFormu(){
        prikazZaposlenihKontroler=new PrikazZaposlenihKontroler(new PrikaziZaposlenogForma());
        prikazZaposlenihKontroler.otvoriFormu();
    }

    public void otvoriKreirajZaposleniFormu(){
        kreirajPromeniZaposleniKontroler=new KreirajPromeniZaposleniKontroler(new KreirajPromeniZaposleniForma());
        kreirajPromeniZaposleniKontroler.otvoriFormu();
    }
    
    public void otvoriPromeniZaposleniFormu(Zaposleni zaposleni){
        kreirajPromeniZaposleniKontroler=new KreirajPromeniZaposleniKontroler(new KreirajPromeniZaposleniForma(),zaposleni);
        kreirajPromeniZaposleniKontroler.otvoriFormu();
    }
    
    public void osveziTabeluZaposleni(){
        List<Zaposleni> lista = Komunikacija.getInstance().pretraziZaposleni(null);
        
        ModelTabeleZaposleni mtz = new ModelTabeleZaposleni(lista);
        prikazZaposlenihKontroler.getForma().getTabela().setModel(mtz);
    }
    
    public static Zaposleni getUlogovani() {
        return ulogovani;
    }

    public static void setUlogovani(Zaposleni ulogovani) {
        Koordinator.ulogovani = ulogovani;
    }
    
   
    
    
}
