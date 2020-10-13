package com.matthewmadson.tictactoe.api;

public interface TicTacToeGame {

    Symbol getPlayerSymbol();

    Symbol getAiSymbol();

    String getGameBoard();

    void mark(Square squareToMark);

    GameState getGameState();
}
