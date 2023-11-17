package com.anthonyponte.jbillconsult.controller;

import com.anthonyponte.jbillconsult.impl.BillValidServiceImpl;
import pe.gob.sunat.billvalidservice.BillValidService;

public class BillValidController {
  private BillValidService service;

  public BillValidController() {
    initComponents();
  }

  private void initComponents() {
    service = new BillValidServiceImpl();
  }
}
