package com.wwc.cleancode.bdd.tictactoe.jpms.api;

public interface TicTacToeGameBuilder {

	TicTacToeGameBuilder playerSymbol(Symbol symbol);

	TicTacToeGame build();
}
