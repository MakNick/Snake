package nl.ws.snake.controls;

import nl.ws.snake.*;
import nl.ws.snake.exceptions.*;
import nl.ws.snake.field.*;
import nl.ws.snake.headbody.*;

public class Controls {
	
	public void moveHead(String input, Field field, HeadBody hb) throws GameOverException{
		if(input.equals("w")) {
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = field.base;
			borderCheckMax(((Head)hb.headbody.get(0)).vertPos);
			((Head)hb.headbody.get(0)).vertPos -= 1;
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = ((Head)hb.headbody.get(0)).head;
			
		} else if (input.equals("a")) {
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = field.base;
			borderCheckMax(((Head)hb.headbody.get(0)).horiPos);
			((Head)hb.headbody.get(0)).horiPos -= 1;
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = ((Head)hb.headbody.get(0)).head;
			
		} else if (input.equals("s")) {
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = field.base;
			((Head)hb.headbody.get(0)).vertPos += 1;
			borderCheckMax(((Head)hb.headbody.get(0)).vertPos);
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = ((Head)hb.headbody.get(0)).head;
			
		} else if (input.equals("d")) {
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = field.base;
			((Head)hb.headbody.get(0)).horiPos += 1;
			borderCheckMax(((Head)hb.headbody.get(0)).horiPos);
			field.field[((Head)hb.headbody.get(0)).vertPos][((Head)hb.headbody.get(0)).horiPos] = ((Head)hb.headbody.get(0)).head;
			
		} else {
			System.out.println("Wrong input");
			input = Snake.sc.nextLine();
		}
	}
	
	public void borderCheckMax(int value) throws GameOverException{
		if(value == 10) {
			throw new GameOverException();
		}
	}
	public void borderCheckMin(int value) throws GameOverException{
		if(value == 0) {
			throw new GameOverException();
		}
	}
	
}

