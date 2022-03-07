package com.anthonyponte.jbillconsultservice.controller;

import com.anthonyponte.jbillconsultservice.pojo.User;
import com.anthonyponte.jbillconsultservice.view.BillFrame;
import com.anthonyponte.jbillconsultservice.view.UserFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class UserController {

  private final UserFrame frame;
  private final Preferences prefs;
  private final String TAG_RUC = "RUC";
  private final String TAG_USERNAME = "USERNAME";

  public UserController(UserFrame frame) {
    this.frame = frame;
    this.prefs = Preferences.userRoot().node(this.getClass().getName());
    this.prefs.get(TAG_RUC, "");
    this.prefs.get(TAG_USERNAME, "");
    init();
  }

  public void start() {
    frame.tfRuc.getDocument().addDocumentListener(dl);
    frame.tfUsername.getDocument().addDocumentListener(dl);
    frame.tfPassword.getDocument().addDocumentListener(dl);

    frame.btnLogIn.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent arg0) {
            try {
              User user = User.getInstance();
              user.setRuc(frame.tfRuc.getText());
              user.setUsername(frame.tfUsername.getText());
              user.setPassword(String.valueOf(frame.tfPassword.getPassword()));

              if (frame.cbRemember.isSelected()) {
                prefs.put(TAG_RUC, frame.tfRuc.getText());
                prefs.put(TAG_USERNAME, frame.tfUsername.getText());
              } else {
                prefs.clear();
              }

              frame.dispose();

              SwingUtilities.invokeLater(
                  () -> {
                    BillFrame billFrame = new BillFrame();
                    new BillController(billFrame).start();
                  });
            } catch (BackingStoreException ex) {
              Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        });
  }

  private void init() {
    frame.setVisible(true);

    String ruc = prefs.get(TAG_RUC, "");
    String username = prefs.get(TAG_USERNAME, "");
    if (!ruc.isEmpty() && !username.isEmpty()) {
      frame.tfRuc.setText(ruc);
      frame.tfUsername.setText(username);
      frame.tfPassword.requestFocus();
      frame.cbRemember.setSelected(true);
    } else {
      frame.tfRuc.requestFocus();
      frame.cbRemember.setSelected(false);
    }
  }

  private final DocumentListener dl =
      new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent arg0) {
          enableBtnLogIn();
        }

        @Override
        public void removeUpdate(DocumentEvent arg0) {
          enableBtnLogIn();
        }

        @Override
        public void changedUpdate(DocumentEvent arg0) {
          enableBtnLogIn();
        }
      };

  private void enableBtnLogIn() {
    if (frame.tfRuc.getText().length() < 11
        || frame.tfUsername.getText().length() < 7
        || frame.tfPassword.getPassword().length < 7) {
      frame.btnLogIn.setEnabled(false);
    } else {
      frame.btnLogIn.setEnabled(true);
    }
  }
}
