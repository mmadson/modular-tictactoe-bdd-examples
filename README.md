# BDD Unit Testing Tic-Tac-Toe

## Usage

Given the following game rules, build a tic-tac-toe game api starting with the 
development of a suite of tests. That is, the game api should be developed
by applying Test Driven Design to the following game rules.

### Game Rules

- a game has a player who chooses a symbol X or O
- a game has an ai who is assigned the symbol the player did not choose
- a game has nine squares organized in a 3x3 grid
- the player can mark a square with their symbol if the square is not already marked, whoever has the X symbol always marks first
- the ai marks their squares instantly as soon as possible
- the player and ai take turns marking squares until the game is over
- a game is over when all squares in a column are marked by either the player or the ai
- a game is over when all squares in a row are marked by the player or the ai
- a game is over when all squares in a diagonal are marked by the player or the ai
- a game is over when all squares are marked -- resulting in a tie or cats game

