/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.zaposleni;

import domen.Zaposleni;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author janja
 */
public class PretraziZaposleniSO extends ApstraktnaGenerickaOperacija{
    List<Zaposleni> lista;

    @Override
    protected void preduslovi(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        if(obj==null){
            lista=broker.getAll(new Zaposleni(), null);
            return;
        }
        Zaposleni zaposleni=(Zaposleni)obj;
        key=" WHERE ";
        if(zaposleni.getIme()!=null && !zaposleni.getIme().isBlank()){
            key+="zaposleni.ime LIKE '%"+zaposleni.getIme()+"%' AND ";
        }
        if(zaposleni.getPrezime()!=null && !zaposleni.getPrezime().isBlank()){
            key+="zaposleni.prezime LIKE '%"+zaposleni.getPrezime()+"%'";
        }
        
        if(key.endsWith("AND "))key=key.substring(0,key.length()-5);
        if(key.equals(" WHERE "))key=null;
        lista=broker.getAll(obj, key);
        
    }

    public List<Zaposleni> getLista() {
        return lista;
    }

   
    
    
}
