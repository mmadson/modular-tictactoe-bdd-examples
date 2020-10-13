package com.matthewmadson.tictactoe.adapter;

import com.matthewmadson.tictactoe.api.Square;
import com.matthewmadson.tictactoe.ports.TicTacToeAi;
import java.util.Random;

public class RealTicTacToeAi implements TicTacToeAi {

    @Override
    public Square getNextSquareToMark() {
        return Square.values()[new Random().nextInt(Square.values().length)];
    }
}
