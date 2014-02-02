/* Steven Gerhard
 * Node Class
 * for StockTran 
 */

import java.math.BigDecimal;

public class Node {  
  private BigDecimal price, amt;
  private int day;
  private Node next;  
  
  public Node(){
	  next = null;
	  price = null;
	  amt = null;

  }
  
  // Accessor Methods
  public BigDecimal getPrice(){
	  return price;
  }
  
  public BigDecimal getAmt(){
	  return amt;
  }
  
  public int getDay(){
	  return day;
  }
  
  public Node next(){
	  return next;
  }
  
  // Mutator methods
  public void clearNode(){
	  price = null;
	  amt = null;
  }
  
  public void setPrice(BigDecimal P){
	  price = P;
  }
  
  public void setAmt(BigDecimal A){
	  amt = A;
  }
  
  public void setDay(int D){
	  day = D;
  }
  
  public void setNext(Node N){
	  next = N;
  }
  
  public void printNode(){
	  System.out.println("Amt: " + String.valueOf(amt)+" Price: " + String.valueOf(price));
			   
  }
  
  public void printDay(){
	  System.out.println(day);
  }
}