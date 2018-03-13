package files;

import pawn.AbstractPawn;
import pawn.Bishop;
import pawn.Pawn;
import pawn.Queen;
import pawn.Rook;
import pawn.Colors;
import pawn.King;
import pawn.Knight;

class PawnBuilder {
	static AbstractPawn build(String type,String color) {
		switch(type) {
			case "pawn":
				return new Pawn(PawnBuilder.getColorValue(color));
			case "rook":
				return new Rook(PawnBuilder.getColorValue(color));
			case "knight":
				return new Knight(PawnBuilder.getColorValue(color));
			case "bishop":
				return new Bishop(PawnBuilder.getColorValue(color));
			case "king":
				return new King(PawnBuilder.getColorValue(color));
			case "queen":
				return new Queen(PawnBuilder.getColorValue(color));
		}
		return null;
	}
	
	private static Colors getColorValue(String string) {
		switch(string) {
			case "dark":
				return Colors.dark;
			case "white":
				return Colors.light;
		}
		return null;
	}
}
