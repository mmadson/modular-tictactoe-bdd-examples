package com.wwc.cleancode.bdd.tictactoe.jpms.tests;

import com.wwc.cleancode.bdd.tictactoe.jpms.api.NoImplementationFoundException;
import com.wwc.cleancode.bdd.tictactoe.jpms.api.TicTacToeGameFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UnitTests {

	@Test
	void testSomething() throws NoImplementationFoundException {
		final var game = TicTacToeGameFactory.create().newGame();
		Assertions.assertEquals("hello!", game.sayHello());

	}

}
