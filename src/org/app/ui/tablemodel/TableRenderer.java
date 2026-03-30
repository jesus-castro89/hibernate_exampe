package org.app.ui.tablemodel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Border bevelBorder = UIManager.getBorder("TableHeader.cellBorder");
        Border emptyBorder = new EmptyBorder(10, 10, 10, 10);
        Border lineBorder;
        if (isSelected) {
            super.setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
            lineBorder = new LineBorder(table.getSelectionBackground().darker(), 2);
        } else {
            super.setForeground(table.getForeground());
            super.setBackground(table.getBackground());
            lineBorder = new LineBorder(table.getBackground().darker(), 1);
        }
        setBorder(new CompoundBorder(bevelBorder, new CompoundBorder(lineBorder, emptyBorder)));
        return this;
    }
}
