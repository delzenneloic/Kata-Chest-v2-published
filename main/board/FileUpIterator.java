package board;

public class FileUpIterator implements PositionIterator {
	Position q;
	
	FileUpIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank() < Board.SIZE;
	}

	@Override
	public Position next() {
		return q.set(q.rank()+1,q.file());
	}
	
}
