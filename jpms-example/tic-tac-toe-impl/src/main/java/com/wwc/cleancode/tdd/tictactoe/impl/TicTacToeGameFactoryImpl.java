package com.wwc.cleancode.tdd.tictactoe.impl;

import com.wwc.cleancode.tdd.tictactoe.api.TicTacToeGame;
import com.wwc.cleancode.tdd.tictactoe.api.TicTacToeGameFactory;

public class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {
	@Override
	public TicTacToeGame newGame() {
		return new TicTacToeGameImpl();
	}
}
