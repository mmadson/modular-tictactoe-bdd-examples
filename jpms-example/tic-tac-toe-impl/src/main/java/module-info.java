import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;

module com.wwc.cleancode.bdd.tictactoe.jpms.impl {
	requires com.wwc.cleancode.bdd.tictactoe.jpms.api;

	provides TicTacToeGameFactory with com.wwc.cleancode.bdd.tictactoe.jpms.impl.TicTacToeGameFactoryImpl;
}
