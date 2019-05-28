package com.wwc.cleancode.bdd.tictactoe.spring.tests;

import com.google.common.collect.Lists;
import com.wwc.cleancode.bdd.tictactoe.spring.GameResult;
import com.wwc.cleancode.bdd.tictactoe.spring.Mark;
import com.wwc.cleancode.bdd.tictactoe.spring.Square;

import java.util.List;

public class TestCase {

	private final Mark playerMark;
	private final List<Square> aiPlaysList;
	private final List<Square> playerPlaysList;
	private final GameResult expectedResult;

	private TestCase(
			final Mark playerMark,
			final List<Square> aiPlaysList,
			final List<Square> playerPlaysList,
			final GameResult expectedResult
	) {
		this.playerMark = playerMark;
		this.aiPlaysList = aiPlaysList;
		this.playerPlaysList = playerPlaysList;
		this.expectedResult = expectedResult;
	}

	public static TestCase.Builder create() {
		return new TestCase.Builder();
	}

	public Mark getPlayerMark() {
		return playerMark;
	}

	public List<Square> getAiPlaysList() {
		return aiPlaysList;
	}

	public List<Square> getPlayerPlaysList() {
		return playerPlaysList;
	}

	public GameResult getExpectedResult() {
		return expectedResult;
	}

	public static class Builder {

		private Mark playerMark;
		private List<Square> aiPlaysList;
		private List<Square> playerPlaysList;
		private GameResult expectedResult;

		public Builder playerMark(final Mark playerMark) {
			this.playerMark = playerMark;
			return this;
		}

		public Builder aiPlays(final Square... aiPlays) {
			aiPlaysList = Lists.newArrayList(aiPlays);
			return this;
		}

		public Builder playerPlays(final Square... playerPlays) {
			playerPlaysList = Lists.newArrayList(playerPlays);
			return this;
		}

		public Builder expectedResult(final GameResult expectedResult) {
			this.expectedResult = expectedResult;
			return this;
		}

		public TestCase build() {
			return new TestCase(playerMark, aiPlaysList, playerPlaysList, expectedResult);
		}
	}
}
