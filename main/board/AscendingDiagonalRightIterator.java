package board;

public class AscendingDiagonalRightIterator implements PositionIterator {
	Position q;
	
	AscendingDiagonalRightIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank()< Board.SIZE && q.file() < Board.SIZE;
	}

	@Override
	public Position next() {
		return q.set(q.rank()+1,q.file()+1);
	}
}
