/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.anthonyponte.jbillconsult.custom;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import com.anthonyponte.jbillconsult.pojo.Bill;

/**
 * @author Anthony <rosembergponte@proton.me>
 */
public class BillToStatusMessageList extends TransformedList<Bill, String> {

  public BillToStatusMessageList(EventList<Bill> source) {
    super(source);
    source.addListEventListener(this);
  }

  @Override
  public String get(int index) {
    Bill bill = source.get(index);
    return bill.getStatusMessage();
  }

  @Override
  protected boolean isWritable() {
    return false;
  }

  @Override
  public void listChanged(ListEvent<Bill> le) {
    updates.forwardEvent(le);
  }
}
