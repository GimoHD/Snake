# Snake
## Usage instructions
* Start Main, or open snake.jar
* On start the game starts with the Free mode
..* (To change mode select the mode on the selection and press start)
* To start the game, the player has to press one of the Z S Q D keys or UP DOWN LEFT RIGHT (this is correspondingly player 1 and player 2)
* If the player collides with itself, an other snake or a wall the snake loses and gets erased from the game board.
* To start over you can just press one of the controlls

## Implementations

* A GUI with user options and the game board
* Multiple snake support (2 snakes MAX)
* Player controls in the user interface in real-time (with the help of KeyListener): 
..* Player one: Z		S 		Q 		D
..* Player two: UP 		DOWN 	LEFT 	RIGHT
* Check for collision with:
..* Wall
..* Itself & Other snakes
* Food (Will be randomly spawned if eaten and added to the snake of the body)
* Every step check if the snake hits food => food is added as a body part to the snake body
* Maze modes: 
..*Easy mode: Simple rectangle wall, snake loses on collision
..*Free mode: No walls, the snake comes back from the other side
* Scoreboard

## Example images
![alt tag](https://raw.githubusercontent.com/GimoHD/Snake/master/example.png)
![alt tag](https://raw.githubusercontent.com/GimoHD/Snake/master/example2.png)

