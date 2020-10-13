import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameFactory;
import com.matthewmadson.tictactoe.jpms.api.ports.TicTacToeAi;
import com.matthewmadson.tictactoe.jpms.impl.TicTacToeGameFactoryImpl;

module com.matthewmadson.tictactoe.jpms.impl {
	requires com.matthewmadson.tictactoe.jpms.api;

	uses TicTacToeAi;
	provides TicTacToeGameFactory with TicTacToeGameFactoryImpl;
}
