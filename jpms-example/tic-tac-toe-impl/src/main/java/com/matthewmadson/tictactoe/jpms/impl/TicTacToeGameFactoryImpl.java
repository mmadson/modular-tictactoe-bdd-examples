package com.matthewmadson.tictactoe.jpms.impl;

import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameBuilder;
import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameFactory;

public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {
	@Override
	public TicTacToeGameBuilder createNewGame() {
		return new TicTacToeGameBuilderImpl();
	}
}
