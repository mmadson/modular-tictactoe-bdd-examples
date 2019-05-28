package com.wwc.examples.tictactoebdd;

public interface TicTacToeGame {

	void mark(Square square);

	GameResult getResult();
}
