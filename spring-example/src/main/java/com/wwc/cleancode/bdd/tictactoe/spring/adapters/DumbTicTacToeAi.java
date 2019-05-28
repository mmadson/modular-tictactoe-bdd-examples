package com.wwc.cleancode.bdd.tictactoe.spring.adapters;

import com.wwc.cleancode.bdd.tictactoe.spring.Mark;
import com.wwc.cleancode.bdd.tictactoe.spring.Square;
import com.wwc.cleancode.bdd.tictactoe.spring.ports.TicTacToeAi;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DumbTicTacToeAi implements TicTacToeAi {

	@Override
	public Square determineNextMove(final Map<Square, Mark> board, final Mark aiMark) {
		return Square.MIDDLE_CENTER;
	}
}
