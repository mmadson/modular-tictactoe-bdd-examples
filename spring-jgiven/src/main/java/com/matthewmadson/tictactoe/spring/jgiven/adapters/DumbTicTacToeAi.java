package com.matthewmadson.tictactoe.spring.jgiven.adapters;

import com.matthewmadson.tictactoe.spring.jgiven.ports.TicTacToeAi;
import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.Square;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DumbTicTacToeAi implements TicTacToeAi {

	@Override
	public Square determineNextMove(final Map<Square, Mark> board, final Mark aiMark) {
		return Square.MIDDLE_CENTER;
	}
}
