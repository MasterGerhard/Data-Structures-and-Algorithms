StockTran
By Steven Gerhard

compile src and run StockTran.class

A standard accounting principle for identifying which sharesof a stock were sold in such a case is to use a FIFO protocol - the shares sold are the ones that have been held the longest

Input Example:

b 12 50 // buy 12 shares at $50 a share
b 5 10  // buy 5 shares at $10 a share
s 3 75  // sell 3 shares at $75 a share
c	// system outputs capital gains => (3*-50)+(3*75) = 75
s 14 10 // sell 14 shares at $10 a share
c	// system outputs capital gains => (9*-50)+(5*-10)+(14*10)+75 = -285
s 1 10  // system outputs Invalid Input: Not Enough Shares to Sell
asffe   // Bad input, system waits for next line
q 	// quits the program
