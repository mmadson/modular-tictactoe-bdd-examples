package com.wwc.cleancode.bdd.tictactoe.jpms.impl;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.GameState;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.Square;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.Symbol;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGame;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions.GameAlreadyEndedException;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions.SquareAlreadyTakenException;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.ports.TicTacToeAi;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.BOTTOM_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.BOTTOM_MIDDLE;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.BOTTOM_RIGHT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.CENTER_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.CENTER_MIDDLE;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.CENTER_RIGHT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.TOP_LEFT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.TOP_MIDDLE;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Square.TOP_RIGHT;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Symbol.O;
import static com.wwc.cleancode.bdd.tictactoe.jpms.api.Symbol.X;

public class TicTacToeGameImpl implements TicTacToeGame {

	private final Symbol playerSymbol;
	private final Symbol aiSymbol;
	private final Map<Square, Symbol> board = new EnumMap<>(Square.class);

	public TicTacToeGameImpl(final Symbol playerSymbol) {
		this.playerSymbol = playerSymbol;
		this.aiSymbol = (playerSymbol == X) ? O : X;
		if (aiSymbol == X) {
			playAiTurn();
		}
	}

	@Override
	public void markSquare(final Square square) throws GameAlreadyEndedException, SquareAlreadyTakenException {
		final GameState endedState = getState();
		if (endedState != GameState.IN_PROGRESS) {
			throw new GameAlreadyEndedException(endedState);
		}

		if (board.containsKey(square)) {
			throw new SquareAlreadyTakenException();
		}

		board.put(square, playerSymbol);

		if (getState() == GameState.IN_PROGRESS) {
			playAiTurn();
		}
	}

	private void playAiTurn() {
		board.put(TicTacToeAi.INSTANCE.getNextSquareToMark(board.keySet()), aiSymbol);
	}

	@Override
	public GameState getState() {
		return Stream.of(List.of(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT), List.of(CENTER_LEFT, CENTER_MIDDLE, CENTER_RIGHT), List.of(BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT),

				List.of(TOP_LEFT, CENTER_LEFT, BOTTOM_LEFT), List.of(TOP_MIDDLE, CENTER_MIDDLE, BOTTOM_MIDDLE), List.of(TOP_RIGHT, CENTER_RIGHT, BOTTOM_RIGHT),

				List.of(TOP_LEFT, CENTER_MIDDLE, BOTTOM_RIGHT), List.of(TOP_RIGHT, CENTER_MIDDLE, BOTTOM_LEFT))
				.map(line -> line.stream().map(s -> Optional.ofNullable(board.get(s))).map(symbol -> symbol.map(Symbol::toString).orElse("-")).collect((Collectors.joining())))
				.filter(lineSymbols -> "xxx".equalsIgnoreCase(lineSymbols) || "ooo".equalsIgnoreCase(lineSymbols)).findAny().map(s -> s.charAt(0)).map(Object::toString).map(Symbol::valueOf)
				.map(symbol -> (symbol == playerSymbol) ? GameState.PLAYER_HAS_WON : GameState.AI_HAS_WON).orElseGet(() -> (board.size() == 9) ? GameState.DRAW : GameState.IN_PROGRESS);
	}
}
