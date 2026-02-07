package com.marcelo.core;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.RenderingHints;

public class GraphicBSTIntroPanel extends JPanel {
    
    public GraphicBSTIntroPanel() {
        setBackground(new Color(245, 245, 245));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        // Title
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.setColor(new Color(33, 33, 33));
        String title = "Marcelo's Binary Search Tree Visualizer";
        int titleWidth = g2d.getFontMetrics().stringWidth(title);
        g2d.drawString(title, (width - titleWidth) / 2, 60);
        
        // Keybinds title
        g2d.setFont(new Font("Arial", Font.BOLD, 30));
        g2d.setColor(new Color(50, 100, 150));
        String keybindsTitle = "Keybinds:";
        int keybindsTitleWidth = g2d.getFontMetrics().stringWidth(keybindsTitle);
        g2d.drawString(keybindsTitle, (width - keybindsTitleWidth) / 2, 175);
        
        // Keybinds
        g2d.setFont(new Font("Courier New", Font.PLAIN, 25));
        g2d.setColor(new Color(33, 33, 33));
        String[] keybinds = {
            "ENTER   -    ADD a new node to the tree",
            "DELETE  -    REMOVE a selected node from the tree",
            "TAB     -    UNDO the last operation"
        };
        
        int startX = (width - 600) / 2;
        int y = 300;
        for (String keybind : keybinds) {
            g2d.drawString(keybind, startX, y);
            y += 70;
        }
    }
}

