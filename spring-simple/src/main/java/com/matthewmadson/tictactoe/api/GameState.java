package com.matthewmadson.tictactoe.api;

public enum GameState {
    PLAYER_TURN(false), AI_WON(true), TIE_GAME(true), PLAYER_WON(true);

    private boolean isGameOver;

    GameState(final boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public boolean isEnded() {
        return isGameOver;
    }
}
