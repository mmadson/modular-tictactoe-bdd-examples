package com.matthewmadson.tictactoe.serviceloader.tests;

import com.google.auto.service.AutoService;
import com.matthewmadson.tictactoe.serviceloader.api.Square;
import com.matthewmadson.tictactoe.serviceloader.api.Symbol;
import com.matthewmadson.tictactoe.serviceloader.api.ports.TicTacToeAi;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@AutoService(TicTacToeAi.class)
public class MockTicTacToeAi implements TicTacToeAi {
	private Iterator<Square> moves;

	@Override
	public Square getNextSquareToMark(Map<Square, Symbol> board, Symbol aiSymbol) {
		return moves.next();
	}

	public void setMoveSequence(final List<Square> moveSequence) {
		moves = moveSequence.iterator();
	}
}
