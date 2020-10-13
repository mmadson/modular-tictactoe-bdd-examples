package com.matthewmadson.tictactoe.tests;

import com.matthewmadson.tictactoe.api.Square;
import com.matthewmadson.tictactoe.ports.TicTacToeAi;

public class MockTicTacToeAi implements TicTacToeAi {

    private int nextSquareIndex;
    private Square[] squaresForAiToMark;
    private int numTimesCalled;

    public MockTicTacToeAi() {
        this.squaresForAiToMark = new Square[]{};
    }


    @Override
    public Square getNextSquareToMark() {
        numTimesCalled++;
        if (nextSquareIndex >= squaresForAiToMark.length) {
            return null;
        }
        final Square result = squaresForAiToMark[nextSquareIndex++];
        return result;
    }

    public void setSquaresToMark(final Square[] squaresToMark) {
        this.squaresForAiToMark = squaresToMark;
    }

    public int getNumberOfTimesGetNextSquareToMarkCalled() {
        return numTimesCalled;
    }
}
