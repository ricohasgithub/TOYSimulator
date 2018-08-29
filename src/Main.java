import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Memory memory = new Memory();
		
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
		
	}
	
	private static void operate (int index, String cmd) {
		// Recursive method to implement the specific opcode at the specified location of memory
		char opcode = cmd.charAt(0);
		if (opcode == '1') {
			
		}
	}
	
}
