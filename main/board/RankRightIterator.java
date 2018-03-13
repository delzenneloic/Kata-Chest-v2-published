package board;

public class RankRightIterator implements PositionIterator {
	Position q;
	
	RankRightIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.file() < Board.SIZE;
	}

	@Override
	public Position next() {
		return q.set(q.rank(),q.file()+1);
	}
	
}
