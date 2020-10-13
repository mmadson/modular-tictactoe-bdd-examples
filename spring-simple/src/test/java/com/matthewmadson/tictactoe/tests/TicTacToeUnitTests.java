package com.matthewmadson.tictactoe.tests;

import com.matthewmadson.tictactoe.api.GameState;
import com.matthewmadson.tictactoe.api.Square;
import com.matthewmadson.tictactoe.api.Symbol;
import com.matthewmadson.tictactoe.api.TicTacToeGame;
import com.matthewmadson.tictactoe.api.TicTacToeGameFactory;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TicTacToeUnitTestSpringContextConfig.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class TicTacToeUnitTests {

    private Symbol playerSymbol;
    private TicTacToeGame game;
    @Autowired
    private MockTicTacToeAi ai;
    @Autowired
    private TicTacToeGameFactory gameFactory;
    private Exception thrownException;

    private void then_player_symbol_is(final Symbol expectedPlayerSymbol) {
        Assertions
              .assertThat(game.getPlayerSymbol())
              .isEqualTo(expectedPlayerSymbol);
    }

    private void when_create_new_game() {
        game = gameFactory.create(this.playerSymbol);
    }

    private void given_player_chooses(final Symbol selectedSymbol) {
        this.playerSymbol = selectedSymbol;
    }

    // TDD
    // - RED
    // - GREEN
    // - REFACTOR

    /**
     * - a game has an ai who is assigned the symbol the player did not choose
     */

    @Test
    public void test_ai_is_assigned_symbol_o_when_player_chooses_x() {
        given_player_chooses(Symbol.X);

        when_create_new_game();

        then_player_symbol_is(Symbol.X);
        then_ai_symbol_is(Symbol.O);
    }

    private void then_ai_symbol_is(final Symbol expectedAiSymbol) {
        Assertions
              .assertThat(game.getAiSymbol())
              .isEqualTo(expectedAiSymbol);
    }


    @Test
    public void test_ai_is_assigned_symbol_X_when_player_chooses_o() {
        given_player_chooses(Symbol.O);

        when_create_new_game();

        then_player_symbol_is(Symbol.O);
        then_ai_symbol_is(Symbol.X);
    }

    /**
     * - a game has nine squares organized in a 3x3 grid
     */

    @Test
    public void test_game_board_empty() {
        given_player_chooses(Symbol.X);

        when_create_new_game();

        then_game_board_matches("""
              - - -
              - - -
              - - -
              """
        );
        then_game_state_equals(GameState.PLAYER_TURN);
    }

    private void then_game_board_matches(final String expectedGameBoard) {
        Assertions
              .assertThat(game.getGameBoard())
              .isEqualTo(expectedGameBoard.trim());
    }

    /**
     * - the player can mark a square with their symbol if the square is not already marked, whoever has the X symbol
     * always marks first
     */

    private void when_player_marks(final Square... squaresToMark) {
        for (final Square square : Arrays.asList(squaresToMark)) {
            try {
                game.mark(square);
            } catch (Exception e) {
                this.thrownException = e;
                break;
            }
        }
    }

    /**
     * - the ai marks their squares instantly as soon as possible
     */

    // What do we want from our unit tests?
    // - fast
    // - deterministic
    // - limited knowledge / coupling to details
    @Test
    public void test_player_can_mark_a_square_and_ai_also_marks_a_square() {
        given_player_chooses(Symbol.X);
        given_ai_marks(Square.CENTER_MIDDLE);

        when_create_new_game();
        when_player_marks(Square.TOP_LEFT);

        then_game_board_matches("""
              X - -
              - O -
              - - -
              """
        );
        then_game_state_equals(GameState.PLAYER_TURN);
    }

    private void given_ai_marks(final Square... squaresToMark) {
        this.ai.setSquaresToMark(squaresToMark);
    }

    /**
     * - the player and ai take turns marking squares until the game is over - a game is over when all squares in a
     * column are marked by either the player or the ai
     */

    @Test
    public void test_player_wins_left_column() {
        given_player_chooses(Symbol.X);
        given_ai_marks(Square.CENTER_MIDDLE, Square.TOP_RIGHT);

        when_create_new_game();
        when_player_marks(
              Square.TOP_LEFT,
              Square.CENTER_LEFT,
              Square.BOTTOM_LEFT
        );

        then_game_board_matches("""
              X - O
              X O -
              X - -
              """
        );
        then_game_state_equals(GameState.PLAYER_WON);
    }


    @Test
    public void test_ai_wins_left_column() {
        given_player_chooses(Symbol.O);
        given_ai_marks(
              Square.TOP_LEFT,
              Square.CENTER_LEFT,
              Square.BOTTOM_LEFT
        );

        when_create_new_game();
        when_player_marks(
              Square.CENTER_MIDDLE,
              Square.TOP_RIGHT
        );

        then_game_board_matches("""
              X - O
              X O -
              X - -
              """
        );
        then_game_state_equals(GameState.AI_WON);
    }

    private void then_game_state_equals(final GameState expectedGameState) {
        Assertions
              .assertThat(game.getGameState())
              .isEqualTo(expectedGameState);
    }

    /**
     * - a game is over when all squares in a row are marked by the player or the ai
     */

    @Test
    public void test_player_wins_top_row() {
        given_player_chooses(Symbol.X);
        given_ai_marks(Square.CENTER_MIDDLE, Square.CENTER_RIGHT);

        when_create_new_game();
        when_player_marks(
              Square.TOP_LEFT,
              Square.TOP_MIDDLE,
              Square.TOP_RIGHT
        );

        then_game_board_matches("""
              X X X
              - O O
              - - -
              """
        );
        then_game_state_equals(GameState.PLAYER_WON);
    }


    /**
     * - a game is over when all squares in a diagonal are marked by the player or the ai
     */

    @Test
    public void test_player_wins_top_left_diagonal() {
        given_player_chooses(Symbol.X);
        given_ai_marks(Square.TOP_RIGHT, Square.CENTER_RIGHT);

        when_create_new_game();
        when_player_marks(
              Square.TOP_LEFT,
              Square.CENTER_MIDDLE,
              Square.BOTTOM_RIGHT
        );

        then_game_board_matches("""
              X - O
              - X O
              - - X
              """
        );
        then_game_state_equals(GameState.PLAYER_WON);
    }

    /**
     * - a game is over when all squares are marked -- resulting in a tie or cats game
     */

    @Test
    public void test_tie_game() {
        given_player_chooses(Symbol.X);
        given_ai_marks(Square.TOP_RIGHT, Square.BOTTOM_RIGHT, Square.CENTER_LEFT, Square.BOTTOM_MIDDLE);

        when_create_new_game();
        when_player_marks(
              Square.TOP_LEFT,
              Square.CENTER_MIDDLE,
              Square.CENTER_RIGHT,
              Square.TOP_MIDDLE,
              Square.BOTTOM_LEFT
        );

        then_game_board_matches("""
              X X O
              O X X
              X O O
              """
        );
        then_game_state_equals(GameState.TIE_GAME);
    }
}
