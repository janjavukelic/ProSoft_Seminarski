/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.skijas;

import domen.Skijas;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author janja
 */
public class PretraziSkijasSO extends ApstraktnaGenerickaOperacija {

    private List<Skijas> lista;

    @Override
    protected void preduslovi(Object obj) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        if (obj == null) {
            lista = broker.getAll(new Skijas(), null);
            return;
        }
        Skijas skijas=(Skijas)obj;
        key=" WHERE ";
        if(skijas.getIme()!=null && !skijas.getIme().isBlank()){
            key+="skijas.ime LIKE '%"+skijas.getIme()+"%' AND ";
        }
        if(skijas.getPrezime()!=null && !skijas.getPrezime().isBlank()){
            key+="skijas.prezime LIKE '%"+skijas.getPrezime()+"%' AND ";
        }
        if(skijas.getBrTelefona()!=null && !skijas.getBrTelefona().isBlank()){
            key+="skijas.brTelefona LIKE '%"+skijas.getBrTelefona()+"%' AND ";
        }
        if(skijas.getNivoSkijanja()!=null){
            key+="skijas.idNivoSkijanja="+skijas.getNivoSkijanja().getIdNivoSkijanja();
        }
        
        if(key.endsWith("AND "))key=key.substring(0, key.length()-5);
        if(key.equals(" WHERE "))key=null;
        lista=broker.getAll(obj, key);
        
    }

    public List<Skijas> getLista() {
        return lista;
    }

}
