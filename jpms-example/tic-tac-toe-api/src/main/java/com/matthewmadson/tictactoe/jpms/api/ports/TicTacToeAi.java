package com.matthewmadson.tictactoe.jpms.api.ports;

import com.matthewmadson.tictactoe.jpms.api.Square;

import java.util.ServiceLoader;
import java.util.Set;

public interface TicTacToeAi {

	TicTacToeAi INSTANCE = ServiceLoader.load(TicTacToeAi.class).findFirst().orElse(null);

	Square getNextSquareToMark(Set<Square> markedSquares);
}
