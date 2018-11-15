package nl.ws.snake.field;

import nl.ws.snake.*;
import nl.ws.snake.apple.*;
import nl.ws.snake.headbody.*;
import nl.ws.snake.player.*;

public class Field {
	int vert = 10;
	int hori = 10;
	public String[][] field = new String[vert][hori];

	public String base = " . ";
	public Apple apple = new Apple();
	public HeadBody snakeHead = new HeadBody();
	
	public void createField() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field.length; j++) {
				field[i][j] = base;
			}
		}
	}
	
	public void showField() {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field.length; j++) {
				System.out.print(field[i][j]);
				if(j == 9) {
					System.out.println();
				}
			}
		}
		System.out.println(snakeHead.headbody);
	}
	
	public void spawnHead() {
		((Head)snakeHead.headbody.get(0)).vertPos = Snake.rand.nextInt(10);
		((Head)snakeHead.headbody.get(0)).horiPos = Snake.rand.nextInt(10);
		field[((Head)snakeHead.headbody.get(0)).vertPos][((Head)snakeHead.headbody.get(0)).horiPos] = ((Head)snakeHead.headbody.get(0)).head;
	}
	
	public void spawnApple() {
		apple.vertPos = Snake.rand.nextInt(10);
		apple.horiPos = Snake.rand.nextInt(10);
		field[apple.vertPos][apple.horiPos] = apple.apple;
	}
	
	public void spawnNewApple(Player player) {
		if((((Head)snakeHead.headbody.get(0)).vertPos == apple.vertPos) && (((Head)snakeHead.headbody.get(0)).horiPos == apple.horiPos)) {
			spawnApple();
			snakeHead.addBody();
			player.score++;
		}
	}
	
	public void spawnBody() {
		for(int i = 1; i < snakeHead.headbody.size(); i++) {
			((Body)snakeHead.headbody.get(i)).vertPos = ((Head)snakeHead.headbody.get(0)).vertPos;
			((Body)snakeHead.headbody.get(i)).horiPos = ((Head)snakeHead.headbody.get(0)).horiPos;
			field[((Body)snakeHead.headbody.get(i)).vertPos][((Body)snakeHead.headbody.get(i)).horiPos] = ((Body)snakeHead.headbody.get(i)).body;
		}
	}
		
	public void initializeField() {
		snakeHead.initializeHead();
		createField();
		spawnHead();
		spawnApple();
		showField();
	}
}
