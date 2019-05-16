/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeeController;
import icontrollers.IEmployeeController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.Department;
import models.Employee;
import tools.HibernateUtil;

/**
 *
 * @author Relion31
 */
public class JEmployeeView extends javax.swing.JInternalFrame {

    IEmployeeController iec = new EmployeeController(HibernateUtil.getSessionFactory());

    /**
     * Creates new form JEmployeeView
     */
    public JEmployeeView() {
        initComponents();
        showTable("");
//        getDataComboDepartment();
//        
//        getDataComboJob();

    }

    public void resetText() {
        id.setText("");
        fname.setText("");
        lname.setText("");
        email.setText("");
        phone.setText("");
        hire.setText("");
//        job_id.setText("");
        salary.setText("");
        manager.setText("");
        //     manager.setText("");
        //       cmbDepartment.setText("");
        id.setEditable(true);
        btnInsert.setEnabled(true);
//        getDataComboDepartment();
//        getDataComboJob();
//        cmbDepartment.setSelectedIndex(0);
//        cmbJob.setSelectedIndex(0);
    }

    public void showTable() {
        DefaultTableModel model = (DefaultTableModel) tEmployee.getModel();
        Object[] row = new Object[12];
        List<Employee> employees = new ArrayList<>();
        employees = iec.getAll();
        for (int i = 0; i < iec.getAll().size(); i++) {
            row[0] = i + 1;
            row[1] = employees.get(i).getEmployeeId();
            row[2] = employees.get(i).getFirstName();
            row[3] = employees.get(i).getLastName();
            row[4] = employees.get(i).getEmail();
            row[5] = employees.get(i).getPhoneNumber();
            row[6] = employees.get(i).getHireDate();
            if (employees.get(i).getJobId() == null) {
                row[7] = "";
            } else {
                row[7] = employees.get(i).getJobId().getJobId();
            }
            row[8] = employees.get(i).getSalary();
            if (employees.get(i).getCommissionPct() == null) {
                row[9] = "";
            } else {
                row[9] = employees.get(i).getCommissionPct();
            }
            if (employees.get(i).getManagerId() == null) {
                row[10] = "";
            } else {
                row[10] = employees.get(i).getManagerId().getEmployeeId();
            }
            if (employees.get(i).getDepartmentId() == null) {
                row[11] = "";
            } else {
                row[11] = employees.get(i).getDepartmentId().getDepartmentId();
            }
            model.addRow(row);
        }
    }

    public void showTable(String s) {
        DefaultTableModel model = (DefaultTableModel) tEmployee.getModel();
        Object[] row = new Object[12];
        List<Employee> employees = new ArrayList<>();
        employees = iec.search(s);
        for (int i = 0; i < iec.search(s).size(); i++) {
            row[0] = i+1;
            row[1] = employees.get(i).getEmployeeId();
            row[2] = employees.get(i).getFirstName();
            row[3] = employees.get(i).getLastName();
            row[4] = employees.get(i).getEmail();
            row[5] = employees.get(i).getPhoneNumber();
            row[6] = employees.get(i).getHireDate();
            if (employees.get(i).getJobId() == null) {
                row[7] = "";
            } else {
                row[7] = employees.get(i).getJobId().getJobId();
            }
            row[8] = employees.get(i).getSalary();
            if (employees.get(i).getCommissionPct() == null) {
                row[9] = "";
            } else {
                row[9] = employees.get(i).getCommissionPct();
            }
            if (employees.get(i).getManagerId()== null) {
                row[10] = "";
            } else {
                row[10] = employees.get(i).getManagerId().getEmployeeId();
            }
            if (employees.get(i).getDepartmentId() == null) {
                row[11] = "";
            } else {
                row[11] = employees.get(i).getDepartmentId().getDepartmentId();
            }
            model.addRow(row);
        }
    }
    
//     public void updateTable(){
//        DefaultTableModel model = (DefaultTableModel)tEmployee.getModel();
//        model.setRowCount(0);
//        showTable("");
//    }
    public void updateTable(String s) {
        DefaultTableModel model = (DefaultTableModel) tEmployee.getModel();
        model.setRowCount(0);
        showTable(s);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        hire = new javax.swing.JTextField();
        salary = new javax.swing.JTextField();
        manager = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEmployee = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        cbbSearch = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        commission = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        deptid = new javax.swing.JTextField();
        jobid = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        jToggleButton2.setText("jToggleButton2");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("EMPLOYEE");
        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("EMPLOYEE");

        jLabel2.setText("ID");

        jLabel3.setText("First Name");

        jLabel4.setText("Last Name");

        jLabel5.setText("Email");

        jLabel6.setText("Phone");

        jLabel7.setText("Hire Date");

        jLabel8.setText("Job ID");

        jLabel9.setText("Salary");

        jLabel10.setText("Commision");

        jLabel11.setText("Manager ID");

        jLabel12.setText("Department ID");

        btnInsert.setText("SAVE");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "First_Name", "Last_Name", "Email", "Phone", "Hire_Date", "Job_Id", "Salary", "Commission", "Manager_Id", "Department_Id"
            }
        ));
        tEmployee.getTableHeader().setReorderingAllowed(false);
        tEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tEmployee);

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });

        cbbSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ALL", "ID", "NAME" }));

        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cetak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(id)
                                    .addComponent(fname)
                                    .addComponent(lname)
                                    .addComponent(email)
                                    .addComponent(phone)
                                    .addComponent(hire, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(41, 41, 41))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jobid, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(salary, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(commission, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(manager, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(deptid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jobid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commission, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deptid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(hire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)
                        .addComponent(btnInsert)
                        .addComponent(btnDelete)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
//        YourType varName = (YourType)comboBox.getSelectedItem();`
//        String job = cmbJob.getSelectedItem().toString();
//        String department = cmbDepartment.getSelectedItem().toString();
//        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan insert?", "Confirm Insert", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if(confirm==JOptionPane.YES_OPTION){
//            JOptionPane.showMessageDialog(null, iec.save(id.getText(), fname.getText(), lname.getText(), email.getText(),phone.getText(), hire.getText(), job, salary.getText(), commission.getText(), manager.getText(), department));
//            updateTable("");
//            resetText();
//        }
    }//GEN-LAST:event_btnInsertActionPerformed

//    private void getDataComboDepartment(){
//        for (Department department : new DepartmentController(db.getConnection()).getAll()) {
//            cmbDepartment.addItem(department.getDepartment_id()+"");
//        }
//    }
//    
//    private void getDataComboJob(){
//        for (Job job : new JobController(db.getConnection()).getAll()) {
//            cmbJob.addItem(job.getJob_id());
//        }
//    }

    private void tEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmployeeMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tEmployee.getModel();
        int SelectedRowIndex = tEmployee.getSelectedRow();
        id.setEditable(false);
        id.setText(model.getValueAt(SelectedRowIndex, 1).toString());
        fname.setText(model.getValueAt(SelectedRowIndex, 2).toString());
        lname.setText(model.getValueAt(SelectedRowIndex, 3).toString());
        email.setText(model.getValueAt(SelectedRowIndex, 4).toString());
        phone.setText(model.getValueAt(SelectedRowIndex, 5).toString());
        hire.setText(model.getValueAt(SelectedRowIndex, 6).toString());
        jobid.setText(model.getValueAt(SelectedRowIndex, 7).toString());
        salary.setText(model.getValueAt(SelectedRowIndex, 8).toString());
        commission.setText(model.getValueAt(SelectedRowIndex, 9).toString());
        manager.setText(model.getValueAt(SelectedRowIndex, 10).toString());
        deptid.setText(model.getValueAt(SelectedRowIndex, 11).toString());

    }//GEN-LAST:event_tEmployeeMouseClicked

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:
        updateTable(search.getText());
    }//GEN-LAST:event_searchKeyTyped

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
//        // TODO add your handling code here:
//        int confirm = JOptionPane.showConfirmDialog(this, "Apakah anda yakin untuk melakukan delete?", "Confirm Update", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//        if(confirm==JOptionPane.YES_OPTION){
//            JOptionPane.showMessageDialog(null, iec.delete(id.getText()));
//            updateTable("");
//            resetText();
//        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here
        resetText();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
//        String ReportSource = null;
//        String ReportDest = null;
//        
//        try {
// //           DBConnection db = new DBConnection();
//            ReportSource = System.getProperty("user.dir")+ "/src/report/report_employee.jrxml";
//            ReportDest = System.getProperty("user.dir")+ "/src/report/report_employee.jasper";
//            
//            JasperReport jasperReport = JasperCompileManager.compileReport(ReportSource);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null, db.getConnection());
////            JasperExportManager.exportReportToHtmlFile(jasperPrint, ReportDest);
//            JasperViewer.viewReport(jasperPrint, false);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JComboBox<String> cbbSearch;
    private javax.swing.JTextField commission;
    private javax.swing.JTextField deptid;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField hire;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JTextField jobid;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField manager;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField salary;
    private javax.swing.JTextField search;
    private javax.swing.JTable tEmployee;
    // End of variables declaration//GEN-END:variables
}
