package com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.GameState;

public class GameAlreadyEndedException extends Exception {
	private static final long serialVersionUID = -8713900699595881725L;
	private final GameState endedState;

	public GameAlreadyEndedException(final GameState endedState) {
		super("Game Already Ended: "+endedState);
		this.endedState = endedState;
	}

}
