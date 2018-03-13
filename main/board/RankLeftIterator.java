package board;

public class RankLeftIterator implements PositionIterator {
	Position q;
	
	RankLeftIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.file() >= 0;
	}

	@Override
	public Position next() {
		return q.set(q.rank(),q.file()-1);
	}
}
