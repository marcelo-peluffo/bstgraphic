package com.marcelo.core;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GraphicBSTIntroPanel extends JPanel {

        private BufferedImage backgroundImage;
        private GraphicBSTFrame frame;
        private Rectangle buttonBounds;

        public GraphicBSTIntroPanel(GraphicBSTFrame frame) {
                this.frame = frame;
                setBackground(new Color(245, 245, 245));
                loadBackgroundImage();
                setupMouseListener();
        }

        private void setupMouseListener() {
                addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (buttonBounds != null && buttonBounds.contains(e.getPoint())) {
                                        frame.switchToPanel(new GraphicBSTPanel());
                                }
                        }
                });
        }

        private void loadBackgroundImage() {
                try {
                        backgroundImage = ImageIO.read(getClass().getClassLoader()
                                        .getResource("images/Background.jpg"));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                int width = getWidth();
                int height = getHeight();

                // Draw background image
                if (backgroundImage != null) {
                        g2d.drawImage(backgroundImage, 0, 0, width, height, this);
                }

                // Title
                g2d.setFont(new Font("Arial", Font.BOLD, 50));
                g2d.setColor(new Color(255, 255, 255));
                String title = "Marcelo's Binary Search Tree Visualizer";
                int titleWidth = g2d.getFontMetrics().stringWidth(title);
                g2d.drawString(title, (width - titleWidth) / 2, 60);

                // Keybinds title
                g2d.setFont(new Font("Arial", Font.BOLD, 30));
                g2d.setColor(new Color(255, 255, 255));
                String keybindsTitle = "Keybinds:";
                int keybindsTitleWidth = g2d.getFontMetrics().stringWidth(keybindsTitle);
                g2d.drawString(keybindsTitle, (width - keybindsTitleWidth) / 2, 175);

                // Keybinds
                g2d.setFont(new Font("Courier New", Font.PLAIN, 25));
                g2d.setColor(new Color(255, 255, 255));
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

                // Draw Start Button
                String buttonText = "Start";
                g2d.setFont(new Font("Arial", Font.BOLD, 24));
                int buttonWidth = 150;
                int buttonHeight = 50;
                int buttonX = (width - buttonWidth) / 2;
                int buttonY = 650;
                buttonBounds = new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight);

                // Draw button background
                g2d.setColor(new Color(50, 100, 150));
                g2d.fillRect(buttonX, buttonY, buttonWidth, buttonHeight);

                // Draw button border
                g2d.setColor(new Color(255, 255, 255));
                g2d.setStroke(new java.awt.BasicStroke(2));
                g2d.drawRect(buttonX, buttonY, buttonWidth, buttonHeight);

                // Draw button text
                int textWidth = g2d.getFontMetrics().stringWidth(buttonText);
                int textHeight = g2d.getFontMetrics().getAscent();
                g2d.setColor(new Color(255, 255, 255));
                g2d.drawString(buttonText, buttonX + (buttonWidth - textWidth) / 2,
                                buttonY + (buttonHeight + textHeight) / 2);
        }
}
