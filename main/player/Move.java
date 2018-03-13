package player;

import board.Board;
import board.Position;

public class Move {
	private Position from;
	private Position to;
	
	Move(Position from,Position to){
		this.from = from;
		this.to = to;
	}
	
	public Position from() {
		return this.from;
	}
	
	public Position to() {
		return this.to;
	}
	
	static Move parseMove(String text) {
		if(text.length() == 0)
			return null;
		
		int a1=0;
		int a2=0;
		int b1=0;
		int b2=0;
		
		int index=0;
		
		if(text.charAt(index) != '(') {
			return null;
		}
		
		String tmp = "";
		while(++index < text.length()) {
			if(Character.isDigit(text.charAt(index)))
				tmp+= text.charAt(index);
			else
				break;
		}
		a1 = Integer.parseInt(tmp);
		
		if(text.charAt(index) != ',') {
			return null;
		}
		
		tmp = "";
		while(++index < text.length()) {
			if(Character.isDigit(text.charAt(index)))
				tmp+= text.charAt(index);
			else
				break;
		}
		a2 = Integer.parseInt(tmp);
		
		if(text.charAt(index) != ')') {
			return null;
		}
		
		if(text.charAt(++index) != ',') {
			return null;
		}
		
		if(text.charAt(++index) != '(') {
			return null;
		}
		
		tmp = "";
		while(++index < text.length()) {
			if(Character.isDigit(text.charAt(index)))
				tmp+= text.charAt(index);
			else
				break;
		}
		b1 = Integer.parseInt(tmp);
		
		if(text.charAt(index) != ',') {
			return null;
		}
		
		tmp = "";
		while(++index < text.length()) {
			if(Character.isDigit(text.charAt(index)))
				tmp+= text.charAt(index);
			else
				break;
		}
		b2 = Integer.parseInt(tmp);
		
		if(text.charAt(index) != ')') {
			return null;
		}
		
		return new Move(Board.position(a1,a2),Board.position(b1,b2));
	}
	
	public String toString() {
		return this.from + "," + this.to;
	}
}
