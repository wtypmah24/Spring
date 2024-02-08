package com.sudoku.controler;

import com.sudoku.model.SudokuResolver;
import com.sudoku.view.SudokuGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SudokuController {
    private final SudokuResolver resolver;
    private final SudokuGUI view;

    @Autowired
    public SudokuController(SudokuResolver resolver, SudokuGUI view) {
        this.resolver = resolver;
        this.view = view;
        this.view.setSolveButtonListener(e -> solveSudoku());
    }

    public void solveSudoku() {
        int[][] inputGrid = view.getInputGrid();
        int[][] solvedGrid = resolver.solveSudoku(inputGrid);
        view.updateGridView(solvedGrid);
    }
}
