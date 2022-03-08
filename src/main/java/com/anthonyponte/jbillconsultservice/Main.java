package com.anthonyponte.jbillconsultservice;

import com.anthonyponte.jbillconsultservice.controller.UserController;
import com.anthonyponte.jbillconsultservice.view.UserFrame;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(
        () -> {
          FlatDarkLaf.setup();
          UserFrame userFrame = new UserFrame();
          new UserController(userFrame).start();
        });
  }
}
