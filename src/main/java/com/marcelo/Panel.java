package com.marcelo;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * The visual panel for the graphic BST.
 * @author Marcelo
 */
public class Panel extends JPanel implements KeyListener {
    /**
     * Default constructor that adds a key listener
     */
    protected Panel() {
        addKeyListener(this);
    }

    /**
     * Method to render updates to the graphical application
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(Config.PROMPT_FONT_OBJECT);
        g.drawString(Config.PROMPT, Config.PROMPT_X, Config.PROMPT_Y);
        g.drawString(Config.numberList.toString(), Config.NUMBER_LIST_X, Config.NUMBER_LIST_Y);


    }

    /**
     * Update number queue whenever the user inputs a key
     * @param e the event to be processed
     */
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
