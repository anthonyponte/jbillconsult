package com.anthonyponte.jbillconsult.view;

import com.anthonyponte.jbillconsult.filter.LetterNumberFilter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        list = new ArrayList<>();
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/16x16.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/32x32.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/64x64.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/128x128.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/256x256.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsult/img/512x512.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltrar = new JTextField();
        scroll = new JScrollPane();
        table = new JTable();
        btnExportar = new JButton();
        btnImportar = new JButton();
        menuBar = new JMenuBar();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("JBillConsult");
        setIconImages(list);
        setMinimumSize(new Dimension(800, 600));
        setPreferredSize(new Dimension(800, 600));

        tfFiltrar.setMaximumSize(null);
        tfFiltrar.setMinimumSize(null);
        tfFiltrar.setPreferredSize(new Dimension(150, 30));
        AbstractDocument document = (AbstractDocument) tfFiltrar.getDocument();
        document.setDocumentFilter(new LetterNumberFilter());
        tfFiltrar.putClientProperty("JTextField.leadingIcon", FontIcon.of(RemixiconAL.FILTER_LINE, 16, Color.decode("#FFFFFF")));
        tfFiltrar.putClientProperty("JTextField.placeholderText", "Filtrar");
        tfFiltrar.putClientProperty("JTextField.showClearButton", true);

        table.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(table);

        btnExportar.setIcon(FontIcon.of(RemixiconAL.FILE_EXCEL_LINE, 16, Color.decode("#FFFFFF")));
        btnExportar.setText("Exportar");
        btnExportar.setEnabled(false);
        btnExportar.setPreferredSize(new Dimension(100, 30));

        btnImportar.setIcon(FontIcon.of(RemixiconAL.FILE_SEARCH_LINE, 16, Color.decode("#FFFFFF")));
        btnImportar.setText("Importar");
        btnImportar.setMaximumSize(null);
        btnImportar.setMinimumSize(null);
        btnImportar.setPreferredSize(new Dimension(100, 30));
        setJMenuBar(menuBar);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfFiltrar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scroll))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfFiltrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Image> list;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnExportar;
    public JButton btnImportar;
    public JMenuBar menuBar;
    public JScrollPane scroll;
    public JTable table;
    public JTextField tfFiltrar;
    // End of variables declaration//GEN-END:variables
}
