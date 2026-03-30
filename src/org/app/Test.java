package org.app;

import org.app.ui.AppFrame;

import javax.swing.*;

public class Test {

    void main() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AppFrame();
            }
        });
    }
}
