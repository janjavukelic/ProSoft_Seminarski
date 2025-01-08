/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.nivo_skijanja;

import controller.Controller;
import domen.NivoSkijanja;
import java.util.List;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author janja
 */
public class UbaciNivoSkijanjaSO extends ApstraktnaGenerickaOperacija{
    private List<NivoSkijanja> lista;

    @Override
    protected void preduslovi(Object obj) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        lista=broker.getAll(obj, key);
        System.out.println("Lista nivoa: "+lista);
    }

    public List<NivoSkijanja> getLista() {
        return lista;
    }
    
    
}
