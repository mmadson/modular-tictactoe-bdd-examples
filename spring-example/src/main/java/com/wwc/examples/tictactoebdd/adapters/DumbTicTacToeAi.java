package com.wwc.examples.tictactoebdd.adapters;

import com.wwc.examples.tictactoebdd.Mark;
import com.wwc.examples.tictactoebdd.Square;
import com.wwc.examples.tictactoebdd.ports.TicTacToeAi;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DumbTicTacToeAi implements TicTacToeAi {

	@Override
	public Square determineNextMove(final Map<Square, Mark> board, final Mark aiMark) {
		return Square.MIDDLE_CENTER;
	}
}
