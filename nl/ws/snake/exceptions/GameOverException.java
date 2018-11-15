package nl.ws.snake.exceptions;

@SuppressWarnings("serial")
public class GameOverException extends Exception{
	public GameOverException() {
		super("Game Over!");
	}
}