import java.util.ArrayList;
import java.util.Iterator;

public class Memory{
	
	private final int SIZE = 256;
	private int currIndex;
	private Link[] memory;
	
	public Memory () { 
		memory = new Link[SIZE];
		currIndex = 0;
	}
	
	public void insert (int memLoc, String cmd) {
		memory[memLoc] = new Link(memLoc, cmd);
	}
	
	public String getValFromIndex (int index) {
		if (memory[index] == null) {
			throw new NullPointerException("Link is Missing or Deleted");
		}
		return memory[index].value;
	}
	
	public void removeLink (int index) {
		Link del = memory[index];
		del = null;
	}
	
	public int getSize () {
		return SIZE;
	}
	
}
