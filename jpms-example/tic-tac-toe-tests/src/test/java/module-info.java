import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;

open module com.wwc.cleancode.bdd.tictactoe.jpms.tests {
	requires com.wwc.cleancode.bdd.tictactoe.jpms.api;
	requires org.junit.jupiter.api;

	uses TicTacToeGameFactory;
}
