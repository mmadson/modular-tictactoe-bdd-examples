package com.wwc.cleancode.bdd.tictactoe.spring.tests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.wwc.cleancode.bdd.tictactoe.spring.GameResult;
import org.assertj.core.api.Assertions;

@JGivenStage
class ThenStage extends Stage<ThenStage> {

	@ExpectedScenarioState
	private GameResult gameResult;

	public ThenStage game_result_is(final GameResult expectedGameResult) {
		Assertions.assertThat(expectedGameResult).isEqualTo(gameResult);
		return self();
	}
}
