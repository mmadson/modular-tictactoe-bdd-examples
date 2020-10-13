package com.matthewmadson.tictactoe.api;

import java.util.List;

public enum Square {
    TOP_LEFT,
    TOP_MIDDLE,
    TOP_RIGHT,
    CENTER_LEFT,
    CENTER_MIDDLE,
    CENTER_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_MIDDLE,
    BOTTOM_RIGHT;

    public static List<List<Square>> rows() {
        return List.of(
              List.of(TOP_LEFT, TOP_MIDDLE, TOP_RIGHT),
              List.of(CENTER_LEFT, CENTER_MIDDLE, CENTER_RIGHT),
              List.of(BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT)
        );
    }

    public static List<List<Square>> columns() {
        return List.of(
              List.of(TOP_LEFT, CENTER_LEFT, BOTTOM_LEFT),
              List.of(TOP_MIDDLE, CENTER_MIDDLE, BOTTOM_MIDDLE),
              List.of(TOP_RIGHT, CENTER_RIGHT, BOTTOM_RIGHT)
        );
    }

    public static List<List<Square>> diagonals() {
        return List.of(
              List.of(TOP_LEFT, CENTER_MIDDLE, BOTTOM_RIGHT),
              List.of(TOP_RIGHT, CENTER_MIDDLE, BOTTOM_LEFT)
        );
    }
}