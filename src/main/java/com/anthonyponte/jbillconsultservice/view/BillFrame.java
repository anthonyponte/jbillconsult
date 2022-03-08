package com.anthonyponte.jbillconsultservice.view;

import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFilter = new JTextField();
        scroll = new JScrollPane();
        table = new JTable();
        menuBar = new JMenuBar();
        menu = new JMenu();
        miImport = new JMenuItem();
        miExport = new JMenuItem();
        miSignOut = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JBillStatus");
        setMinimumSize(new Dimension(800, 600));

        tfFilter.setMaximumSize(null);
        tfFilter.setMinimumSize(null);
        tfFilter.setPreferredSize(new Dimension(150, 30));

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);

        menu.setText("Menu");

        miImport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        miImport.setText("Importar");
        menu.add(miImport);

        miExport.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        miExport.setText("Exportar");
        menu.add(miExport);

        miSignOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        miSignOut.setText("Salir");
        menu.add(miSignOut);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                    .addComponent(tfFilter, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JMenu menu;
    public JMenuBar menuBar;
    public JMenuItem miExport;
    public JMenuItem miImport;
    public JMenuItem miSignOut;
    public JScrollPane scroll;
    public JTable table;
    public JTextField tfFilter;
    // End of variables declaration//GEN-END:variables
}
