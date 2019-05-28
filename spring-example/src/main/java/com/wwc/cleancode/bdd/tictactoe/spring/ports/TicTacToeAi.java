package com.wwc.cleancode.bdd.tictactoe.spring.ports;

import com.wwc.cleancode.bdd.tictactoe.spring.Mark;
import com.wwc.cleancode.bdd.tictactoe.spring.Square;

import java.util.Map;

public interface TicTacToeAi {

	Square determineNextMove(Map<Square, Mark> board, Mark aiMark);
}
