/*
 * Questions.java ON 12/2/15 4:04 PM
 *   Copyright 2015 Tarakesh
 *   Copyright 2015 Arvind Mukund <arvind@MasterAwesome>
 *
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program; if not, write to the Free Software
 *   Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 *   MA 02110-1301, USA.
 */

import java.sql.*;

class Questions extends javax.swing.JFrame {
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static String tableSelectedPreviously;
    private javax.swing.JLabel jLabel1;

    /**
     * Creates new form Questions
     */
    public Questions() {
        initComponents();
        try {
            Class.forName("java.sql.DriverManager");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "root");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Introduce another base constructor to transverse the tablename from previous GUI.
     * 
     * @param tablename
     */
    public Questions(String tablename) {
        initComponents();
        tableSelectedPreviously = tablename;
        try {
            Class.forName("java.sql.DriverManager");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public static void newQuestion(boolean b) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/AI", "root", "root");
            Statement stew = conn.createStatement();
            ResultSet revv = stew.executeQuery(
                    String.format("SELECT * FROM %s", tableSelectedPreviously));
            if (!(rs.next())) {
                acceptQuestion aq = new acceptQuestion();
                aq.setVisible(true);
                aq.setTitle("thanks for helping");

            }
        } catch (Exception e) {

        }

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questions().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
        javax.swing.JRadioButton jRadioButton1 = new javax.swing.JRadioButton();
        javax.swing.JRadioButton jRadioButton2 = new javax.swing.JRadioButton();
        javax.swing.JButton jButton1 = new javax.swing.JButton();
        javax.swing.JButton jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("q");

        jTextField1.setEnabled(false);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("yes");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("no");

        jButton1.setText("Get Question");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jButton2.setText("Next");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGroup(
                                                layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                layout.createSequentialGroup()
                                                                        .addGap(61, 61, 61)
                                                                        .addGroup(
                                                                                layout.createParallelGroup(
                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(
                                                                                                layout.createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                jRadioButton1)
                                                                                                        .addGap(68,
                                                                                                                68,
                                                                                                                68)
                                                                                                        .addComponent(
                                                                                                                jRadioButton2))
                                                                                        .addGroup(
                                                                                                layout.createSequentialGroup()
                                                                                                        .addGap(31,
                                                                                                                31,
                                                                                                                31)
                                                                                                        .addGroup(
                                                                                                                layout.createParallelGroup(
                                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                        .addComponent(
                                                                                                                                jLabel1)
                                                                                                                        .addComponent(
                                                                                                                                jTextField1,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                95,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(90, 90, 90)
                                                                .addComponent(jButton1))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(109, 109, 109)
                                                                .addComponent(jButton2)))
                                        .addContainerGap(86, Short.MAX_VALUE))
                );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel1)
                                        .addGap(38, 38, 38)
                                        .addComponent(jTextField1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addGroup(
                                                layout.createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jRadioButton1)
                                                        .addComponent(jRadioButton2))
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                25, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addContainerGap())
                );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(
            java.awt.event.ActionEvent evt)
            throws Exception {// GEN-FIRST:event_jButton1ActionPerformed

        String sql1 = "SELECT * FROM CHOSENTABLE";
        String table = "";
        Statement st2 = conn.createStatement();
        ResultSet rs2 = st2.executeQuery(sql1);
        while (rs2.next()) {
            table = rs2.getString("TABLENAME");
            // loggings -_-
        }
        String update = "SELECT * FROM " + table;// not an update but an query
        String question = "";
        Statement st = conn.createStatement();
        rs = st.executeQuery(update);

        while (rs.next()) {
            question = rs.getString("QUESTION");
        }
        jLabel1.setText(question);

    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(
            java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed

    }// GEN-LAST:event_jButton2ActionPerformed
     // End of variables declaration//GEN-END:variables

}
