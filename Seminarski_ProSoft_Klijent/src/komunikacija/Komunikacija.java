/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Iznajmljivanje;
import domen.NivoSkijanja;
import domen.Skijas;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import operacije.Operacija;

/**
 *
 * @author janja
 */
public class Komunikacija {

    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    private Komunikacija() {
        konekcija();
    }

    public static Komunikacija getInstance() {
        if (instance == null) {
            instance = new Komunikacija();
        }
        return instance;
    }

    public void konekcija() {
        try {
            socket = new Socket("localhost", 9000);
        } catch (IOException ex) {
            System.out.println("Greska kod konekcije sa serverom!");
        }
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }

    public Zaposleni prijaviZaposleni(Zaposleni z) {
        try {
            Zahtev zahtev = new Zahtev(Operacija.PRIJAVI_ZAPOSLENI_SO, z);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {
                System.out.println("Greska sa serverske strane: " + o.getException().getMessage());
                return null;
            } else {
                return (Zaposleni) o.getArgument();
            }
        } catch (Exception ex) {

        }
        return null;
    }

    public List<Skijas> pretraziSkijas(Skijas skijas) {
        List<Skijas> lista = new LinkedList<>();
        try {
            Zahtev zahtev = new Zahtev(Operacija.PRETRAZI_SKIJAS_SO, skijas);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {
                System.out.println("Greska kod ucitavanja skijasa. " + o.getException().getMessage());
            }
            if (o.getArgument() != null) {
                lista = (List<Skijas>) o.getArgument();
            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Iznajmljivanje> vratiListuIznajmljivanje() {
        List<Iznajmljivanje> lista = new LinkedList<>();
        try {
            Zahtev zahtev = new Zahtev(Operacija.PRETRAZI_IZNAJMLJIVANJE_SO, null);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {
                System.out.println("Greska kod ucitavanja iznajmljivanja. " + o.getException().getMessage());
            }
            if (o.getArgument() != null) {
                lista = (List<Iznajmljivanje>) o.getArgument();
            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void obrisiSkijas(Skijas skijas) {
        try {
            Zahtev zahtev = new Zahtev(Operacija.OBRISI_SKIJAS_SO, skijas);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {

            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void kreirajSkijas(Skijas skijas) {
        try {
            Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_SKIJAS_SO, skijas);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {

            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<NivoSkijanja> ubaciNivoSkijanja() {
        try {
            Zahtev zahtev = new Zahtev(Operacija.UBACI_NIVO_SKIJANJA_SO, null);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {

            }
            return (List<NivoSkijanja>) o.getArgument();
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void promeniSkijas(Skijas skijas) {
        try {
            Zahtev zahtev = new Zahtev(Operacija.PROMENI_SKIJAS_SO, skijas);
            posiljalac.posalji(zahtev);
            System.out.println("Poslao sam zahtev");
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {

            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Zaposleni> pretraziZaposleni(Zaposleni zaposleni) {
        List<Zaposleni> lista = new LinkedList<>();
        try {
            Zahtev zahtev = new Zahtev(Operacija.PRETRAZI_ZAPOSLENI_SO, zaposleni);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {
                System.out.println("Greska kod ucitavanja zaposlenih. " + o.getException().getMessage());
            }
            if (o.getArgument() != null) {
                lista = (List<Zaposleni>) o.getArgument();
            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void obrisiZaposleni(Zaposleni zaposleni) {
        try {
            Zahtev zahtev = new Zahtev(Operacija.OBRISI_ZAPOSLENI_SO, zaposleni);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {

            }
        } catch (Exception ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kreirajZaposleni(Zaposleni zaposleni) throws Exception {
        
            Zahtev zahtev = new Zahtev(Operacija.KREIRAJ_ZAPOSLENI_SO, zaposleni);
            posiljalac.posalji(zahtev);
            Odgovor o = (Odgovor) primalac.primi();
            if (o.getException() != null) {
                throw o.getException();
            }
        
    }

    public void promeniZaposleni(Zaposleni zaposleniZaIzmenu) throws Exception {

        Zahtev zahtev = new Zahtev(Operacija.PROMENI_ZAPOSLENI_SO, zaposleniZaIzmenu);
        posiljalac.posalji(zahtev);
        Odgovor o = (Odgovor) primalac.primi();
        if (o.getException() != null) {
            throw o.getException();
        }

    }

}
