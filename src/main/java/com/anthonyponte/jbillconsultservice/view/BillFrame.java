package com.anthonyponte.jbillconsultservice.view;

import com.anthonyponte.jbillconsultservice.filter.LetterNumberFilter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
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
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import org.kordamp.ikonli.remixicon.RemixiconAL;
import org.kordamp.ikonli.remixicon.RemixiconMZ;
import org.kordamp.ikonli.swing.FontIcon;

public class BillFrame extends javax.swing.JFrame {

    public BillFrame() {
        list = new ArrayList<>();
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/16x16.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/32x32.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/64x64.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/128x128.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/256x256.png")).getImage());
        list.add(new ImageIcon(getClass().getResource("/com/anthonyponte/jbillconsultservice/img/512x512.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltrar = new JTextField();
        scroll = new JScrollPane();
        table = new JTable();
        menuBar = new JMenuBar();
        menu = new JMenu();
        miImportar = new JMenuItem();
        miExportar = new JMenuItem();
        miSalir = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("JBillConsultService");
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

        menu.setIcon( FontIcon.of(RemixiconMZ.MENU_LINE, 16, Color.decode("#FFFFFF")));
        menu.setText("Menu");

        miImportar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        miImportar.setIcon(FontIcon.of(RemixiconAL.FILE_UPLOAD_LINE, 16, Color.decode("#FFFFFF")));
        miImportar.setText("Importar");
        menu.add(miImportar);

        miExportar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        miExportar.setIcon(FontIcon.of(RemixiconAL.FILE_DOWNLOAD_LINE, 16, Color.decode("#FFFFFF")));
        miExportar.setText("Exportar");
        menu.add(miExportar);

        miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        miSalir.setIcon(FontIcon.of(RemixiconAL.LOGOUT_BOX_LINE, 16, Color.decode("#FFFFFF")));
        miSalir.setText("Salir");
        menu.add(miSalir);

        menuBar.add(menu);

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
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfFiltrar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private List<Image> list;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JMenu menu;
    public JMenuBar menuBar;
    public JMenuItem miExportar;
    public JMenuItem miImportar;
    public JMenuItem miSalir;
    public JScrollPane scroll;
    public JTable table;
    public JTextField tfFiltrar;
    // End of variables declaration//GEN-END:variables
}
