public class Link {

	int key;
	char opcode;
	String value;
	int intValue;

	public Link (int key, String value) {
		// For use in memory
		this.key = key;
		this.value = value;
		opcode = value.charAt(0);
	}
	
	public Link (int intValue) {
		// For use in register
		this.intValue = intValue;
	}
	
	public int getKey () {
		return key;
	}
	
	public String getValue () {
		return value;
	}
	
	public int getIntValue () {
		return intValue;
	}
	
	public String toString () {
		return "Memory Location: " + key + "Value Stored: " + value;
	}

}