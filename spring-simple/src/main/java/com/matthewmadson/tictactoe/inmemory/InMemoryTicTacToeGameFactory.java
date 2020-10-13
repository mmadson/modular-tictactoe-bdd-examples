package com.matthewmadson.tictactoe.inmemory;

import com.matthewmadson.tictactoe.api.Symbol;
import com.matthewmadson.tictactoe.api.TicTacToeGame;
import com.matthewmadson.tictactoe.api.TicTacToeGameFactory;
import com.matthewmadson.tictactoe.ports.TicTacToeAi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class InMemoryTicTacToeGameFactory implements TicTacToeGameFactory {

    private final TicTacToeAi ai;

    @Autowired
    InMemoryTicTacToeGameFactory(final TicTacToeAi ai) {
        this.ai = ai;
    }
    
    @Override
    public TicTacToeGame create(final Symbol playerSymbol) {
        return new InMemoryTicTacToeGame(playerSymbol, ai);
    }
}
