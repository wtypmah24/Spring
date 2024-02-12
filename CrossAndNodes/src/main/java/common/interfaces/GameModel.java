package common.interfaces;

import common.dto.GameResult;
import common.dto.GameState;

public interface GameModel {
    GameState mark(int row, int column);
}