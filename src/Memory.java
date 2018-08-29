import java.util.ArrayList;

public class Memory {
	
	private ArrayList<Link> memory;
	
	public class Link {
		
		int key;
		char opcode;
		String value;
		
		public Link (int key, String value) {
			this.key = key;
			this.value = value;
			opcode = value.charAt(0);
		}
		
		public String toString () {
			return "Memory Location: " + key + "Value Stored: " + value;
		}
		
	}
	
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
}
