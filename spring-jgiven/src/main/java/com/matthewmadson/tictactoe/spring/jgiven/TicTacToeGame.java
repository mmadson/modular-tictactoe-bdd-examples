package com.matthewmadson.tictactoe.spring.jgiven;

public interface TicTacToeGame {

	void mark(Square square);

	GameResult getResult();
}
