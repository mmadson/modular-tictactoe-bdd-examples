package com.wwc.cleancode.bdd.tictactoe.jpms.impl;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameBuilder;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;

public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {
	@Override
	public TicTacToeGameBuilder createNewGame() {
		return new TicTacToeGameBuilderImpl();
	}
}
