package com.wwc.cleancode.bdd.tictactoe.jpms.api;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions.GameAlreadyEndedException;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions.SquareAlreadyTakenException;

public interface TicTacToeGame {

	void markSquare(Square square) throws GameAlreadyEndedException, SquareAlreadyTakenException;

	GameState getState();
}
