package com.wwc.cleancode.bdd.tictactoe.serviceloader.tests;

import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.GameState;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.Square;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.Symbol;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.TicTacToeGameFactory;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.ports.TicTacToeAi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TicTacToeGameUnitTests {

	static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of(
					"when_create_new_game_game_state_is_in_progress_and_board_empty",
					Symbol.X,
					List.of(),
					List.of(),
					"- - -"+"\n"+
					"- - -"+"\n"+
					"- - -",
					GameState.IN_PROGRESS
				),
				Arguments.of(
					"when_player_marks_square_then_board_not_empty_and_game_in_progress",
					Symbol.X,
					List.of(Square.TOP_MIDDLE),
					List.of(Square.TOP_LEFT),
					"X O -"+"\n"+
					"- - -"+"\n"+
					"- - -",
					GameState.IN_PROGRESS
				),
				Arguments.of(
					"when_create_new_game_and_ai_is_x_game_state_is_in_progress_and_board_not_empty",
					Symbol.O,
					List.of(Square.TOP_MIDDLE),
					List.of(),
					"- X -"+"\n"+
					"- - -"+"\n"+
					"- - -",
					GameState.IN_PROGRESS
				),
				Arguments.of(
					"when_player_wins_game_state_is_player_won",
					Symbol.X,
					List.of(Square.TOP_MIDDLE, Square.CENTER_MIDDLE),
					List.of(Square.TOP_LEFT, Square.CENTER_LEFT, Square.BOTTOM_LEFT),
					"X O -"+"\n"+
					"X O -"+"\n"+
					"X - -",
					GameState.PLAYER_HAS_WON
				),
				Arguments.of(
					"when_ai_wins_game_state_is_ai_won",
					Symbol.X,
					List.of(Square.TOP_MIDDLE, Square.CENTER_MIDDLE, Square.BOTTOM_MIDDLE),
					List.of(Square.TOP_LEFT, Square.CENTER_LEFT, Square.BOTTOM_RIGHT),
					"X O -"+"\n"+
					"X O -"+"\n"+
					"- O X",
					GameState.AI_HAS_WON
				),
				Arguments.of(
					"when_board_is_full_and_no_winners_game_state_is_draw",
					Symbol.X,
					List.of(Square.TOP_MIDDLE, Square.CENTER_MIDDLE, Square.BOTTOM_LEFT, Square.CENTER_RIGHT),
					List.of(Square.TOP_LEFT, Square.CENTER_LEFT, Square.BOTTOM_MIDDLE, Square.TOP_RIGHT, Square.BOTTOM_RIGHT),
					"X O X"+"\n"+
					"X O O"+"\n"+
					"O X X",
					GameState.DRAW
				),
				Arguments.of(
					"when_board_is_full_and_no_winners_game_state_is_draw",
					Symbol.X,
					List.of(Square.TOP_MIDDLE, Square.CENTER_MIDDLE, Square.BOTTOM_LEFT, Square.CENTER_RIGHT),
					List.of(Square.TOP_LEFT, Square.CENTER_LEFT, Square.BOTTOM_MIDDLE, Square.TOP_RIGHT, Square.BOTTOM_RIGHT),
					"X O X"+"\n"+
					"X O O"+"\n"+
					"O X X",
					GameState.DRAW
				)
		);
	}

	@ParameterizedTest(name = "[{index}]: {0}")
	@MethodSource("testCases")
	void testTicTacToe(String testCaseDescription, Symbol playerSymbol, List<Square> aiMoveSequence, List<Square> squaresToMark, String expectedBoard, GameState expectedGameState) {
		givenPlayerSymbolIs(playerSymbol);
		givenAiMoveSequence(aiMoveSequence);

		whenCreateGame();
		whenPlayerMarks(squaresToMark);

		thenBoardMatches(expectedBoard);
		thenGameStateIs(expectedGameState);
	}

	private TicTacToeGame game;
	private Symbol playerSymbol;

	private void whenPlayerMarks(List<Square> squares) {
		for (Square square : squares) {
			game.markSquare(square);
		}
	}

	private void whenCreateGame() {
		game = TicTacToeGameFactory.INSTANCE.createNewGame()
				.playerSymbol(this.playerSymbol)
				.build();
	}

	private void givenAiMoveSequence(List<Square> squares) {
		((MockTicTacToeAi) TicTacToeAi.INSTANCE).setMoveSequence(squares);
	}

	private void thenBoardMatches(final String expectedBoard) {
		Assertions.assertEquals(expectedBoard, game.toString());
	}

	private void givenPlayerSymbolIs(Symbol playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	private void thenGameStateIs(final GameState expectedGameState) {
		Assertions.assertEquals(expectedGameState, game.getState());
	}
}
