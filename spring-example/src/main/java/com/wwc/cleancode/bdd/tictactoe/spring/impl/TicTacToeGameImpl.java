package com.wwc.cleancode.bdd.tictactoe.spring.impl;

import com.wwc.cleancode.bdd.tictactoe.spring.GameResult;
import com.wwc.cleancode.bdd.tictactoe.spring.Mark;
import com.wwc.cleancode.bdd.tictactoe.spring.Square;
import com.wwc.cleancode.bdd.tictactoe.spring.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.spring.ports.TicTacToeAi;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.wwc.cleancode.bdd.tictactoe.spring.GameResult.AI_WINS;
import static com.wwc.cleancode.bdd.tictactoe.spring.GameResult.DRAW;
import static com.wwc.cleancode.bdd.tictactoe.spring.GameResult.IN_PROGRESS;
import static com.wwc.cleancode.bdd.tictactoe.spring.GameResult.PLAYER_WINS;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.BOTTOM_CENTER;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.BOTTOM_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.BOTTOM_RIGHT;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.MIDDLE_CENTER;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.MIDDLE_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.MIDDLE_RIGHT;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.TOP_CENTER;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.TOP_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.spring.Square.TOP_RIGHT;

final class TicTacToeGameImpl implements TicTacToeGame {

	private final Mark playersMark;
	private final Mark aiMark;
	private final Map<Square, Mark> board = new EnumMap<>(Square.class);
	private final TicTacToeAi ai;

	TicTacToeGameImpl(final TicTacToeAi ai, final Mark playersMark) {
		this.playersMark = playersMark;
		this.aiMark = (playersMark == Mark.X) ? Mark.O : Mark.X;
		this.ai = ai;
		markAiMove();
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
		return Stream.of(Stream.of(TOP_LEFT, TOP_CENTER, TOP_RIGHT), Stream.of(MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT), Stream.of(BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT),
				Stream.of(TOP_LEFT, MIDDLE_LEFT, BOTTOM_LEFT), Stream.of(TOP_CENTER, MIDDLE_CENTER, BOTTOM_CENTER), Stream.of(TOP_RIGHT, MIDDLE_RIGHT, BOTTOM_RIGHT),
				Stream.of(TOP_LEFT, MIDDLE_CENTER, BOTTOM_RIGHT), Stream.of(BOTTOM_LEFT, MIDDLE_CENTER, TOP_RIGHT))
				.anyMatch(winningCombo -> winningCombo.allMatch(square -> board.get(square) == player));
	}
}
