package com.wwc.cleancode.bdd.tictactoe.jpms.impl;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.Symbol;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameBuilder;

public class TicTacToeGameBuilderImpl implements TicTacToeGameBuilder {
	private Symbol playerSymbol;

	@Override
	public TicTacToeGameBuilder playerSymbol(final Symbol symbol) {
		this.playerSymbol = symbol;
		return this;
	}

	@Override
	public TicTacToeGame build() {
		return new TicTacToeGameImpl(playerSymbol);
	}
}
