package com.wwc.cleancode.tdd.tictactoe.tests;

import com.wwc.cleancode.tdd.tictactoe.api.NoImplementationFoundException;
import com.wwc.cleancode.tdd.tictactoe.api.TicTacToeGameFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTests {

	@Test
	void testSomething() throws NoImplementationFoundException {
		final var game = TicTacToeGameFactory.create().newGame();
		Assertions.assertEquals("hello!", game.sayHello());

	}

}
