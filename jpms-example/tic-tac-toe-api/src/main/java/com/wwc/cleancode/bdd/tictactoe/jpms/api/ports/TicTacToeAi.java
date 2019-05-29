package com.wwc.cleancode.bdd.tictactoe.jpms.api.ports;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.Square;

import java.util.ServiceLoader;
import java.util.Set;

public interface TicTacToeAi {

	TicTacToeAi INSTANCE = ServiceLoader.load(TicTacToeAi.class).findFirst().orElse(null);

	Square getNextSquareToMark(Set<Square> markedSquares);
}
