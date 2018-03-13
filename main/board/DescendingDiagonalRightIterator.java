package board;

public class DescendingDiagonalRightIterator implements PositionIterator {
	Position q;
	
	DescendingDiagonalRightIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank()>=0 && q.file()< Board.SIZE;
	}

	@Override
	public Position next() {
		return q.set(q.rank()-1,q.file()+1);
	}
}
