/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.NivoSkijanja;
import domen.Skijas;
import forme.KreirajIzmeniSkijasaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import komunikacija.Komunikacija;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class KreirajIzmeniSkijasaKontroler {

    private Skijas skijasZaIzmenu;
    private final KreirajIzmeniSkijasaForma forma;

    public KreirajIzmeniSkijasaKontroler(KreirajIzmeniSkijasaForma forma) {
        this.forma = forma;
        addActionListeners();
        pripremiZaKreiranje();
    }

    public KreirajIzmeniSkijasaKontroler(Skijas skijasZaIzmenu, KreirajIzmeniSkijasaForma forma) {
        this.skijasZaIzmenu = skijasZaIzmenu;
        this.forma = forma;
        pripremiZaIzmenu();
        addActionListeners();
    }

    public void otvoriFormu() {
        forma.setVisible(true);
        popuniCombo();
    }

    private void addActionListeners() {
        forma.btnKreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kreirajSkijas();
            }
        });
        forma.btnIzmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniSkijas();
            }

        });
    }

    private void popuniCombo() {
        List<NivoSkijanja> lista = Komunikacija.getInstance().ubaciNivoSkijanja();
        if (lista == null) {
            return;
        }
        for (NivoSkijanja nivoSkijanja : lista) {
            forma.getComboNivoSkijanja().addItem(nivoSkijanja);
        }

    }

    private void kreirajSkijas() {
        String ime = forma.getTxtIme().getText().trim();
        String prezime = forma.getTxtPrezime().getText().trim();
        String brTel = forma.getTxtBrojTel().getText().trim();
        NivoSkijanja nivo = (NivoSkijanja) forma.getComboNivoSkijanja().getSelectedItem();

        Skijas skijas = new Skijas(0, ime, prezime, brTel, nivo);
        Komunikacija.getInstance().kreirajSkijas(skijas);

    }

    private void pripremiZaKreiranje() {
        forma.getBtnIzmeni().setEnabled(false);
    }

    private void pripremiZaIzmenu() {
        forma.getBtnKreiraj().setEnabled(false);
        forma.getTxtIme().setText(skijasZaIzmenu.getIme());
        forma.getTxtPrezime().setText(skijasZaIzmenu.getPrezime());
        forma.getTxtBrojTel().setText(skijasZaIzmenu.getBrTelefona());
        forma.getComboNivoSkijanja().setSelectedItem(skijasZaIzmenu.getNivoSkijanja());
    }

    private void promeniSkijas() {
        String ime = forma.getTxtIme().getText().trim();
        String prezime = forma.getTxtPrezime().getText().trim();
        String brTel = forma.getTxtBrojTel().getText().trim();
        NivoSkijanja nivo = (NivoSkijanja) forma.getComboNivoSkijanja().getSelectedItem();

        
        skijasZaIzmenu.setIme(ime);
        skijasZaIzmenu.setPrezime(prezime);
        skijasZaIzmenu.setBrTelefona(brTel);
        skijasZaIzmenu.setNivoSkijanja(nivo);
        Komunikacija.getInstance().promeniSkijas(skijasZaIzmenu);
    }
}
