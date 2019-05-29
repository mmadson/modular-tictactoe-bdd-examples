import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.ports.TicTacToeAi;

module com.wwc.cleancode.bdd.tictactoe.jpms.api {
	uses TicTacToeGameFactory;
	uses TicTacToeAi;

	exports com.wwc.cleancode.bdd.tictactoe.jpms.api;
	exports com.wwc.cleancode.bdd.tictactoe.jpms.api.ports;
	exports com.wwc.cleancode.bdd.tictactoe.jpms.api.exceptions;
}
