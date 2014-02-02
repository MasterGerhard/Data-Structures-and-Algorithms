/* Steven Gerhard
 * ID: sjg10009
 * PuzzleSolve.java
 */

import java.util.Scanner;

// solves string summation puzzles
public class PuzzleSolve{
	private SLinkedList _strParts;
	private String _userInput,_alphabet; // the original puzzle input by user
	private int _k,_numSolutions;
	
	
	// constructor 
	public PuzzleSolve(String s){
		// To set up the SolvePuzzle parameters:
		_userInput = s;	// saves unedited puzzle
		_strParts = readPuzzle(s);	// creates a list, each node one part of puzzle, remove "+,="
		_alphabet = removeDup(_strParts.getList());	// the unique letters of the puzzle
		_k = _alphabet.length();	// number of unique letters in puzzle
		SLinkedList U =  new SLinkedList();	// Creates SList U of ints [0-9]
		for(int i = 0; i<10; i++)
			U.addFirst(String.valueOf(i));
		SLinkedList S = new SLinkedList();	// SolvePuzzle Parameter
		_numSolutions = 0; // used to tell if solution found
		System.out.println("Unique Letters: " + _alphabet);
		if(_k > 10 || _k < 1){
			// only have 10 digits to work with
			System.out.println("Puzzle Not Solvable");
		}
		else{
			SolvePuzzle(0,S,U);
		}
		if(_numSolutions == 0){
				System.out.println("No Solutions Exist");
		}
	}
	
	
	// Solve Puzzle Method
	// enumerates all k length permutations of U
	// tests those permutations to check if solution
	public void SolvePuzzle(int d, SLinkedList S, SLinkedList U){
		SLinkedList subSet = S;
		SLinkedList unUsed = U;
		if(d == _k){
				Solution(subSet);
				return;
			}
		for(int i = 0; i < unUsed.getSize(); i++){
			subSet.addFirst(unUsed.getHead());
			unUsed.removeFirst();
			SolvePuzzle(d+1,subSet,unUsed);
			unUsed.addLast(subSet.getHead());
			subSet.removeFirst();
		
		}
		return;
	}
	
	
	// returns true 
	// and prints
	// if the integers solve the puzzle
	public void Solution(SLinkedList sol){
		String solution = sol.getList();
		String result = _userInput;
		for(int i = 0; i < _k; i++){	// for 0 to < k
			String al = _alphabet.substring(i,i+1);	// pick one letter from puzzle
			String so = solution.substring(i,i+1); // pick one number from soln
			result = result.replaceAll(al,so);	// replace all of that letter with number solution
			}		
		result = result.replaceAll("\\s", "");
		
		// the rest of this method removes operators from result
		// converts to an int array
		// adds all elements except last together
		// and checks if they equal last
		String[] almost = result.split("[\\+=]");
		int[] ans = new int[almost.length];
		for(int i = 0; i < ans.length; i++){
			ans[i] = Integer.parseInt(almost[i]);
		}
		int total = ans[ans.length-1];
		int sums = 0;
		for(int i = 0; i < ans.length - 1;i++){
			sums = sums + ans[i];
		}
		if(sums == total){
			if(_numSolutions == 0)
				System.out.println("Solution Found:");
			System.out.println(solution);
			_numSolutions++;
		}
		return;
	}
	
	
	// Reads puzzle string from input
	// Stores in a LinkedList
	public SLinkedList readPuzzle(String s){
		SLinkedList result = new SLinkedList();
		String[] read = s.split("\\s+");
		for(int i=0; i<read.length; i+=2)
	          result.addFirst(read[i]);
		return result;
	}

	
	// gives ability to print lists
	public void printSList(SLinkedList list){
		list.printList();
	}
	
	
	// removes duplicate characters in given string
	// and reverses string (wanted _alphabet in reverse order)
		public static String removeDup(String s) {
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        String si = s.substring(i, i+1);
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }    
	    }
	    String ans = noDupes.toString();
	    String reverse = "";
        for(int i = ans.length() -1; i>=0; i--){
            reverse = reverse + ans.charAt(i);
        }
       return reverse;
	}
		

	// PuzzleSolve.java
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Puzzle: (String + String = String)");
		System.out.println("(It is possible to add more than two strings)");
		PuzzleSolve puzzle = new PuzzleSolve(input.nextLine());
		input.close();
	}
}
