package player;
import java.util.Scanner;
import pawn.Colors;

public class Player {
	Colors color;
	String name;
	
	public Player(Colors color,String name){
		this.color = color;
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
	public Move chooseMove() {
		Move move = null;
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		
		while(move == null) {
			System.out.println("Enter a move: ");
			String text = reader.nextLine();
			move = Move.parseMove(text);
		}
		return move;
	}
}

