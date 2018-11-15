package nl.ws.snake;

import java.util.Random;
import java.util.Scanner;

import nl.ws.snake.field.*;
import nl.ws.snake.player.*;
import nl.ws.snake.controls.*;
import nl.ws.snake.exceptions.*;

public class Snake {
	public static Scanner sc = new Scanner(System.in);
	public static Random rand = new Random();
	
	Field field = new Field();
	Controls controls = new Controls();
	Player player = new Player("Nick");
	
	boolean play = true;
	
	
	public void play() {
		field.initializeField();
		while(play) {
			try {
				field.spawnBody();
				controls.moveHead(sc.nextLine(), field, field.snakeHead);
				field.spawnNewApple(player);
			} catch (GameOverException goe) {
				System.out.println(goe);
				play = false;
			}
			field.showField();
		}
		player.getScore();
		restart();
	}	
		
	public void restart() {
		System.out.println("Do you want to play a new game  y/n");
		if(sc.nextLine().equals("y")) {
			player.score = 0;
			play = true;
			play();
		} else {
			System.out.println("See you next time!");
		}
	}
}
