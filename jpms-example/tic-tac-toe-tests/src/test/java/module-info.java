import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.ports.TicTacToeAi;

open module com.wwc.cleancode.bdd.tictactoe.jpms.tests {
	requires com.wwc.cleancode.bdd.tictactoe.jpms.api;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires jgiven.junit5;

	uses TicTacToeAi;
	uses TicTacToeGameFactory;
	provides TicTacToeAi with com.wwc.cleancode.bdd.tictactoe.jpms.tests.MockTicTacToeAi;
}
