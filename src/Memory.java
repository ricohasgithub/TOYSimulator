
public class Memory{
	
	private final int SIZE = 256;
	private Link[] queue;
	
	public Memory () { 
		queue = new Link[SIZE];
	}
	
	public void insert (int memLoc, String cmd) {
		queue[memLoc] = new Link(memLoc, cmd);
	}
	
	public Link getValFromIndex (int index) {
		if (queue[index] == null) {
			throw new NullPointerException("Link is Missing or Deleted");
		}
		return queue[index];
	}
	
	public void removeLink (int index) {
		Link del = queue[index];
		del = null;
	}
	
	public int getSize () {
		return SIZE;
	}
	
}
