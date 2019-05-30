package com.wwc.cleancode.bdd.tictactoe.serviceloader.api;

import java.util.ServiceLoader;

public interface TicTacToeGameFactory {

	TicTacToeGameFactory INSTANCE = ServiceLoader.load(TicTacToeGameFactory.class).findFirst().get();

	TicTacToeGameBuilder createNewGame();
}
