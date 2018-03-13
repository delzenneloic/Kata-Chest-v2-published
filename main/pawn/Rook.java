package pawn;

import board.Board;
import board.Position;
import board.PositionIterator;

public class Rook extends AbstractPawn{
	public Rook(Colors color){
		super(color,Pawns.rook);
	}
	
	public boolean allows(Position from,Position to,Board board) {
		// A pawn is never allowed to stay on the same position
		if(from.equals(to)) return false;
		
		PositionIterator pi = direction(from,to);
		
		if(pi == null) return false;
		
		while(pi.hasNext()) {
			Position q = pi.next();
			
			if(q.equals(to)) break;
			if(!board.isFree(q)) return false;
		}
		return board.isInside(to) && (board.isFree(to) || board.getPawn(from).color() != board.getPawn(to).color());
	}
	
	private PositionIterator direction(Position from,Position to) {
		PositionIterator pi = null;
		
		// Determine in which direction to look after obstacles
		if(from.hasSameRank(to) && from.isOnLeft(to)) {
			pi = from.rankRightIterator();
		}
		else if(from.hasSameRank(to) && from.isOnRight(to)) {
			pi = from.rankLeftIterator();
		}
		else if(from.hasSameFile(to) && from.isAbove(to)) {
			pi = from.fileDownIterator();
		}
		else if(from.hasSameFile(to) && from.isUnder(to)) {
			pi = from.fileUpIterator();
		}
		
		return pi;
	}
}
