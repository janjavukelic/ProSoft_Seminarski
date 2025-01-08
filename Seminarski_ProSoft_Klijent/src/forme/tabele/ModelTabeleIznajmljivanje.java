/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tabele;

import domen.Iznajmljivanje;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author janja
 */
public class ModelTabeleIznajmljivanje extends AbstractTableModel{
    List<Iznajmljivanje> lista;
    String [] kolone={"ID","Skijas","Datum uzimanja","Datum vracanja","Cena","Zaposleni"};
    
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
        Iznajmljivanje i=lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return i.getIdIznajmljivanje();
            case 1:
                return i.getSkijas();
            case 2:
                return i.getDatumUzimanja();
            case 3:
                return i.getDatumVracanja();
            case 4:
                return i.getCena();
            case 5:
                return i.getZaposleni();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public ModelTabeleIznajmljivanje(List<Iznajmljivanje> lista) {
        this.lista = lista;
    }
    
    
    
}
