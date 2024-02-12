package model;

import common.dto.CellState;
import common.dto.GameResult;
import common.dto.GameState;
import common.interfaces.GameModel;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class CrossAndNoughts implements GameModel {
    private final CellState[][] field;
    private GameResult gameResult;

    private boolean isX;

    public CrossAndNoughts() {
        this.isX = ThreadLocalRandom.current().nextBoolean();
        this.field = initField();
        this.gameResult = GameResult.UNDEFINED;
    }

    @Override
    public GameState mark(int row, int column) {

        if (row < 0 || row >= field.length || column < 0 || column >= field[0].length) return toGameState();

        if (field[row][column] != CellState.EMPTY) return toGameState();

        field[row][column] = isX ? CellState.X : CellState.O;
        isX = !isX;
        //TODO Сделать проверку окончания игры.
        return toGameState();
    }

    private GameState toGameState() {
        CellState[][] copy = new CellState[field.length][field[0].length];
        for (int i = 0; i < field.length; i++) {
            copy[i] = Arrays.copyOf(field[i], field[i].length);
        }

        return new GameState(copy, gameResult);
    }

    private CellState[][] initField() {
        CellState[][] field = new CellState[3][3];
        for (CellState[] cellStates : field) {
            Arrays.fill(cellStates, CellState.EMPTY);
        }
        return field;
    }
}