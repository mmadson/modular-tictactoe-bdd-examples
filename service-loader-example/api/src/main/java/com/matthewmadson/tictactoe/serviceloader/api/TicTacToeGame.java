package com.matthewmadson.tictactoe.serviceloader.api;

public interface TicTacToeGame {

	GameState getState();

	void markSquare(Square squareToMark);
}
