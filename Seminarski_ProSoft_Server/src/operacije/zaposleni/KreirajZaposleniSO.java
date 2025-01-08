/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.zaposleni;

import domen.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author janja
 */
public class KreirajZaposleniSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Zaposleni)){
            throw new Exception("greska");
        }
        Zaposleni z=(Zaposleni)obj;
        if(z.getIme()==null || z.getIme().isBlank()){
            throw new Exception("greska");
        }
        if(z.getPrezime()==null || z.getPrezime().isBlank()){
            throw new Exception("greska");
        }
        if(z.getKorisnickoIme()==null || z.getKorisnickoIme().isBlank()){
            throw new Exception("greska");
        }
        if(z.getSifra()==null || z.getSifra().isBlank()){
            throw new Exception("greska");
        }
    
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        broker.add(obj);
    }
    
}
