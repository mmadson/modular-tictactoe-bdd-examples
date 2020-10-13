package com.matthewmadson.tictactoe.serviceloader.api;

public interface TicTacToeGameBuilder {

	TicTacToeGameBuilder playerSymbol(Symbol playerSymbol);

	TicTacToeGame build();
}
