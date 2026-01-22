package com.marcelo;

import javax.swing.JFrame;

public class Frame extends JFrame {

    protected Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Config.DEFAULT_WIDTH, Config.DEFAULT_HEIGHT);
        setTitle(Config.DEFAULT_WINDOW_NAME);
        setVisible(true);

        add(new Panel());
    }

}
