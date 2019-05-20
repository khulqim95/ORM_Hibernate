/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Okala
 */
public class ViewProccess<T> {
    public void viewTable(JTable table, String[] header, List<T> datas){
        DefaultTableModel dtm = new DefaultTableModel(header, 0);
        datas.forEach((data) -> {
            dtm.addRow((Object[]) data);
        });
        table.setModel(dtm);
    }
}
