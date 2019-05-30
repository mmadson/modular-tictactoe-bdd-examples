package com.wwc.cleancode.bdd.tictactoe.serviceloader.api;

public interface TicTacToeGameBuilder {

	TicTacToeGameBuilder playerSymbol(Symbol playerSymbol);

	TicTacToeGame build();
}
