import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameFactory;
import com.matthewmadson.tictactoe.jpms.api.ports.TicTacToeAi;

module com.matthewmadson.tictactoe.jpms.api {
    uses TicTacToeGameFactory;
    uses TicTacToeAi;

    exports com.matthewmadson.tictactoe.jpms.api;
    exports com.matthewmadson.tictactoe.jpms.api.ports;
    exports com.matthewmadson.tictactoe.jpms.api.exceptions;
}
