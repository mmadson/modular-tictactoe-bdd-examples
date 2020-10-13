package com.matthewmadson.tictactoe.spring.jgiven.tests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.matthewmadson.tictactoe.spring.jgiven.GameResult;
import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.Square;
import com.matthewmadson.tictactoe.spring.jgiven.TicTacToeGame;
import com.matthewmadson.tictactoe.spring.jgiven.TicTacToeGameFactory;

import javax.inject.Inject;
import java.util.List;

@JGivenStage
class WhenStage extends Stage<WhenStage> {

	@Inject
	private TicTacToeGameFactory gameFactory;

	@ExpectedScenarioState
	private Mark playersMark;

	@ProvidedScenarioState
	private GameResult gameResult;

	public WhenStage player_plays(final List<Square> playerMarkedSquares) {
		final TicTacToeGame game = gameFactory.createNewGame(playersMark);
		for (final Square square : playerMarkedSquares) {
			game.mark(square);
		}
		gameResult = game.getResult();
		return self();
	}
}
