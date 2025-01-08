/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.KreirajPromeniZaposleniForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class KreirajPromeniZaposleniKontroler {

    private final KreirajPromeniZaposleniForma forma;
    private Zaposleni zaposleniZaIzmenu;

    public KreirajPromeniZaposleniKontroler(KreirajPromeniZaposleniForma forma) {
        this.forma = forma;
        addActionListeners();
        pripremiKreiraj();
    }

    public KreirajPromeniZaposleniKontroler(KreirajPromeniZaposleniForma forma, Zaposleni zaposleniZaIzmenu) {
        this.forma = forma;
        this.zaposleniZaIzmenu = zaposleniZaIzmenu;
        pripremiPromeni(zaposleniZaIzmenu);
        addActionListeners();
    }

    private void addActionListeners() {
        forma.btnKreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kreirajZaposleni();
            }

        });

        forma.btnPromeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniZaposleni();
            }

        });
    }

    private void pripremiKreiraj() {
        forma.getBtnPromeni().setVisible(false);
    }

    private void pripremiPromeni(Zaposleni zaposleniZaIzmenu) {
        forma.getBtnKreiraj().setVisible(false);
        forma.getTxtIme().setText(zaposleniZaIzmenu.getIme());
        forma.getTxtPrezime().setText(zaposleniZaIzmenu.getPrezime());
        forma.getTxtKorisnickoIme().setText(zaposleniZaIzmenu.getKorisnickoIme());
        forma.getTxtSifra().setText(zaposleniZaIzmenu.getSifra());
        if (!Koordinator.getUlogovani().equals(zaposleniZaIzmenu)) {
            forma.getTxtSifra().setVisible(false);
            forma.getTxtKorisnickoIme().setVisible(false);
            forma.getLblSifra().setVisible(false);
            forma.getLblKorisnickoIme().setVisible(false);
        }
    }

    public void otvoriFormu() {
        forma.setVisible(true);
    }

    private void kreirajZaposleni() {
        String ime = forma.getTxtIme().getText().trim();
        String prezime = forma.getTxtPrezime().getText().trim();
        String korIme = forma.getTxtKorisnickoIme().getText().trim();
        String sifra = String.valueOf(forma.getTxtSifra().getPassword());

        Zaposleni zaposleni = new Zaposleni(0, ime, prezime, korIme, sifra);
        try {
            Komunikacija.getInstance().kreirajZaposleni(zaposleni);
            JOptionPane.showMessageDialog(forma, "Sistem je kreirao zaposlenog.", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
            forma.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(forma, "Sistem nije kreirao zaposlenog.", "Greska", JOptionPane.ERROR_MESSAGE);
            
        }

    }

    private void promeniZaposleni() {
        String ime = forma.getTxtIme().getText().trim();
        String prezime = forma.getTxtPrezime().getText().trim();
        String korIme = forma.getTxtKorisnickoIme().getText().trim();
        String sifra = String.valueOf(forma.getTxtSifra().getPassword());
        try{
        if (zaposleniZaIzmenu.equals(Koordinator.getUlogovani())) {
            zaposleniZaIzmenu.setIme(ime);
            zaposleniZaIzmenu.setPrezime(prezime);
            zaposleniZaIzmenu.setKorisnickoIme(korIme);
            zaposleniZaIzmenu.setSifra(sifra);
            Komunikacija.getInstance().promeniZaposleni(zaposleniZaIzmenu);
            Koordinator.setUlogovani(Komunikacija.getInstance().prijaviZaposleni(zaposleniZaIzmenu));
        } else {
            zaposleniZaIzmenu.setIme(ime);
            zaposleniZaIzmenu.setPrezime(prezime);
            zaposleniZaIzmenu.setKorisnickoIme(korIme);
            zaposleniZaIzmenu.setSifra(sifra);
            Komunikacija.getInstance().promeniZaposleni(zaposleniZaIzmenu);
        }
        JOptionPane.showMessageDialog(forma, "Sistem je promenio zaposlenog.", "Potvrda", JOptionPane.INFORMATION_MESSAGE);
        Koordinator.getInstanca().osveziTabeluZaposleni();
        forma.dispose();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da promeni zaposlenog.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
}
