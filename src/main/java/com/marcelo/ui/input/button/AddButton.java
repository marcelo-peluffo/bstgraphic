package com.marcelo.ui.input.button;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import java.awt.event.*;

import com.marcelo.core.GraphicBSTPanel;

public class AddButton extends JComponent {
        private JButton addValueButton;
        private String buttonText;

        public AddButton() {
                buttonText = "Add";
                addValueButton = new JButton(buttonText);
        }

        private void initializeButtonListener() {
                addValueButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                });
        }
}
