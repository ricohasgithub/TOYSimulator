public class Link {

	int key;
	char opcode;
	String value;

	public Link (int key, String value) {
		this.key = key;
		this.value = value;
		opcode = value.charAt(0);
	}
	
	public int getKey () {
		return key;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString () {
		return "Memory Location: " + key + "Value Stored: " + value;
	}

}