import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.ports.TicTacToeAi;

module com.wwc.cleancode.bdd.tictactoe.jpms.impl {
	requires com.wwc.cleancode.bdd.tictactoe.jpms.api;

	uses TicTacToeAi;
	provides TicTacToeGameFactory with com.wwc.cleancode.bdd.tictactoe.jpms.impl.TicTacToeGameFactoryImpl;
}
