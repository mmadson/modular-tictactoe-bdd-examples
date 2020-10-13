package com.matthewmadson.tictactoe.serviceloader.impl;

import com.google.auto.service.AutoService;
import com.matthewmadson.tictactoe.serviceloader.api.TicTacToeGameBuilder;
import com.matthewmadson.tictactoe.serviceloader.api.TicTacToeGameFactory;

@AutoService(TicTacToeGameFactory.class)
public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {

	@Override
	public TicTacToeGameBuilder createNewGame() {
		return new TicTacToeGameBuilderImpl();
	}
}
