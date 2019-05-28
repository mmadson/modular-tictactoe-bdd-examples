package com.wwc.examples.tictactoebdd.tests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.wwc.examples.tictactoebdd.GameResult;
import com.wwc.examples.tictactoebdd.Mark;
import com.wwc.examples.tictactoebdd.Square;
import com.wwc.examples.tictactoebdd.TicTacToeGame;
import com.wwc.examples.tictactoebdd.TicTacToeGameFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@JGivenStage
class WhenStage extends Stage<WhenStage> {

	@Inject
	private TicTacToeGameFactory gameFactory;

	@ExpectedScenarioState
	private Mark playersMark;

	@ProvidedScenarioState
	private Optional<GameResult> gameResult;

	public WhenStage player_plays(final List<Square> playerMarkedSquares) {
		final TicTacToeGame game = gameFactory.createNewGame(playersMark);
		for (final Square square : playerMarkedSquares) {
			game.mark(square);
		}
		gameResult = game.getResult();
		return self();
	}
}
