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
public class PrijaviZaposleniSO extends ApstraktnaGenerickaOperacija {
    
    private Zaposleni zaposleni;
    
    @Override
    protected void preduslovi(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        List<Zaposleni> lista=broker.getAll((Zaposleni)obj, null);
        System.out.println("Svi zaposleni:"+lista);
        
        for (Zaposleni z : lista) {
            if(z.equals((Zaposleni)obj))zaposleni=z;
        }
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    
    
}
