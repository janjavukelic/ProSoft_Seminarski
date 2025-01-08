/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.NivoSkijanja;
import domen.Skijas;
import domen.Zaposleni;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.*;

/**
 *
 * @author janja
 */
public class ObradaKlijentskihZahteva extends Thread {

    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        primalac = new Primalac(socket);
        posiljalac = new Posiljalac(socket);
    }

    @Override
    public void run() {
        while (true) {
            Odgovor odgovor=new Odgovor();
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                System.out.println("Zahtev je primljen");
                System.out.println(zahtev);
                switch (zahtev.getOperacija()) {
                    case PRIJAVI_ZAPOSLENI_SO:
                        Zaposleni z1=(Zaposleni) zahtev.getArgument();
                        z1=Controller.getInstance().login(z1);
                        odgovor.setArgument(z1);
                        break;
                    case PRETRAZI_SKIJAS_SO:
                        Skijas s1=(Skijas) zahtev.getArgument();
                        List<Skijas> lista1=Controller.getInstance().pretraziSkijas(s1);
                        odgovor.setArgument(lista1);
                        break;
                    case OBRISI_SKIJAS_SO:
                        Skijas s2=(Skijas) zahtev.getArgument();
                        Controller.getInstance().obrisiSkijas(s2);
                        break;
                    case KREIRAJ_SKIJAS_SO:
                        Skijas s3=(Skijas) zahtev.getArgument();
                        Controller.getInstance().kreirajSkijas(s3);
                        break;
                    case UBACI_NIVO_SKIJANJA_SO:
                        List<NivoSkijanja> nivoSk=Controller.getInstance().ubaciNivoSkijanja();
                        odgovor.setArgument(nivoSk);
                        break;
                    case PROMENI_SKIJAS_SO:
                        Skijas s4=(Skijas)zahtev.getArgument();
                        Controller.getInstance().promeniSkijas(s4);
                        break;
                    case PRETRAZI_ZAPOSLENI_SO:
                        Zaposleni z2=(Zaposleni) zahtev.getArgument();
                        List<Zaposleni> lista2=Controller.getInstance().pretraziZaposleni(z2);
                        odgovor.setArgument(lista2);
                        break;
                    case OBRISI_ZAPOSLENI_SO:
                        Zaposleni z3=(Zaposleni) zahtev.getArgument();
                        Controller.getInstance().obrisiZaposleni(z3);
                        break;
                    case KREIRAJ_ZAPOSLENI_SO:
                        Zaposleni z4=(Zaposleni) zahtev.getArgument();
                        Controller.getInstance().kreirajZaposleni(z4);
                        break;
                    case PROMENI_ZAPOSLENI_SO:
                        Zaposleni z5=(Zaposleni) zahtev.getArgument();
                        Controller.getInstance().promeniZaposleni(z5);
                        break;
                }
                posiljalac.posalji(odgovor);
                System.out.println("Odgovor je poslat");
                System.out.println(odgovor);
            } catch (Exception ex) {
                odgovor.setException(ex);
            }
            
        }
    }

}
