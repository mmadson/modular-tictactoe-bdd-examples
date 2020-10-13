package com.matthewmadson.tictactoe.api;

public interface TicTacToeGameFactory {

    TicTacToeGame create(Symbol playerSymbol);
}
