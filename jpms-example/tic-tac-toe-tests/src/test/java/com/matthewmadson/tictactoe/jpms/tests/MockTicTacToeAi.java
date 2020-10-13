package com.matthewmadson.tictactoe.jpms.tests;

import com.matthewmadson.tictactoe.jpms.api.Square;
import com.matthewmadson.tictactoe.jpms.api.ports.TicTacToeAi;

import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class MockTicTacToeAi implements TicTacToeAi {
	private ListIterator<Square> moveSequenceIterator;

	@Override
	public Square getNextSquareToMark(final Set<Square> markedSquares) {
		return moveSequenceIterator.next();
	}

	public void setMoveSequence(final List<Square> moveSequence) {
		moveSequenceIterator = moveSequence.listIterator();
	}
}
