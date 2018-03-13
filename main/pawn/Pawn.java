package pawn;

import board.Board;
import board.Position;

public class Pawn extends AbstractPawn{
	public Pawn(Colors color){
		super(color,Pawns.pawn);
	}
	
	public boolean allows(Position from,Position to,Board board) {
		if(this.isDark())
			return board.isInside(to) && from.file() == to.file() && from.rank()-1==to.rank();
		else
			return board.isInside(to) && from.file() == to.file() && from.rank()+1==to.rank();
	}
}
