package com.anthonyponte.jbillconsultservice.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

public class UserFrame extends javax.swing.JFrame {

    public UserFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUsername = new JTextField();
        tfPassword = new JPasswordField();
        btnLogIn = new JButton();
        cbRemember = new JCheckBox();
        tfRuc = new JFormattedTextField();
        lblRuc = new JLabel();
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        jSeparator1 = new JSeparator();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clave SOL");
        setResizable(false);

        tfUsername.setPreferredSize(new Dimension(150, 30));
        tfUsername.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                tfUsernameKeyTyped(evt);
            }
        });

        tfPassword.setPreferredSize(new Dimension(150, 30));

        btnLogIn.setText("Entrar");
        btnLogIn.setEnabled(false);
        btnLogIn.setMaximumSize(new Dimension(100, 25));
        btnLogIn.setMinimumSize(new Dimension(100, 25));
        btnLogIn.setPreferredSize(new Dimension(100, 25));

        cbRemember.setText("Recordar");

        try {
            tfRuc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###########")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        tfRuc.setPreferredSize(new Dimension(150, 30));

        lblRuc.setFont(lblRuc.getFont().deriveFont(lblRuc.getFont().getStyle() | Font.BOLD, lblRuc.getFont().getSize()-2));
        lblRuc.setText("RUC");
        lblRuc.setRequestFocusEnabled(false);

        lblUsername.setFont(lblUsername.getFont().deriveFont(lblUsername.getFont().getStyle() | Font.BOLD, lblUsername.getFont().getSize()-2));
        lblUsername.setText("Usuario");
        lblUsername.setRequestFocusEnabled(false);

        lblPassword.setFont(lblPassword.getFont().deriveFont(lblPassword.getFont().getStyle() | Font.BOLD, lblPassword.getFont().getSize()-2));
        lblPassword.setText("Contraseña");
        lblPassword.setRequestFocusEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tfPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfRuc, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRuc)
                    .addComponent(lblUsername)
                    .addComponent(lblPassword)
                    .addComponent(cbRemember)
                    .addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRuc)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRuc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsername)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRemember)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfUsernameKeyTyped(KeyEvent evt) {//GEN-FIRST:event_tfUsernameKeyTyped
        char keyChar = evt.getKeyChar();
        if (Character.isLowerCase(keyChar)) {
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_tfUsernameKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton btnLogIn;
    public JCheckBox cbRemember;
    public JSeparator jSeparator1;
    public JLabel lblPassword;
    public JLabel lblRuc;
    public JLabel lblUsername;
    public JPasswordField tfPassword;
    public JFormattedTextField tfRuc;
    public JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
