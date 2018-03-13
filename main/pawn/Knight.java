package pawn;

import board.Board;
import board.Position;

public class Knight extends AbstractPawn {
	public Knight(Colors color){
		super(color,Pawns.knight);
	}
	
	public boolean allows(Position from,Position to,Board board) {
		return board.isInside(to) && 
			   ((Math.abs(from.rank()-to.rank()) == 1 && Math.abs(from.file()-to.file()) == 2)
			||  (Math.abs(from.rank()-to.rank()) == 2 && Math.abs(from.file()-to.file()) == 1));
	}
}
