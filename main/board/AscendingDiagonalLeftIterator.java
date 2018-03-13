package board;

public class AscendingDiagonalLeftIterator implements PositionIterator {
	Position q;
	
	AscendingDiagonalLeftIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank() >= 0 && q.file() >= 0;
	}

	@Override
	public Position next() {
		return q.set(q.rank()-1,q.file()-1);
	}
}
