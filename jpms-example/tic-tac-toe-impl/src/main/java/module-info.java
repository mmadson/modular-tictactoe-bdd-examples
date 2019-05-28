module com.wwc.cleancode.tdd.tictactoe.impl {
	requires com.wwc.cleancode.tdd.tictactoe.api;

	provides com.wwc.cleancode.tdd.tictactoe.api.TicTacToeGameFactory with com.wwc.cleancode.tdd.tictactoe.impl.TicTacToeGameFactoryImpl;
}
