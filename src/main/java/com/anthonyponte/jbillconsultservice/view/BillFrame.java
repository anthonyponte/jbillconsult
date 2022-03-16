package com.anthonyponte.jbillconsultservice.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.GroupLayout;
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
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltrar = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        miImport = new javax.swing.JMenuItem();
        miExport = new javax.swing.JMenuItem();
        miSignOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JBillConsultService");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        tfFiltrar.setMaximumSize(null);
        tfFiltrar.setMinimumSize(null);
        tfFiltrar.setPreferredSize(new java.awt.Dimension(150, 30));
        tfFiltrar.putClientProperty("JTextField.leadingIcon", FontIcon.of(RemixiconAL.FILTER_LINE, 16, Color.decode("#FFFFFF")));
        tfFiltrar.putClientProperty("JTextField.placeholderText", "Filtrar");
        tfFiltrar.putClientProperty("JTextField.showClearButton", true);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        scroll.setViewportView(table);

        menu.setIcon( FontIcon.of(RemixiconMZ.MENU_LINE, 16, Color.decode("#FFFFFF")));
        menu.setText("Menu");

        miImport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miImport.setText("Importar");
        menu.add(miImport);

        miExport.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miExport.setText("Exportar");
        menu.add(miExport);

        miSignOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        miSignOut.setText("Salir");
        menu.add(miSignOut);

        menuBar.add(menu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFiltrar, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(scroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenu menu;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenuItem miExport;
    public javax.swing.JMenuItem miImport;
    public javax.swing.JMenuItem miSignOut;
    public javax.swing.JScrollPane scroll;
    public javax.swing.JTable table;
    public javax.swing.JTextField tfFiltrar;
    // End of variables declaration//GEN-END:variables
}
