import com.matthewmadson.tictactoe.jpms.api.TicTacToeGameFactory;
import com.matthewmadson.tictactoe.jpms.api.ports.TicTacToeAi;
import com.matthewmadson.tictactoe.jpms.tests.MockTicTacToeAi;

open module com.matthewmadson.tictactoe.jpms.tests {
	requires com.matthewmadson.tictactoe.jpms.api;
	requires org.junit.jupiter.api;
	requires org.junit.jupiter.params;
	requires jgiven.junit5;

	uses TicTacToeAi;
	uses TicTacToeGameFactory;
	provides TicTacToeAi with MockTicTacToeAi;
}
