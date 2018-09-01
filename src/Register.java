
public class Register {
	
	private final int SIZE = 16;
	private int currIndex;
	private Link[] queue;
	
	public Register () {
		queue = new Link[SIZE];
		currIndex = 0;
	}
	
	public void changeValueAt (int index, int intValue) {
		queue[index] = new Link(index, Integer.toHexString(intValue));
	}
	
	public Link getValFromIndex (int index) {
		if (queue[index] == null) {
			throw new NullPointerException("Link is Missing or Deleted");
		}
		return queue[index];
	}

	public Link getValFromCurrIndex () {
		if (queue[currIndex] == null) {
			throw new NullPointerException("Link is Missing or Deleted");
		}
		return queue[currIndex];
	}
	
	public void setIndex (int newIndex) {
		currIndex = newIndex;
	}
	
	public void removeLink (int index) {
		Link del = queue[index];
		del = null;
	}
	
	public int getSize () {
		return SIZE;
	}
	
}
