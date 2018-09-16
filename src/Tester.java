import java.util.HashMap;

public class Tester {

	public static HashMap<Character, Integer> HexDec;
	public static Memory memory;
	public static Register register;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initHexDec();
		memory = new Memory();
		register = new Register();
		
		memory.insert(10, "8A15");
		memory.insert(11, "8B16");
		memory.insert(12, "1CAB");
		memory.insert(13, "9C17");
		memory.insert(14, "0000");
		memory.insert(15, "0008");
		memory.insert(16, "0005");
		memory.insert(17, "000D");
		
		System.out.println(memory.getValFromIndex(10));
		System.out.println(memory.getValFromIndex(11));
		System.out.println(memory.getValFromIndex(12));
		System.out.println(memory.getValFromIndex(13));
		System.out.println(memory.getValFromIndex(14));
		System.out.println(memory.getValFromIndex(15));
		System.out.println(memory.getValFromIndex(16));
		System.out.println(memory.getValFromIndex(17));
		
		run(10, memory.getValFromIndex(10).getValue());
		
		System.out.println(register.getValFromIndex(10));
		System.out.println(register.getValFromIndex(11));
		System.out.println(register.getValFromIndex(12));
		
		
		System.out.println(register.getValFromIndex(2));
	}
	
	private static void initHexDec () {
		// Initializing and putting the values into HexDec
		HexDec = new HashMap<Character, Integer>();
		HexDec.put('0', 0);
		HexDec.put('1', 1);
		HexDec.put('2', 2);
		HexDec.put('3', 3);
		HexDec.put('4', 4);
		HexDec.put('5', 5);
		HexDec.put('6', 6);
		HexDec.put('7', 7);
		HexDec.put('8', 8);
		HexDec.put('9', 9);
		HexDec.put('A', 10);
		HexDec.put('B', 11);
		HexDec.put('C', 12);
		HexDec.put('D', 13);
		HexDec.put('E', 14);
		HexDec.put('F', 15);
	}

	private static void run (int index, String cmd) {
		// Recursive method to implement the specific opcode at the specified location of memory
		char opcode = cmd.charAt(0);
		if (opcode == '0') {
			// Halt - End recursive call
			return;
		} else if (opcode == '1') {
			// RR R[d] = R[1] + R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int sum = convertHexToDec(register.getValFromIndex(source1).getValue())
					+ convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, sum);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '2') {
			// RR R[d] = R[1] - R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int diff = convertHexToDec(register.getValFromIndex(source1).getValue())
					- convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, diff);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		}  else if (opcode == '3') {
			// RR R[d] = R[1] & R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int and = convertHexToDec(register.getValFromIndex(source1).getValue())
					& convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, and);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '4') {
			// RR R[d] = R[1] ^ R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int xor = convertHexToDec(register.getValFromIndex(source1).getValue())
					^ convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, xor);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '5') {
			// RR R[d] = R[1] << R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int shiftL = convertHexToDec(register.getValFromIndex(source1).getValue())
					<< convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, shiftL);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		}  else if (opcode == '6') {
			// RR R[d] = R[1] >> R[2];
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int source1 = convertHexToDec(cmd.charAt(2) + "");
			int source2 = convertHexToDec(cmd.charAt(3) + "");
			int shiftR = convertHexToDec(register.getValFromIndex(source1).getValue())
					>> convertHexToDec(register.getValFromIndex(source2).getValue());
			register.changeValueAt(dest, shiftR);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '7') {
			// A R[d] = addr
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int addr = Integer.parseInt(cmd.charAt(2) + "" + cmd.charAt(3));
			register.changeValueAt(dest, addr);
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '8') {
			// A R[d] = M[addr]
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int addr = Integer.parseInt(cmd.charAt(2) + "" + cmd.charAt(3));
			register.changeValueAt(dest, convertHexToDec(memory.getValFromIndex(addr).getValue()));
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		} else if (opcode == '9') {
			// A M[addr] = R[d]
			int dest = convertHexToDec(cmd.charAt(1) + "");
			int addr = Integer.parseInt(cmd.charAt(2) + "" + cmd.charAt(3));
			memory.insert(addr, register.getValFromIndex(dest).getValue());
			index++;
			run(index, memory.getValFromIndex(index).getValue());
		}
	}

	private static int convertHexToDec (String hex) {
		// Method to convert hexadecimal numbers (passed in as Strings) to base 10 integers
		int dec = 0;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			int val = (int) (HexDec.get(c) * Math.pow(16, hex.length()-1 - i));
			dec += val;
		}
		return dec;
	}

}
