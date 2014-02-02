ANSVP
By Steven Gerhard

compile src and run StackANSVP.class

The All Nearest Smaller Values Problem, ANSVP, is defined as follows: For eachnumber in a sequence, search among the previous positions for the last number that is smaller.

For a given input sequence, the previous nearest smaller values are returned as an array. Using Stacks this is solved in O(N) time.

The input must be a series of numbers separated by spaces or commas.

An Example:
Input
0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
Output
[-, 0, 0, 4, 0, 2, 2, 6, 0, 1, 1, 5, 1, 3, 3, 7]


