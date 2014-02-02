/** @author Steven Gerhard
 *  ID: sjg10009
 *  5-1 Diophantine Equation Solver
 *  Using a Heap Priority Queue (from book)
 *  stored in an ArrayIndexList
 */

import java.security.InvalidKeyException;
import java.util.Scanner;

public class EquationSolver {
	private HeapPriorityQueue<Long,MyEntry<String,Integer>> LHS,RHS;	// stores solutions
	private long[] powerOf5;	// all possible n^5 numbers
	
	public EquationSolver() {
		LHS = new HeapPriorityQueue<Long,MyEntry<String,Integer>>();
		RHS = new HeapPriorityQueue<Long,MyEntry<String,Integer>>();	
	}
	
	/** generates all possible solutions */
	public void generateSolutions(int max) throws InvalidKeyException, 
					InvalidPositionException, BoundaryViolationException, 
							EmptyPriorityQueueException, EmptyTreeException{
		powerOf5 = allPow5(max);
		long num1,num2,num3,resLeft,resRight;
		//0<i<=j<=k<=max; i^5=num1,j^5=num2,k^5=num3; i->A,j->B,k->C; i->D,j->E,k->F
		for(int i=1;i<=max;i++){
			for(int j=i;j<=max;j++){
				for(int k=j;k<=max;k++){
					String solnA,solnB;
					solnA = "A:" + String.valueOf(i) + " " + 
							"B:" + String.valueOf(j) + " " + 
							"C:" + String.valueOf(k) + " ";
					solnB = "D:" + String.valueOf(i) + " " +
							"E:" + String.valueOf(j) + " " +
							"F:" + String.valueOf(k);
					num1=powerOf5[i];
					num2=powerOf5[j];
					num3=powerOf5[k];
					// A^5 +B^5 +C^5 
					resLeft=num1+num2+num3;
					// F^5-E^5-D^5
					resRight=num3-num2-num1;
					LHS.insert(resLeft, new MyEntry<String,Integer>(solnA,k));
					if(resRight>=0)RHS.insert(resRight,new MyEntry<String,Integer>(solnB,i));
				}
			}
		}
	}
	
	/** returns the left hand side. */
	public HeapPriorityQueue<Long,MyEntry<String,Integer>> getLeft() { return LHS; }
	/** returns the right hand side */
	public HeapPriorityQueue<Long,MyEntry<String,Integer>> getRight() { return RHS; }
	
	/** Creates a long array of all possible
	 *  values of x^5
	 *  quicker than computing each time
	 */
	public static long[] allPow5(int numElem){
		long[] ans = new long[numElem+1];
		for(int i = 0; i<= numElem; i++){
			ans[i] = (long) (i) * (i) * (i) * (i) * (i);
		}
		return ans;
	}
	
	/** returns all solutions of A^5 + B^5 + C^5 + D^5 + E^5 = F^5
	 *  for A <= B <= C <= D <= E <= F <= N
	 *  determined by max input N
	 */
	public static void main(String[] args) throws InvalidKeyException, 
					InvalidPositionException, BoundaryViolationException, 
							EmptyPriorityQueueException, EmptyTreeException{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter max F:");
		
		boolean hasAns = false;
		EquationSolver eq = new EquationSolver();
		eq.generateSolutions(input.nextInt());
		HeapPriorityQueue<Long,MyEntry<String,Integer>> right = eq.getRight();
		HeapPriorityQueue<Long,MyEntry<String,Integer>> left = eq.getLeft();
		
		while(!(left.isEmpty() || right.isEmpty())){
			if (left.min().getKey() < right.min().getKey()) {
				left.removeMin();
			}
			else
			if (left.min().getKey() > right.min().getKey()) {
				right.removeMin();
			}
			else
			if (left.min().getKey().equals(right.min().getKey())) {
				if(left.min().getValue().getValue() <= right.min().getValue().getValue()){
					System.out.println("Solution Found:");
					System.out.println(left.min().getValue().getKey() + right.min().getValue().getKey());
				}
				hasAns = true;
				left.removeMin();
				right.removeMin();
			}
		}
		if(!hasAns) System.out.print("No Solution");
		input.close();
	}
}
