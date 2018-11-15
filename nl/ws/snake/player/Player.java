package nl.ws.snake.player;

public class Player {
	public String name;
	public int score;
	
	public Player(String name){
		this.name = name;
	}
	
	public void getScore() {
		System.out.println("Total score of " + name + " is: " + score);
	}
}
