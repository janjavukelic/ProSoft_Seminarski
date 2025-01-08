/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tabele;

import domen.Zaposleni;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author janja
 */
public class ModelTabeleZaposleni extends AbstractTableModel{
    List<Zaposleni> lista;
    String[] kolone={"Ime","Prezime"};

    public ModelTabeleZaposleni(List<Zaposleni> lista) {
        this.lista = lista;
    }

    public List<Zaposleni> getLista() {
        return lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposleni z=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return z.getIme();
            case 1:
                return z.getPrezime();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
