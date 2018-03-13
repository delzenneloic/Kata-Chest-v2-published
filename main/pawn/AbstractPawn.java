package pawn;

import board.Board;
import board.Position;

public abstract class AbstractPawn {
	Colors color;
	Pawns type;
	
	public AbstractPawn(Colors color,Pawns type){
		this.color = color;
		this.type = type;
	}
	
	public char pawnRepresentation() {
		switch(this.type) {
			case pawn:
				return 'p';
			case rook:
				return 'R';
			case knight:
				return 'N';
			case bishop:
				return 'B';
			case queen:
				return 'Q';
			case king:
				return 'K';
			default:
				return '?';
		}
	}
	
	abstract public boolean allows(Position from,Position to,Board board);
	
	public char colorRepresentation() {
		return this.color == Colors.dark ? 'x' : '0';
	}
	
	public Colors color() {
		return this.color;
	}
	
	public boolean isLight() {
		return this.color == Colors.light;
	}
	
	public boolean isDark() {
		return this.color == Colors.dark;
	}
	
	public boolean isRook() {
		return this.type == Pawns.rook;
	}
	
	public boolean isPawn() {
		return this.type == Pawns.pawn;
	}
	
	public boolean isBishop() {
		return this.type == Pawns.bishop;
	}
	
	public boolean isQueen() {
		return this.type == Pawns.queen;
	}
	
	public boolean isKnight() {
		return this.type == Pawns.knight;
	}
	
	public boolean isKing() {
		return this.type == Pawns.king;
	}
}
