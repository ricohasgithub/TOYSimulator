import java.util.ArrayList;
import java.util.Iterator;

public class Memory implements Iterable<Link>{
	
	private ArrayList<Link> memory;
	
	public Memory () { 
		memory = new ArrayList<Link>();
	}
	
	public void insert (int memLoc, String cmd) {
		memory.add(new Link(memLoc, cmd));
	}
	
	public String getValFromIndex (int index) {
		if (memory.get(index) == null) {
			throw new NullPointerException("Link is Missing or Deleted");
		}
		return memory.get(index).value;
	}
	
	public void removeLink (int index) {
		Link del = memory.get(index);
		del = null;
	}
	
	public Iterator<Link> iterator() {
		return memory.iterator();
	}
}
