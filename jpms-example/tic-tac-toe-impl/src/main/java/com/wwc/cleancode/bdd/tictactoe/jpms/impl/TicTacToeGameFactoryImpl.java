package com.wwc.cleancode.bdd.tictactoe.jpms.impl;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;

public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {
	@Override
	public TicTacToeGame newGame() {
		return new TicTacToeGameImpl();
	}
}
