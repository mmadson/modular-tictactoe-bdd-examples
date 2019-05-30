package com.wwc.cleancode.bdd.tictactoe.serviceloader.impl;

import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.Symbol;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGameBuilder;

public class TicTacToeGameBuilderImpl implements TicTacToeGameBuilder {

	private Symbol playerSymbol;

	@Override
	public TicTacToeGameBuilder playerSymbol(final Symbol playerSymbol) {
		this.playerSymbol = playerSymbol;
		return this;
	}

	@Override
	public TicTacToeGame build() {
		return new TicTacToeGameImpl(playerSymbol);
	}
}
