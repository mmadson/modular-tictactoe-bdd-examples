package com.wwc.cleancode.bdd.tictactoe.jpms.api;

import java.util.ServiceLoader;

public interface TicTacToeGameFactory {

	static TicTacToeGameFactory create() throws NoImplementationFoundException {
		return ServiceLoader.load(TicTacToeGameFactory.class).findFirst().orElseThrow(NoImplementationFoundException::new);
	}

	TicTacToeGame newGame();
}
