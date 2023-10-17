package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.TextFilterator;
import com.anthonyponte.jbillconsult.pojo.Bill;
import java.util.List;

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
