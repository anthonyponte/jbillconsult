package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.matchers.Matcher;
import com.anthonyponte.jbillconsult.pojo.Bill;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BillForStatusMessageMatcher implements Matcher<Bill> {

  private final Set<String> status = new HashSet<>();

  public BillForStatusMessageMatcher(Collection<String> status) {
    this.status.addAll(status);
  }

  @Override
  public boolean matches(Bill e) {
    if (e == null) return false;
    if (status.isEmpty()) return true;

    String user = e.getStatusMessage();
    return status.contains(user);
  }
}
