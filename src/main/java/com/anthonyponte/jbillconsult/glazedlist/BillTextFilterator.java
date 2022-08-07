/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.TextFilterator;
import com.anthonyponte.jbillconsult.pojo.Bill;
import java.util.List;

/**
 * @author Anthony Ponte
 */
public class BillTextFilterator implements TextFilterator<Bill> {

  @Override
  public void getFilterStrings(List<String> list, Bill e) {
    list.add(e.getRuc());
    list.add(e.getTipo());
    list.add(e.getSerie());
    list.add(String.valueOf(e.getCorrelativo()));
    list.add(e.getStatusCode());
    list.add(e.getStatusMessage());
  }
}
