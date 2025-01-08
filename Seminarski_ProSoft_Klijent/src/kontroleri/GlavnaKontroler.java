/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class GlavnaKontroler {

    private final GlavnaForma forma;

    public GlavnaKontroler(GlavnaForma gf) {
        this.forma = gf;
        addActionListeners();
    }

    public void otvoriGlavnuFormu() {
        forma.setVisible(true);
        Zaposleni ulogovani = Koordinator.getInstanca().getUlogovani();
        forma.getLblUlogovani().setText("Zdravo, " + ulogovani.getIme() + " " + ulogovani.getPrezime());
    }

    private void addActionListeners() {
        //skijas: prikazi
        forma.prikaziSkijasAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziSkijas();
            }
        });
        //iznajmljivanje: prikazi
        forma.prikaziIznAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziIznajmljivanje();
            }

        });
        //skijas: kreiraj
        forma.kreirajSkijasaAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziKreirajSkijasa();
            }

        });
        forma.prikaziZaposleniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prikaziZaposleni();
            }

        });
        forma.kreirajZaposleniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kreirajZaposleni();
            }

        });
    }

    private void prikaziSkijas() {
        Koordinator.getInstanca().otvoriPrikazSkijasaFormu();
    }

    private void prikaziIznajmljivanje() {

    }

    private void prikaziKreirajSkijasa() {
        Koordinator.getInstanca().otvoriKreirajSkijasaFormu();
    }

    private void prikaziZaposleni() {
        Koordinator.getInstanca().otvoriPrikazZaposlenihFormu();
    }

    private void kreirajZaposleni() {
        Koordinator.getInstanca().otvoriKreirajZaposleniFormu();
    }
}
