package com.matthewmadson.tictactoe.jpms.tests;

import com.matthewmadson.tictactoe.jpms.api.GameState;
import com.matthewmadson.tictactoe.jpms.api.Square;
import com.matthewmadson.tictactoe.jpms.api.Symbol;
import com.matthewmadson.tictactoe.jpms.api.TicTacToeGame;
import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameFactory;
import com.matthewmadson.tictactoe.jpms.api.exceptions.GameAlreadyEndedException;
import com.matthewmadson.tictactoe.jpms.api.exceptions.SquareAlreadyTakenException;
import com.matthewmadson.tictactoe.jpms.api.ports.TicTacToeAi;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.matthewmadson.tictactoe.jpms.api.GameState.AI_HAS_WON;
import static com.matthewmadson.tictactoe.jpms.api.GameState.DRAW;
import static com.matthewmadson.tictactoe.jpms.api.GameState.IN_PROGRESS;
import static com.matthewmadson.tictactoe.jpms.api.GameState.PLAYER_HAS_WON;
import static com.matthewmadson.tictactoe.jpms.api.Square.BOTTOM_LEFT;
import static com.matthewmadson.tictactoe.jpms.api.Square.BOTTOM_MIDDLE;
import static com.matthewmadson.tictactoe.jpms.api.Square.BOTTOM_RIGHT;
import static com.matthewmadson.tictactoe.jpms.api.Square.CENTER_LEFT;
import static com.matthewmadson.tictactoe.jpms.api.Square.CENTER_MIDDLE;
import static com.matthewmadson.tictactoe.jpms.api.Square.CENTER_RIGHT;
import static com.matthewmadson.tictactoe.jpms.api.Square.TOP_LEFT;
import static com.matthewmadson.tictactoe.jpms.api.Square.TOP_MIDDLE;
import static com.matthewmadson.tictactoe.jpms.api.Square.TOP_RIGHT;
import static com.matthewmadson.tictactoe.jpms.api.Symbol.O;
import static com.matthewmadson.tictactoe.jpms.api.Symbol.X;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitTests {

	private static Stream<Arguments> testCases() {
		return Stream.of(
				Arguments.of(X, List.of(TOP_RIGHT), List.of(TOP_LEFT), IN_PROGRESS),
				Arguments.of(X, List.of(TOP_RIGHT, CENTER_RIGHT), List.of(TOP_LEFT, CENTER_LEFT, BOTTOM_LEFT), PLAYER_HAS_WON),
				Arguments.of(O, List.of(TOP_RIGHT, CENTER_RIGHT, BOTTOM_RIGHT), List.of(TOP_LEFT, CENTER_LEFT), AI_HAS_WON),
				Arguments.of(X, List.of(TOP_MIDDLE, BOTTOM_LEFT, CENTER_RIGHT, BOTTOM_RIGHT), List.of(TOP_LEFT, CENTER_LEFT, CENTER_MIDDLE, BOTTOM_MIDDLE, TOP_RIGHT), DRAW)
		);
	}

	@ParameterizedTest
	@MethodSource("testCases")
	void testTicTacToeGame(Symbol playerSymbol, List<Square> aiMarkSequence, List<Square> playerMarkSequence, GameState expectedGameState) throws SquareAlreadyTakenException, GameAlreadyEndedException {
		givenPlayerSymbolIs(playerSymbol);
		givenAiMarkSequence(aiMarkSequence);

		whenPlayerMarks(playerMarkSequence);

		thenGameStateIs(expectedGameState);
	}


	private Symbol playerSymbol;
	private TicTacToeGame game;

	private void givenPlayerSymbolIs(Symbol playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	private void givenAiMarkSequence(final List<Square> squares) {
		((MockTicTacToeAi) TicTacToeAi.INSTANCE).setMoveSequence(squares);
	}

	private void whenPlayerMarks(final List<Square> squares) throws SquareAlreadyTakenException, GameAlreadyEndedException {
		game = TicTacToeGameFactory.INSTANCE.createNewGame().playerSymbol(this.playerSymbol).build();
		for (final Square square : squares) {
			game.markSquare(square);
		}
	}

	private void thenGameStateIs(final GameState expectedGameState) {
		assertEquals(expectedGameState, game.getState());
	}

}
