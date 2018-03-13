package board;
import pawn.Colors;
import board.Board;

public class Position {
	private int rank; // Represent a line.
	private int file; // represent a column
	
	Position(int no) {
		this.rank = no / Board.SIZE;
		this.file = no % Board.SIZE;
	}
	
	Position(int rank,int file){
		this.rank = rank;
		this.file = file;
	}
	
	public int rank() {
		return this.rank;
	}
	
	public Position set(Position q) {
		this.rank = q.rank;
		this.file = q.file;
		return this;
	}
	
	public Position set(int rank,int file) {
		this.rank = rank;
		this.file = file;
		return this;
	}
	
	public int file() {
		return this.file;
	}
	
	public char rankRepresentation() {
		return (char) ('1' + this.rank);
	}
	
	public char fileRepresentation() {
		return (char) ('A' + this.file);
	}
	
	public Colors color() {
		return (this.rank + this.file) % 2 == 0 ? Colors.dark : Colors.light;
	}
	
	public boolean equals(Position q) {
		return this.hasSameRank(q) && this.hasSameFile(q);
	}
	
	public boolean isOnLeft(Position q) {
		return this.file < q.file;
	}
	
	public boolean isOnRight(Position q) {
		return this.file > q.file;
	}
	
	public boolean isAbove(Position q) {
		return this.rank > q.rank;
	}
	
	public boolean isUnder(Position q) {
		return this.rank < q.rank;
	}
	
	public boolean hasSameRank(Position q) {
		return this.rank == q.rank;
	}
	
	public boolean hasSameFile(Position q) {
		return this.file == q.file;
	}
	
	public boolean hasSameDescendingDiagonal(Position q) {
		return this.rank + this.file == q.rank + q.file;
	}
	
	public boolean hasSameAscendingDiagonal(Position q) {
		return this.rank - this.file == q.rank - q.file;
	}
	
	public int no() {
		return this.rank * Board.SIZE + this.file;
	}
	
	public Position clone() {
		return new Position(this.rank,this.file);
	}
	
	public FileUpIterator fileUpIterator() {
		return new FileUpIterator(this);
	}
	
	public FileDownIterator fileDownIterator() {
		return new FileDownIterator(this);
	}
	
	public RankLeftIterator rankLeftIterator() {
		return new RankLeftIterator(this);
	}
	
	public RankRightIterator rankRightIterator() {
		return new RankRightIterator(this);
	}
	
	public AscendingDiagonalLeftIterator ascendingDiagonalLeftIterator() {
		return new AscendingDiagonalLeftIterator(this);
	}
	
	public AscendingDiagonalRightIterator ascendingDiagonalRightIterator() {
		return new AscendingDiagonalRightIterator(this);
	}
	
	public DescendingDiagonalLeftIterator descendingDiagonalLeftIterator() {
		return new DescendingDiagonalLeftIterator(this);
	}
	
	public DescendingDiagonalRightIterator descendingDiagonalRightIterator() {
		return new DescendingDiagonalRightIterator(this);
	}
	
	public String toString() {
		return "(" + this.rank + "," + this.file + ")";
	}
}
