package com.matthewmadson.tictactoe.spring.jgiven.impl;

import com.matthewmadson.tictactoe.spring.jgiven.ports.TicTacToeAi;
import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.TicTacToeGame;
import com.matthewmadson.tictactoe.spring.jgiven.TicTacToeGameFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
final class TicTacToeGameFactoryImpl implements TicTacToeGameFactory {

	private final TicTacToeAi ai;

	@Inject
	TicTacToeGameFactoryImpl(final TicTacToeAi ai) {
		this.ai = ai;
	}

	@Override
	public TicTacToeGame createNewGame(final Mark playersMark) {
		return new TicTacToeGameImpl(ai, playersMark);
	}
}
