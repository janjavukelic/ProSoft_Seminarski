/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domen.NivoSkijanja;
import domen.Skijas;
import domen.Zaposleni;
import java.util.List;
import operacije.nivo_skijanja.UbaciNivoSkijanjaSO;
import operacije.skijas.KreirajSkijasSO;
import operacije.skijas.ObrisiSkijasSO;
import operacije.zaposleni.PrijaviZaposleniSO;
import operacije.skijas.PretraziSkijasSO;
import operacije.skijas.PromeniSkijasSO;
import operacije.zaposleni.KreirajZaposleniSO;
import operacije.zaposleni.ObrisiZaposleniSO;
import operacije.zaposleni.PretraziZaposleniSO;
import operacije.zaposleni.PromeniZaposleniSO;

/**
 *
 * @author janja
 */
public class Controller {
    private static Controller instance;

    public static Controller getInstance() {
        if(instance==null)instance=new Controller();
        return instance;
    }

    private Controller() {
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        PrijaviZaposleniSO operacija=new PrijaviZaposleniSO();
        operacija.izvrsi((Zaposleni)z, null);
        System.out.println("Klasa Controller: "+operacija.getZaposleni());
        return operacija.getZaposleni();
    }

    public List<Skijas> pretraziSkijas(Skijas skijas) throws Exception {
        PretraziSkijasSO operacija=new PretraziSkijasSO();
        operacija.izvrsi(skijas, null);
        return operacija.getLista();
    }

    public void obrisiSkijas(Skijas skijas) throws Exception {
        ObrisiSkijasSO operacija=new ObrisiSkijasSO();
        operacija.izvrsi(skijas, null);
    }

    public void kreirajSkijas(Skijas sk) throws Exception {
        KreirajSkijasSO operacija=new KreirajSkijasSO();
        operacija.izvrsi(sk, null);
    }

    public List<NivoSkijanja> ubaciNivoSkijanja() throws Exception {
        UbaciNivoSkijanjaSO operacija=new UbaciNivoSkijanjaSO();
        operacija.izvrsi(new NivoSkijanja(), null);
        return operacija.getLista();
    }

    public void promeniSkijas(Skijas skijas) throws Exception {
        PromeniSkijasSO operacija=new PromeniSkijasSO();
        operacija.izvrsi(skijas, null);
    }

    public List<Zaposleni> pretraziZaposleni(Zaposleni z2) throws Exception {
        PretraziZaposleniSO operacija=new PretraziZaposleniSO();
        operacija.izvrsi(z2, null);
        return operacija.getLista();
    }

    public void obrisiZaposleni(Zaposleni z3) throws Exception {
        ObrisiZaposleniSO operacija=new ObrisiZaposleniSO();
        operacija.izvrsi(z3, null);
    }

    public void kreirajZaposleni(Zaposleni z4) throws Exception {
        KreirajZaposleniSO operacija=new KreirajZaposleniSO();
        operacija.izvrsi(z4, null);
    }

    public void promeniZaposleni(Zaposleni z5) throws Exception {
        PromeniZaposleniSO operacija=new PromeniZaposleniSO();
        operacija.izvrsi(z5, null);
    }
    
    
    
    
}
