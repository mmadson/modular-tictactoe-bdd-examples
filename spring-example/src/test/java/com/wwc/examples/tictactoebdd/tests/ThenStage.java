package com.wwc.examples.tictactoebdd.tests;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import com.wwc.examples.tictactoebdd.GameResult;
import org.assertj.core.api.Assertions;

import java.util.Optional;

@JGivenStage
class ThenStage extends Stage<ThenStage> {

	@ExpectedScenarioState
	private Optional<GameResult> gameResult;

	public ThenStage game_result_is(final GameResult expectedGameResult) {
		Assertions.assertThat(Optional.ofNullable(expectedGameResult)).isEqualTo(gameResult);
		return self();
	}
}
