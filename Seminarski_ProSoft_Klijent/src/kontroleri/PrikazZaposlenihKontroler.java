/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.PrikaziZaposlenogForma;
import forme.tabele.ModelTabeleZaposleni;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;

/**
 *
 * @author janja
 */
public class PrikazZaposlenihKontroler {

    private final PrikaziZaposlenogForma forma;

    public PrikazZaposlenihKontroler(PrikaziZaposlenogForma forma) {
        this.forma = forma;
        addActionListeners();
        osveziTabelu(null);
    }

    private void addActionListeners() {
        forma.btnObrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                obrisiZaposleni();
            }

        });

        forma.btnPromeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promeniZaposleni();
            }

        });

        forma.txtImeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziZaposleni();
            }

        });

        forma.txtPrezimeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pretraziZaposleni();
            }
        });

    }

    private void osveziTabelu(List<Zaposleni> lista) {
        if (lista == null) {
            lista = Komunikacija.getInstance().pretraziZaposleni(null);
        }
        ModelTabeleZaposleni mtz = new ModelTabeleZaposleni(lista);
        forma.getTabela().setModel(mtz);
    }

    public void otvoriFormu() {
        forma.setVisible(true);
    }

    private void obrisiZaposleni() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da obrise zaposlenog.", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Zaposleni zaposleni = ((ModelTabeleZaposleni) forma.getTabela().getModel()).getLista().get(red);
        Komunikacija.getInstance().obrisiZaposleni(zaposleni);
        osveziTabelu(null);
    }

    private void pretraziZaposleni() {
        String ime = forma.getTxtIme().getText().trim();
        String prezime = forma.getTxtPrezime().getText().trim();
        Zaposleni zaposleni = new Zaposleni(0, ime, prezime, null, null);

        List<Zaposleni> lista = Komunikacija.getInstance().pretraziZaposleni(zaposleni);
        osveziTabelu(lista);
    }

    private void promeniZaposleni() {
        int red = forma.getTabela().getSelectedRow();
        if (red == -1) {
            JOptionPane.showMessageDialog(forma, "Sistem ne moze da promeni zaposlenog.", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Zaposleni zaposleni = ((ModelTabeleZaposleni) forma.getTabela().getModel()).getLista().get(red);
        Koordinator.getInstanca().otvoriPromeniZaposleniFormu(zaposleni);
        osveziTabelu(null);
    }

    public PrikaziZaposlenogForma getForma() {
        return forma;
    }
    
    
}
