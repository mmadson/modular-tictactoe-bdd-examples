package com.wwc.cleancode.bdd.tictactoe.serviceloader.impl;

import com.google.auto.service.AutoService;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGameBuilder;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGameFactory;

@AutoService(TicTacToeGameFactory.class)
public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {

	@Override
	public TicTacToeGameBuilder createNewGame() {
		return new TicTacToeGameBuilderImpl();
	}
}
