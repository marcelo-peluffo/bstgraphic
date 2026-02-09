package com.marcelo.core;

import com.marcelo.ui.drawable.DrawableBinarySearchTree;
import com.marcelo.ui.drawable.DrawableTree;
import com.marcelo.ui.input.VisualComponent;
import com.marcelo.ui.input.button.AddButton;
import com.marcelo.ui.input.button.DeleteButton;
import com.marcelo.ui.input.button.UndoButton;
import com.marcelo.ui.input.textbox.Textbox;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The panel where the binary search tree is drawn.
 */
public class GraphicBSTPanel extends JPanel {
        private List<VisualComponent> visualComponents;
        private DrawableTree<Integer> drawableBST;
        private GraphicBSTFrame frame;
        private Rectangle backButtonBounds;
        private BufferedImage backgroundImage;

        public GraphicBSTPanel(GraphicBSTFrame frame) {
                this.frame = frame;
                drawableBST = new DrawableBinarySearchTree<>();
                loadBackgroundImage();
                initializeComponents();
                setupListeners();
                setupMouseListener();
        }

        private void setupMouseListener() {
                addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                if (backButtonBounds != null && backButtonBounds.contains(e.getPoint())) {
                                        frame.switchToPanel(frame.getBstIntroPanel());
                                }
                        }
                });
        }

        private void loadBackgroundImage() {
                try {
                        backgroundImage = ImageIO.read(getClass().getClassLoader()
                                        .getResourceAsStream("images/Background.jpg"));
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        private void initializeComponents() {
                visualComponents = new ArrayList<>();
                Textbox valueTextbox = new Textbox(10);
                visualComponents.add(valueTextbox);
                visualComponents.add(new AddButton(valueTextbox));
                visualComponents.add(new DeleteButton(valueTextbox));
                visualComponents.add(new UndoButton(valueTextbox));
        }

        private void setupListeners() {
                for (VisualComponent visualComponent : visualComponents) {
                        add(visualComponent.getComponent());
                        visualComponent.initializeListeners(this);
                }
        }

        public void insertValue(Integer value) {
                if (value == null) {
                        return;
                }
                drawableBST.insert(value);
                repaint();
        }

        public void deleteValue(Integer value) {
                if (value == null) {
                        return;
                }
                drawableBST.delete(value);
                repaint();
        }

        public void undoValue() {
                drawableBST.undo();
                repaint();
        }


        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                int width = getWidth();
                int height = getHeight();

                // Draw background image
                if (backgroundImage != null) {
                        g2d.drawImage(backgroundImage, 0, 0, width, height, this);
                }

                drawableBST.paintNodes(g);

                // Draw Back Button
                // int width = getWidth();
                // int height = getHeight();
                String buttonText = "Keybinds";
                g2d.setFont(new Font("Arial", Font.BOLD, 18));
                int buttonWidth = 100;
                int buttonHeight = 40;
                int buttonX = width - buttonWidth - 20;
                int buttonY = height - buttonHeight - 20;
                backButtonBounds = new Rectangle(buttonX, buttonY, buttonWidth, buttonHeight);

                // Draw button background
                g2d.setColor(new Color(50, 100, 150));
                g2d.fillRect(buttonX, buttonY, buttonWidth, buttonHeight);

                // Draw button border
                g2d.setColor(new Color(0, 0, 0));
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
