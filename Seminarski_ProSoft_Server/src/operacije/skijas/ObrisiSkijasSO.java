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
public class ObrisiSkijasSO extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(Object obj) throws Exception {
        if(obj==null || !(obj instanceof Skijas)){
            throw new Exception("Sistem ne moze da obrise pacijenta");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object obj, String key) throws Exception {
        broker.delete(obj);
    }
    
}
