package nl.ws.snake.headbody;

import java.util.ArrayList;

public class HeadBody {
	public ArrayList<HeadBody> headbody = new ArrayList<>();
			
	public void initializeHead(){
		headbody.add(new Head());
	}
	
	public void addBody() {
		headbody.add(new Body());
	}
}
