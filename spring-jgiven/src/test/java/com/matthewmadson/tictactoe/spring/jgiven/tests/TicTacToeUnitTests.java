package com.matthewmadson.tictactoe.spring.jgiven.tests;

import com.tngtech.jgiven.integration.spring.EnableJGiven;
import com.tngtech.jgiven.integration.spring.SpringRuleScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.Collection;

import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.AI_WINS;
import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.DRAW;
import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.PLAYER_WINS;
import static com.matthewmadson.tictactoe.spring.jgiven.Mark.O;
import static com.matthewmadson.tictactoe.spring.jgiven.Mark.X;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_RIGHT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_RIGHT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_RIGHT;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
@ContextConfiguration(classes = { TicTacToeUnitTests.Config.class })
public class TicTacToeUnitTests extends SpringRuleScenarioTest<GivenStage, WhenStage, ThenStage> {

	@EnableJGiven
	@ComponentScan(basePackages = { 
		"com.matthewmadson.tictactoe.spring.impl",
		"com.matthewmadson.tictactoe.spring.tests"
	})
	public static final class Config {

	}

	@Parameters(name = "Test Case {index}: {0}")
	public static Collection<Object[]> testCases() {
		return Arrays.asList(new Object[][] {
				{
					"When player plays left column, then player wins",
					TestCase.create()
						.playerMark(X)
						.aiPlays(TOP_CENTER, BOTTOM_RIGHT, TOP_RIGHT, MIDDLE_RIGHT)
						.playerPlays(TOP_LEFT, MIDDLE_CENTER, BOTTOM_LEFT, MIDDLE_LEFT)
						.expectedResult(PLAYER_WINS)
						.build()
				},
				{
					"When player plays top row, then player wins",
					TestCase.create()
						.playerMark(X)
						.aiPlays(MIDDLE_LEFT, MIDDLE_CENTER)
						.playerPlays(TOP_LEFT, TOP_CENTER, TOP_RIGHT)
						.expectedResult(PLAYER_WINS)
						.build()
				},
				{
					"When ai plays left to right diagonal, then ai wins",
					TestCase.create()
						.playerMark(X)
						.aiPlays(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT)
						.playerPlays(TOP_RIGHT, BOTTOM_LEFT, MIDDLE_LEFT)
						.expectedResult(AI_WINS)
						.build()
				},
				{
						"When board is full and no winner, then draw",
						TestCase.create()
								.playerMark(O)
								.aiPlays(TOP_LEFT, MIDDLE_CENTER, BOTTOM_CENTER, MIDDLE_LEFT, TOP_RIGHT)
								.playerPlays(BOTTOM_RIGHT, BOTTOM_LEFT, TOP_CENTER, MIDDLE_RIGHT)
								.expectedResult(DRAW)
								.build()
				},
		});
	}

	@Parameter(value = 0)
	public String description;

	@Parameter(value = 1)
	public TestCase testCase;

	@Test
	public void testTicTacToe() {
		given()
			.player_mark_is(testCase.getPlayerMark())
			.and()
			.ai_plays(testCase.getAiPlaysList());

		when()
			.player_plays(testCase.getPlayerPlaysList());

		then()
			.game_result_is(testCase.getExpectedResult());
	}
}
