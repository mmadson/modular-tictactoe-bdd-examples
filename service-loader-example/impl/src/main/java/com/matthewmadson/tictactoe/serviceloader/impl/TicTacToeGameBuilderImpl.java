package com.matthewmadson.tictactoe.serviceloader.impl;

import com.matthewmadson.tictactoe.serviceloader.api.Symbol;
import com.matthewmadson.tictactoe.serviceloader.api.TicTacToeGame;
import com.matthewmadson.tictactoe.serviceloader.api.TicTacToeGameBuilder;

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
