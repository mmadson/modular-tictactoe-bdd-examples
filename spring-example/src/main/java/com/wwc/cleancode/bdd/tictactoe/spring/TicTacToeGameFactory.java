package com.wwc.cleancode.bdd.tictactoe.spring;

public interface TicTacToeGameFactory {

	TicTacToeGame createNewGame(Mark playersMark);
}
