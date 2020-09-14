package Project;

import java.util.Scanner;

public class HammingCodeTester extends HammingCode{
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the data word to be encoded:");
		int size = scan.nextInt();
		int data_word[] = new int[size];
		
		for(int i=data_word.length-1 ; i >=0 ; i--) {
			System.out.println("Enter bit no. " + (i+1) + ":");
			data_word[i]= scan.nextInt();
		}
		
		System.out.println("The data word you entered is:");
		for(int i=data_word.length-1 ; i >=0 ; i--) {
			System.out.print(data_word[i]);
		}
		System.out.println();
		
		int code_word[] = generateCodeWord(data_word);
		
		System.out.println("The generated codeword is:");
		for(int i=code_word.length-1 ; i >=0 ; i--) {
			System.out.print(code_word[i]);
		}
		System.out.println();
		
		System.out.println("Please enter the position of the bit you would like to change and check for error in the receiver's site (If you do not want to cause any errors please type 0):");
		int error = scan.nextInt();
		if(error != 0) {
			code_word[error-1] = (code_word[error-1]+1)%2;
		}
		System.out.println("Sent codeword is:");
		for(int i=code_word.length-1 ; i >=0 ; i--) {
			System.out.print(code_word[i]);
		}
		System.out.println();
		// The number of parity bits added to the data word can be calculated
		// Subtract the length of codeword from the length of the data word.
		receivedCode(code_word, code_word.length - data_word.length);
	}
}