package com.matthewmadson.tictactoe.spring.jgiven.tests;

import com.matthewmadson.tictactoe.spring.jgiven.ports.TicTacToeAi;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.Square;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@JGivenStage
class GivenStage extends Stage<GivenStage> {

	@MockBean
	private TicTacToeAi ticTacToeAi;

	@ProvidedScenarioState
	private Mark playersMark;

	public GivenStage player_mark_is(final Mark playersMark) {
		this.playersMark = playersMark;
		return self();
	}

	public GivenStage ai_plays(final List<Square> aiMarkedSquares) {
		OngoingStubbing<Square> stubbing = Mockito.when(ticTacToeAi.determineNextMove(ArgumentMatchers.anyMap(), ArgumentMatchers.any(Mark.class)));
		for (final Square square : aiMarkedSquares) {
			stubbing = stubbing.thenReturn(square);
		}
		return self();
	}
}
