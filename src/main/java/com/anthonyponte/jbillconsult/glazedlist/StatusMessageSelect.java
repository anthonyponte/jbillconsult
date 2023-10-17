package com.anthonyponte.jbillconsult.glazedlist;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.UniqueList;
import ca.odell.glazedlists.matchers.AbstractMatcherEditor;
import ca.odell.glazedlists.matchers.Matcher;
import ca.odell.glazedlists.swing.AdvancedListSelectionModel;
import ca.odell.glazedlists.swing.DefaultEventListModel;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventListModelWithThreadProxyList;
import static ca.odell.glazedlists.swing.GlazedListsSwing.eventSelectionModelWithThreadProxyList;
import com.anthonyponte.jbillconsult.pojo.Bill;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StatusMessageSelect extends AbstractMatcherEditor<Bill>
        implements ListSelectionListener {

    private final JList list;
    private final EventList<Bill> billList;
    private EventList<String> statusList;
    private EventList<String> statusSelectedList;

    public StatusMessageSelect(JList list, EventList<Bill> billList) {
        this.list = list;
        this.billList = billList;
    }

    public void confJList() {
        EventList<String> usersNonUnique = new BillToStatusMessageList(billList);
        statusList = new UniqueList<>(usersNonUnique);

        DefaultEventListModel<String> model = eventListModelWithThreadProxyList(statusList);
        list.setModel(model);

        AdvancedListSelectionModel<String> selectionModel
                = eventSelectionModelWithThreadProxyList(statusList);
        list.setSelectionModel(selectionModel);
        statusSelectedList = selectionModel.getSelected();

        list.addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        Matcher<Bill> matcher = new BillForStatusMessageMatcher(statusSelectedList);
        fireChanged(matcher);
    }
}
