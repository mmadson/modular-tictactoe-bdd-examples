package com.matthewmadson.tictactoe.spring.jgiven.impl;

import com.matthewmadson.tictactoe.spring.jgiven.ports.TicTacToeAi;
import com.matthewmadson.tictactoe.spring.jgiven.GameResult;
import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.Square;
import com.matthewmadson.tictactoe.spring.jgiven.TicTacToeGame;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.AI_WINS;
import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.DRAW;
import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.IN_PROGRESS;
import static com.matthewmadson.tictactoe.spring.jgiven.GameResult.PLAYER_WINS;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.BOTTOM_RIGHT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.MIDDLE_RIGHT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_CENTER;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_LEFT;
import static com.matthewmadson.tictactoe.spring.jgiven.Square.TOP_RIGHT;

final class TicTacToeGameImpl implements TicTacToeGame {

	private final Mark playersMark;
	private final Mark aiMark;
	private final Map<Square, Mark> board = new EnumMap<>(Square.class);
	private final TicTacToeAi ai;

	TicTacToeGameImpl(final TicTacToeAi ai, final Mark playersMark) {
		this.playersMark = playersMark;
		this.aiMark = (playersMark == Mark.X) ? Mark.O : Mark.X;
		this.ai = ai;
		if (aiMark == Mark.X) {
			markAiMove();
		}
	}

	@Override
	public void mark(final Square square) {
		board.put(square, playersMark);
		markAiMove();
	}

	private void markAiMove() {
		if (getResult() == IN_PROGRESS) {
			board.put(ai.determineNextMove(board, aiMark), aiMark);
		}
	}

	@Override
	public GameResult getResult() {
		if (hasWon(playersMark)) {
			return PLAYER_WINS;
		} else if (hasWon(aiMark)) {
			return AI_WINS;
		} else if (board.size() == 9) {
			return DRAW;
		} else {
			return IN_PROGRESS;
		}
	}

	private boolean hasWon(final Mark player) {
		return Stream.of(
				Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT),
				Stream.of(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT),
				Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT),

				Stream.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT),
				Stream.of(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER),
				Stream.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT),

				Stream.of(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT),
				Stream.of(BOTTOM_LEFT, MIDDLE_CENTER, TOP_RIGHT)
		).anyMatch(winningCombo -> winningCombo.allMatch(square -> board.get(square) == player));
	}

	@Override
	public String toString() {
		return Stream.of(
				Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT).map(square -> Optional.ofNullable(board.get(square)).map(Mark::name).orElse("-")).collect(Collectors.joining(" ")),
				Stream.of(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT).map(square -> Optional.ofNullable(board.get(square)).map(Mark::name).orElse("-")).collect(Collectors.joining(" ")),
				Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT).map(square -> Optional.ofNullable(board.get(square)).map(Mark::name).orElse("-")).collect(Collectors.joining(" "))
		).collect(Collectors.joining(System.lineSeparator()));
	}
}
