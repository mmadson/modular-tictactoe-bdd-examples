package com.wwc.cleancode.bdd.tictactoe.spring;

public interface TicTacToeGame {

	void mark(Square square);

	GameResult getResult();
}
