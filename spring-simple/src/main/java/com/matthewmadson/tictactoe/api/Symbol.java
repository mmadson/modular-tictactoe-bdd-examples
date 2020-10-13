package com.matthewmadson.tictactoe.api;

public enum Symbol {
    O, X;

    public Symbol getOpponentSymbol() {
        return (this == X) ? O : X;
    }
}
