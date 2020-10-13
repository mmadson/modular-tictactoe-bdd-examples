package com.matthewmadson.tictactoe.spring.jgiven;

public interface TicTacToeGameFactory {

	TicTacToeGame createNewGame(Mark playersMark);
}
