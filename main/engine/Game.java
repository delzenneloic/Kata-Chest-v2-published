package engine;

import board.Board;
import files.Reader;
import player.Move;
import player.Player;
import pawn.AbstractPawn;
import pawn.Colors;

/*
 * 
 * This class is incomplete. The game ends after 3 rounds for now.
 * This decision is motivate to allows some tests, but the way the isEnded() method is implemented is definitely not completed.
 * 
 */
public class Game {
	private boolean ends;
	private Player light;
	private Player dark;
	private Player current;
	private Board board;
	
	private int rounds;
	
	public Game() {
		Reader reader = new Reader("InitialPositions.xml");
		
		ends = false;
		light = new Player(Colors.light, "Light");
		dark = new Player(Colors.dark, "Dark");
		current = light;
		board = reader.board();
		
		rounds = 3;
	}
	
	public Game switchPlayer() {
		current = (current == light) ? dark : light;
		return this;
	}
	
	public Game welcome() {
		System.out.println("Welcome to the chest game!");
		System.out.println("");
		
		this.board.show();
		
		return this;
	}
	
	public Game round() {
		System.out.println("------------------------------------------------------");
		System.out.println("This is the turn of player " + current.name() + " :");
		
		// The player has to suggest a move:
		this.board.apply(this.requestMoveFrom(current));
		
		--rounds;
		ends = (rounds == 0);
		
		// Change the current player
		this.switchPlayer();
		
		System.out.println("");
		board.show();
		System.out.println("");
		System.out.println("");
		
		return this;
	}
	
	public boolean isEnded() {
		return this.ends;
	}
	
	
	/*
	 * 
	 * Implementation 
	 * 
	 */
	private Move requestMoveFrom(Player player) {
		Move move = null;
		while(move == null) {
			move = player.chooseMove();
			// From here, move is not null!
			
			// Basic condition: The initial position has to be in the board
			if(!this.board.isInside(move.from())) {
				System.out.println("The initial position is out the board. Please try again:");
				move=null;
				continue;
			}
			
			// Then a pawn has to be on the designated "from" position
			AbstractPawn p = this.board.getPawn(move.from());
			if(p == null) {
				System.out.println("The is no pawn on the designated position. Please try again:");
				move=null;
				continue;
			}
			
			// Finally, the pawn chosen must be allowed to move to the "to" position
			if(!p.allows(move.from(),move.to(),this.board)) {
				System.out.println("The move is invalid. Please try again:");
				move=null;
				continue;
			}
		}
		
		System.out.println("The move is accepted.");
		return move;
	}
}
