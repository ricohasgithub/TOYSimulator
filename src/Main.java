import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

public class Main {

	public static HashMap<Character, Integer> HexDec;
	public static Memory memory;
	public static Register register;

	public static void main(String[] args) throws IOException {

		initHexDec();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		memory = new Memory();
		register = new Register();

		while (true) {
			/*  Intakes Basic Input (i.e. Memory Location + 4 digit hexadecimal numbers)
			    Example: 10 7C0A
				10 - Memory Location
				7C0A - Either Instruction or Data depending on the state of the machine
			 */
			String line = br.readLine();

			if (line.equals("0000")) {
				break;
			}

			String[] words = line.split(" ");

			int memLoc = Integer.parseInt(words[0]);
			String cmd = words[1];

			memory.insert(memLoc, cmd);
		}

		operate(0, memory.getValFromIndex(0).getValue());

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

	private static void operate (int index, String cmd) {
		// Recursive method to implement the specific opcode at the specified location of memory
		char opcode = cmd.charAt(0);
		if (opcode == '1') {
			
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
