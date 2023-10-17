package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.TransformedList;
import ca.odell.glazedlists.event.ListEvent;
import com.anthonyponte.jbillconsult.pojo.Bill;

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
