package com.sudoku.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class SudokuGUI extends JFrame {
    private final JTextField[][] cells;
    private JPanel[][] panels;
    private final JButton solveButton;

    public SudokuGUI() {
        setTitle("Sudoku Resolver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panels = new JPanel[3][3];
        cells = new JTextField[9][9];
        setLayout(new GridLayout(4, 3, 5, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JPanel panel = new JPanel(new GridLayout(3, 3));
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1)); // Frame
                panel.setBackground(new Color(141, 127, 127));
                panels[i][j] = panel;
                add(panel);
            }
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JTextField textField = new JTextField(1);
                textField.setHorizontalAlignment(JTextField.CENTER);
                cells[i][j] = textField;

                int panelRow = i / 3;
                int panelCol = j / 3;
                panels[panelRow][panelCol].add(textField);
            }
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        solveButton = new JButton("Solve");
        bottomPanel.add(solveButton);
        add(bottomPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public int[][] getInputGrid() {
        int[][] inputGrid = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String value = cells[i][j].getText();
                inputGrid[i][j] = value.isEmpty() ? 0 : Integer.parseInt(value);
            }
        }
        return inputGrid;
    }

    public void updateGridView(int[][] grid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j].setText(String.valueOf(grid[i][j]));
            }
        }
    }

    public void setSolveButtonListener(ActionListener listener) {
        solveButton.addActionListener(listener);
    }
}
