package board;

public class FileDownIterator implements PositionIterator {
	Position q;
	
	FileDownIterator(Position q){
		this.q = q.clone();
	}

	@Override
	public boolean hasNext() {
		return q.rank() >= 0;
	}

	@Override
	public Position next() {
		return q.set(q.rank()-1,q.file());
	}
	
}
