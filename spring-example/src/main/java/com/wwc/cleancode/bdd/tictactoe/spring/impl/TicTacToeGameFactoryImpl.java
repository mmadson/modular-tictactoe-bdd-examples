package com.wwc.cleancode.bdd.tictactoe.spring.impl;

import com.wwc.cleancode.bdd.tictactoe.spring.Mark;
import com.wwc.cleancode.bdd.tictactoe.spring.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.spring.TicTacToeGameFactory;
import com.wwc.cleancode.bdd.tictactoe.spring.ports.TicTacToeAi;
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
