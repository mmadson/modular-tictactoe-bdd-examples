package com.matthewmadson.tictactoe.persisted;

import com.matthewmadson.tictactoe.api.GameState;
import com.matthewmadson.tictactoe.api.Square;
import com.matthewmadson.tictactoe.api.Symbol;
import com.matthewmadson.tictactoe.api.TicTacToeGame;
import com.matthewmadson.tictactoe.ports.TicTacToeAi;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersistedTicTacToeGame implements TicTacToeGame {

    private final Symbol playerSymbol;
    private final Symbol aiSymbol;
    private final Set<Square> markedByPlayer = new HashSet<>();
    private final Set<Square> markedByAi = new HashSet<>();
    private final TicTacToeAi ai;

    public PersistedTicTacToeGame(final Symbol playerSymbol, final TicTacToeAi ai) {
        this.playerSymbol = playerSymbol;
        aiSymbol = playerSymbol.getOpponentSymbol();
        this.ai = ai;
        if (aiSymbol == Symbol.X) {
            this.markedByAi.add(ai.getNextSquareToMark());
        }
    }

    @Override
    public Symbol getPlayerSymbol() {
        return playerSymbol;
    }

    @Override
    public Symbol getAiSymbol() {
        return aiSymbol;
    }

    @Override
    public String getGameBoard() {
        return
              Square
                    .rows()
                    .stream()
                    .map(row ->
                          row
                                .stream()
                                .map(square ->
                                      (markedByPlayer.contains(square))
                                      ? playerSymbol.toString()
                                      : (
                                            (markedByAi.contains(square))
                                            ? aiSymbol.toString()
                                            : "-"
                                      )
                                )
                                .collect(Collectors.joining(" "))
                    )
                    .collect(Collectors.joining("\n"));
    }

    @Override
    public void mark(final Square squareToMark) {
        this.markedByPlayer.add(squareToMark);
        if (!getGameState().isEnded()) {
            this.markedByAi.add(ai.getNextSquareToMark());
        }
    }

    @Override
    public GameState getGameState() {
        return
              Stream
                    .of(
                          Square
                                .rows()
                                .stream(),
                          Square
                                .columns()
                                .stream(),
                          Square
                                .diagonals()
                                .stream()
                    )
                    .flatMap(Function.identity())
                    .map(winningSquares ->
                          markedByAi.containsAll(winningSquares)
                          ? GameState.AI_WON
                          : (markedByPlayer.containsAll(winningSquares)
                             ? GameState.PLAYER_WON
                             : null)
                    )
                    .filter(Objects::nonNull)
                    .findAny()
                    .orElse(
                          ((markedByAi.size() + markedByPlayer.size()) == Arrays
                                .asList(Square.values())
                                .size()) ?
                          GameState.TIE_GAME :
                          GameState.PLAYER_TURN
                    );
    }
}
