package com.wwc.examples.tictactoebdd.ports;

import com.wwc.examples.tictactoebdd.Mark;
import com.wwc.examples.tictactoebdd.Square;

import java.util.Map;

public interface TicTacToeAi {

	Square determineNextMove(Map<Square, Mark> board, Mark aiMark);
}
