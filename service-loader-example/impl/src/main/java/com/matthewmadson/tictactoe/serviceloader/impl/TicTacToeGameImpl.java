package com.matthewmadson.tictactoe.serviceloader.impl;

import com.matthewmadson.tictactoe.serviceloader.api.GameState;
import com.matthewmadson.tictactoe.serviceloader.api.Square;
import com.matthewmadson.tictactoe.serviceloader.api.Symbol;
import com.matthewmadson.tictactoe.serviceloader.api.TicTacToeGame;
import com.matthewmadson.tictactoe.serviceloader.api.ports.TicTacToeAi;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicTacToeGameImpl implements TicTacToeGame {

	private final Symbol playerSymbol;
	private Symbol aiSymbol;
	private final Map<Square, Symbol> board = new EnumMap<>(Square.class);

	public TicTacToeGameImpl(final Symbol playerSymbol) {
		this.playerSymbol = playerSymbol;
		this.aiSymbol = (playerSymbol == Symbol.X) ? Symbol.O : Symbol.X;
		if(aiSymbol == Symbol.X) {
			performAiMove();
		}
	}

	@Override
	public GameState getState() {
		return Stream.of(
			List.of(Square.TOP_LEFT, Square.TOP_MIDDLE, Square.TOP_RIGHT),
			List.of(Square.CENTER_LEFT, Square.CENTER_MIDDLE, Square.CENTER_RIGHT),
			List.of(Square.BOTTOM_LEFT, Square.BOTTOM_MIDDLE, Square.BOTTOM_RIGHT),

			List.of(Square.TOP_LEFT, Square.CENTER_LEFT, Square.BOTTOM_LEFT),
			List.of(Square.TOP_MIDDLE, Square.CENTER_MIDDLE, Square.BOTTOM_MIDDLE),
			List.of(Square.TOP_RIGHT, Square.CENTER_RIGHT, Square.BOTTOM_RIGHT),

			List.of(Square.TOP_LEFT, Square.CENTER_MIDDLE, Square.BOTTOM_RIGHT),
			List.of(Square.BOTTOM_LEFT, Square.CENTER_MIDDLE, Square.TOP_RIGHT)
		).map(line -> line.stream().map(square -> Optional.ofNullable(board.get(square)).map(Symbol::name).orElse("-")).collect(Collectors.joining()))
		.filter(line -> "xxx".equalsIgnoreCase(line) || "ooo".equalsIgnoreCase(line))
		.findAny()
		.map(line -> line.substring(0,1))
		.map(Symbol::valueOf)
		.map(symbol -> (symbol == playerSymbol) ? GameState.PLAYER_HAS_WON : GameState.AI_HAS_WON)
		.orElseGet(() -> (board.size() == 9) ? GameState.DRAW : GameState.IN_PROGRESS);
	}

	@Override
	public void markSquare(final Square squareToMark) {
		board.put(squareToMark, playerSymbol);
		if(getState() == GameState.IN_PROGRESS) {
			performAiMove();
		}
	}

	private void performAiMove() {
		board.put(TicTacToeAi.INSTANCE.getNextSquareToMark(board, aiSymbol), aiSymbol);
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();

		final Square[] squares = Square.values();
		for (int i = 1; i <= squares.length; i++) {
			result.append(Optional.ofNullable(board.get(squares[i-1])).map(Symbol::name).orElse("-"));
			if(i != 9) {
				result.append(((i % 3) == 0) ? "\n" : " ");
			}
		}

		return result.toString();
	}
}
