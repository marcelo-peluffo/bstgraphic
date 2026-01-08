package com.marcelo;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel extends JPanel {
    
    protected Panel() {
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(Config.PROMPT_FONT_OBJECT);
        g.drawString(Config.PROMPT, Config.PROMPT_X, Config.PROMPT_Y);
        
    }
}
