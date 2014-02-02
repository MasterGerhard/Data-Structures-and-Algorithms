/**
 * @author Steven Gerhard
 * ID: sjg10009
 */

import java.util.Arrays;
import java.util.Scanner;

public class StackANSVP {
	private Stack<Integer> _S;

	public StackANSVP(int[] nums){
	_S = new NodeStack<Integer>();	// stack for comparison
	String[] ans = new String[nums.length];		// resultant array
	for(int i = 0; i < nums.length; i++){	// for every elem in nums
		while(!_S.isEmpty() && _S.top() >= nums[i] )
			_S.pop();	//	if S.top is greater than nums its useless
		if(_S.isEmpty())
			ans[i] = "-";	// nums[i] has no preceding smaller value
		else
			ans[i] = String.valueOf(_S.top());
		_S.push(nums[i]);	// nearest smaller value is top of S
		}
	System.out.println("The nearest previous smaller values for this sequence:");
	System.out.println(Arrays.toString(ans));
	}

	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the sequence:");
	String hold = input.nextLine().replaceAll(",", " ");	// removes commas from input
	String[] read = hold.split("\\s+");	// stores input as string array
	
	int[] nums = new int[read.length];
	for (int i = 0; i < read.length; i++)	// converts string array to num array
		nums[i] = Integer.parseInt(read[i]);
	StackANSVP run = new StackANSVP(nums);	// passes num array to StackANSVP
	input.close();
	}
}
