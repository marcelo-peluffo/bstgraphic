package com.marcelo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Panel extends JPanel implements KeyListener {
    
    protected Panel() {
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(Config.PROMPT_FONT_OBJECT);
        g.drawString(Config.PROMPT, Config.PROMPT_X, Config.PROMPT_Y);
        g.drawString(Config.numberList.toString(), Config.NUMBER_LIST_X, Config.NUMBER_LIST_Y);

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int numberPressed = Character.getNumericValue(e.getKeyCode());
        Config.numberList.offer(numberPressed);

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
