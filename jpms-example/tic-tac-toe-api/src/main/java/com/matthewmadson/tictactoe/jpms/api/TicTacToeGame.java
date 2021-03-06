package com.matthewmadson.tictactoe.jpms.api;

import com.matthewmadson.tictactoe.jpms.api.exceptions.GameAlreadyEndedException;
import com.matthewmadson.tictactoe.jpms.api.exceptions.SquareAlreadyTakenException;

public interface TicTacToeGame {

	void markSquare(Square square) throws GameAlreadyEndedException, SquareAlreadyTakenException;

	GameState getState();
}
