package board;

public class DescendingDiagonalLeftIterator implements PositionIterator {
	Position q;
	
	DescendingDiagonalLeftIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank()< Board.SIZE  && q.file()>= 0;
	}

	@Override
	public Position next() {
		return q.set(q.rank()+1,q.file()-1);
	}
}
