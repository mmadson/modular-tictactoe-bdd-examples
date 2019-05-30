package com.wwc.cleancode.bdd.tictactoe.serviceloader.api;

public interface TicTacToeGame {

	GameState getState();

	void markSquare(Square squareToMark);
}
