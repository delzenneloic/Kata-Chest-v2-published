package pawn;

import board.Board;
import board.Position;
import pawn.AbstractPawn;

public class King extends AbstractPawn {
	public King(Colors color){
		super(color,Pawns.king);
	}
	
	public boolean allows(Position from,Position to,Board board) {
		return board.isInside(to)
			&& (Math.abs(from.rank()-to.rank()) + Math.abs(from.file()-to.file()) == 1)
			&& this.is_safe(to,board);
	}
	
	/*
	 * Return false if we can find a pawn owned by the enemy that can goes to the new King position. True otherwise.
	 */
	public boolean is_safe(Position q,Board board) {
		Colors colorEnemy = this.isLight() ? Colors.dark : Colors.light;
		
		AbstractPawn p = null;
		for(int i=0; i< Board.SQUARES; ++i) {
			p = board.getPawn(Board.position(i));
			if(p != null && p.color() == colorEnemy) {
				if(p.allows(Board.position(i), q, board)) {
					return false;
				}
			}
		}
		
		return true;
	}
}
