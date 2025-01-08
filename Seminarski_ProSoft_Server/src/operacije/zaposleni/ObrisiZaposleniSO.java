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
public class ObrisiZaposleniSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Zaposleni) || ((Zaposleni)obj).getIdZaposleni()==0){
            throw new Exception("Greska.");
        }
        
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        broker.delete(obj);
    }
    
    
    
}
