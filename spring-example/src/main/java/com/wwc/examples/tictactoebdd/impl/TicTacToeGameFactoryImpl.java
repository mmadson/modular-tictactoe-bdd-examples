package com.wwc.examples.tictactoebdd.impl;

import com.wwc.examples.tictactoebdd.Mark;
import com.wwc.examples.tictactoebdd.TicTacToeGame;
import com.wwc.examples.tictactoebdd.TicTacToeGameFactory;
import com.wwc.examples.tictactoebdd.ports.TicTacToeAi;
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
