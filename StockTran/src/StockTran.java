/** @author Steven Gerhard
 *  ID: sjg10009
 *  CSE 2100
 *  Lab 4
 *  Stock Buy/Sell Simulator
 *  Using First In First Out
 *  to determine capital gains/losses
 *  Implemented in java I/O console
 */

import java.util.Scanner;
import java.math.BigDecimal;

public class StockTran {
	private BigDecimal cg;
	private CircleQueue Q;
	private int numShares;
	
	public StockTran(){
		Q = new CircleQueue();
		cg =  new BigDecimal("0");	// capital gains
		numShares = 0; 				// total number of shares
	}
	
	// buy shares
	public void buy(BigDecimal amt, BigDecimal price){
		Q.enqueue(amt,price);
		numShares = numShares + amt.intValue();
	}
	
	// sell shares
	public void sell(BigDecimal A, BigDecimal P){
		BigDecimal amt = A;
		BigDecimal price = P;
		
		if(A.compareTo( new BigDecimal(numShares)) > 0){
			throw new EmptyQueueException("not enough shares to sell");
		}
		// if the amt of shares in head node
		// is less than amt being sold
		// compute the capital gains and dequeue
		while(Q.front().getAmt().compareTo(amt) < 0){
			BigDecimal sp = price.subtract(Q.head.getPrice());
			cg = cg.add(Q.head.getAmt().multiply(sp));
			amt = amt.subtract(Q.head.getAmt());
			Q.dequeue();
		}
		
		BigDecimal spp = price.subtract(Q.head.getPrice());
		cg = cg.add(amt.multiply(spp));
		Q.sellShares(amt);
		numShares = numShares - A.intValue();

		
	}
	
	// returns the capital gains
	public String gains(){
		return String.valueOf(cg);
	}
	
	public static void main(String[] args){
		System.out.println("enter b # #, s # #, or c for capital gains");
		System.out.println("press q to quit");
		StockTran trade = new StockTran();
		boolean run = true;
		String in = "";
		BigDecimal amt;
		BigDecimal price;
		Scanner input = new Scanner(System.in);
		while(run){
			if(input.hasNext()){
				in = input.next();
			
				if(in.equals("q")){
					run = false;
				}
				else if(in.equals("s") && input.hasNextBigDecimal()){
					amt = input.nextBigDecimal();
					if(input.hasNextBigDecimal()) {
					price = input.nextBigDecimal();
					trade.sell(amt, price);
					}
					amt = null;
					price = null;
				}
				else if(in.equals("b") && input.hasNextBigDecimal()){
					amt = input.nextBigDecimal();
					if(input.hasNextBigDecimal()) {
					price = input.nextBigDecimal();
					trade.buy(amt, price);
					}
					amt = null;
					price = null;
				}
				else if(in.equals("c")){
					System.out.println(trade.gains());
				}
			}
		}
		input.close();
	}
}
