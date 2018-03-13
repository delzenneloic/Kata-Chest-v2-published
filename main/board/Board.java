package board;

import java.util.Vector;

import player.Move;
import pawn.AbstractPawn;
import pawn.Colors;
import pawn.King;

public class Board {
	Vector<AbstractPawn> board;
	public final static int SIZE = 8;
	public final static int SQUARES = Board.SIZE * Board.SIZE;
	
	public Board(){
		this.board = new Vector<AbstractPawn>(Board.SQUARES);
		
		for(int i=0; i< Board.SQUARES; ++i)
			this.board.addElement(null);
	}
	
	public int size() {
		return Board.SIZE;
	}
	
	static public Position position(int no) {
		return new Position(no);
	}
	
	static public Position position(int rank,int file) {
		return new Position(rank,file);
	}
	
	// No safety. Should return an Exception (like an 'InvalidReferenceException') if the reference string is not valid reference.
	static public Position position(String reference) {
		int rank = (int)(reference.charAt(1) - '1');
		int file = (int)(reference.charAt(0) - 'a');
		return new Position(rank,file);
	}
	
	public AbstractPawn getPawn(Position q) {
		return this.board.get(q.no());
	}
	
	public void setPawn(Position q,AbstractPawn p) {
		this.board.set(q.no(), p);
	}
	
	public void apply(final Move move) {
		AbstractPawn p = this.getPawn(move.from());
		this.setPawn(move.to(), p);
		this.setPawn(move.from(), null);
	}
	
	public void show() {
		String rank = null;
		
		rank = "   ";
		for(int j=0; j< Board.SIZE; ++j) {
			rank += " " + " "
			     +  " " + (char)('a' + j)
			     +  " " + " "
			     +  " ";
		}
		System.out.println(rank);
		
		for(int i=Board.SIZE-1; i>=0; --i) { // The board is printed top-down
			rank = " " + (char)('1' + i) + " ";
			for(int j=0; j< Board.SIZE; ++j) {
				Position q = Board.position(i,j);
				AbstractPawn p = this.getPawn(q);
				rank += "[" + (p == null ? " " : p.pawnRepresentation())
					 +  "," + (p == null ? " " : p.colorRepresentation())
					 +  "," + (q.color() == Colors.dark ? 'x' : '0')
					 +  "]";
			}
			System.out.println(rank);
		}
	}
	
	public boolean isFree(Position q) {
		return this.getPawn(q) == null;
	}
	
	public boolean checkmate(Colors color) {
		AbstractPawn p = null;
		int i;
		
		for(i=0; i< Board.SQUARES; ++i) {
			p = this.getPawn(Board.position(i));
			if(p != null && p.isKing() && p.color() == color) // Has to exists! 
				break;
		}
		
		return !((King)p).is_safe(Board.position(i),this);
	}
	
	public boolean isInside(Position q) {
		return 0 <= q.rank() && q.rank() <= Board.SIZE && 0 <= q.file() && q.file() <= Board.SIZE;
	}
}
