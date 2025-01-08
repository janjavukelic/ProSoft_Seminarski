/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.skijas;

import domen.Skijas;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author janja
 */
public class PromeniSkijasSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Skijas))
            throw new Exception("Greska kod kreirajSO");
        Skijas s=(Skijas)obj;
        if(s.getBrTelefona()==null || s.getBrTelefona().length()<9)
            throw new Exception("Greska kod kreirajSO");
        if(s.getIme()==null || s.getIme().isBlank())
            throw new Exception("Greska kod kreirajSO");
        if(s.getPrezime()==null || s.getPrezime().isEmpty())
            throw new Exception("Greska kod kreirajSO");
        if(s.getNivoSkijanja()==null)
            throw new Exception("Greska kod kreirajSO");
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        broker.update((Skijas)obj);
    }
    
}
