package org.app.ui.theme.components;

import org.app.ui.tablemodel.TableRenderer;

import javax.swing.*;
import javax.swing.table.TableModel;

public class ThemeTable extends JTable {

    public ThemeTable(TableModel tableModel) {
        super(tableModel);
        setDefaultRenderer(Object.class, new TableRenderer());
        setRowHeight(40);
        setColumnSelectionAllowed(false);
        setDragEnabled(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        getTableHeader().setReorderingAllowed(false);
    }
}
