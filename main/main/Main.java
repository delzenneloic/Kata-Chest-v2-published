package main;
import engine.Game;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		
		game.welcome();
		
		while(!game.isEnded())
			game.round();
		
		//Player player = new Player(Colors.light,"Light");
		
	}
}
