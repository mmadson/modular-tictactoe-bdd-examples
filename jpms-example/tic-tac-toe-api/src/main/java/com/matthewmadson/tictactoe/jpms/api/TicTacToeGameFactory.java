package com.matthewmadson.tictactoe.jpms.api;

import java.util.ServiceLoader;

public interface TicTacToeGameFactory {

	TicTacToeGameFactory INSTANCE = ServiceLoader.load(TicTacToeGameFactory.class).findFirst().orElse(null);

	TicTacToeGameBuilder createNewGame();
}
