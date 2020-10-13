package com.matthewmadson.tictactoe.spring.jgiven.ports;

import com.matthewmadson.tictactoe.spring.jgiven.Mark;
import com.matthewmadson.tictactoe.spring.jgiven.Square;

import java.util.Map;

public interface TicTacToeAi {

	Square determineNextMove(Map<Square, Mark> board, Mark aiMark);
}
