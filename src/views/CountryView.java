/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CountryController;
import icontrollers.ICountryController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Country;
import models.Job;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Ode
 */
public class CountryView extends javax.swing.JInternalFrame {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    CountryController countryController = new CountryController(sessionFactory);

    /**
     * Creates new form CountryView
     */
    public CountryView() {
        initComponents();
        showTable();

    }

    public void resetText() {
        txId.setText("");
        txName.setText("");
        txRegion.setText("");
        txId.setEditable(true);
        btnInsert.setEnabled(true);
    }

    public void showTable() {
        DefaultTableModel model = (DefaultTableModel) tabCountry.getModel();
        Object[] row = new Object[4];
        List<Country> country = new ArrayList<>();
        country = countryController.getAll();
        for (int i = 0; i < country.size(); i++) {
            row[0] = i + 1;
            row[1] = country.get(i).getCountryId();
            row[2] = country.get(i).getCountryName();
            if (country.get(i).getRegionId() == null){
                row[3] = "";
            } else {
                row[3] = country.get(i).getRegionId().getRegionName();
            }
            model.addRow(row);
        }
    }

    public void updateTable() {
        DefaultTableModel model = (DefaultTableModel) tabCountry.getModel();
        model.setRowCount(0);
        showTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabCountry = new javax.swing.JTable();
        label1 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        txName = new javax.swing.JTextField();
        txRegion = new javax.swing.JTextField();
        txSearch = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setClosable(true);
        setTitle("Database Management");

        tabCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID", "NAME", "REGION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabCountry.getTableHeader().setReorderingAllowed(false);
        tabCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCountryMouseClicked(evt);
            }
        });
        tabCountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tabCountryKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tabCountry);
        if (tabCountry.getColumnModel().getColumnCount() > 0) {
            tabCountry.getColumnModel().getColumn(0).setResizable(false);
            tabCountry.getColumnModel().getColumn(1).setResizable(false);
            tabCountry.getColumnModel().getColumn(2).setResizable(false);
            tabCountry.getColumnModel().getColumn(3).setResizable(false);
        }

        label1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label1.setText("COUNTRY");

        jLabel1.setText("ID");

        jLabel2.setText("NAME");

        jLabel3.setText("REGION");

        jLabel4.setText("Search");

        txId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txIdActionPerformed(evt);
            }
        });

        txRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txRegionActionPerformed(evt);
            }
        });

        txSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSearchActionPerformed(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ID", "NAME", "REGION" }));

        btnInsert.setText("Insert");

        btnUpdate.setText("Update");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(42, 42, 42))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(25, 25, 25)))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txName, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                                    .addComponent(txId)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txRegion, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(115, 115, 115))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(btnInsert)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txRegion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txIdActionPerformed

    private void txRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txRegionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txRegionActionPerformed

    private void txSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSearchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan delete?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, countryController.delete(new Country(new String(txId.getText()))));
            updateTable();
            resetText();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        resetText();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tabCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabCountryMouseClicked
        // TODO add your handling code here:
        resetText();
        DefaultTableModel model = (DefaultTableModel) tabCountry.getModel();
        int SelectedRowIndex = tabCountry.getSelectedRow();
        txId.setEditable(false);
        txId.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        txName.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        txRegion.setText(model.getValueAt(SelectedRowIndex, 3).toString());
    }//GEN-LAST:event_tabCountryMouseClicked

    private void tabCountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabCountryKeyTyped
        // TODO add your handling code here:
//        updateTable(txSearch.getText());
    }//GEN-LAST:event_tabCountryKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JTable tabCountry;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txRegion;
    private javax.swing.JTextField txSearch;
    // End of variables declaration//GEN-END:variables
}