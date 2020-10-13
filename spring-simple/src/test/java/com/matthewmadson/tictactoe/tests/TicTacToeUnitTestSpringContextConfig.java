package com.matthewmadson.tictactoe.tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.matthewmadson.tictactoe.inmemory")
public class TicTacToeUnitTestSpringContextConfig {

    @Bean
    MockTicTacToeAi provideMockTicTacToeAi() {
        return new MockTicTacToeAi();
    }
}
