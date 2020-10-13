package com.matthewmadson.tictactoe.jpms.api;

public interface TicTacToeGameBuilder {

	TicTacToeGameBuilder playerSymbol(Symbol symbol);

	TicTacToeGame build();
}
