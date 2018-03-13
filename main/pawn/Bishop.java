package pawn;

import board.Board;
import board.Position;
import board.PositionIterator;
import pawn.Pawns;

public class Bishop extends AbstractPawn{	
	public Bishop(Colors color){
		super(color,Pawns.bishop);
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
		if(from.hasSameDescendingDiagonal(to) && from.isOnLeft(to)) {
			pi = from.descendingDiagonalRightIterator();
		}
		else if(from.hasSameDescendingDiagonal(to) && from.isOnRight(to)) {
			pi = from.descendingDiagonalLeftIterator();
		}
		else if(from.hasSameDescendingDiagonal(to) && from.isOnLeft(to)) {
			pi = from.ascendingDiagonalRightIterator();
		}
		else if(from.hasSameDescendingDiagonal(to) && from.isOnRight(to)) {
			pi = from.ascendingDiagonalLeftIterator();
		}
		
		return pi;
	}
}
