package com.wwc.cleancode.bdd.tictactoe.serviceloader.api.ports;

import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.Square;
import com.wwc.cleancode.bdd.tictactoe.serviceloader.api.Symbol;

import java.util.Map;
import java.util.ServiceLoader;

public interface TicTacToeAi {
	TicTacToeAi INSTANCE = ServiceLoader.load(TicTacToeAi.class).findFirst().get();

	Square getNextSquareToMark(Map<Square, Symbol> board, Symbol aiSymbol);
}
