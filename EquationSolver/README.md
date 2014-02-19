5-1 Diophantine Equation Solver
By Steven Gerhard

compile src and run EquationSolver.class

The 2-1 third-order Diophantine equation A^3 + B^3 = C^3, a special instance of Fermat’s
Last Theorem, was proved in 1994 to not have any positive integral solution. Many fifth-order Diophantine equations do have integral solutions. For example, the 5-1 fifth-order equation (A^5)+(B^5)+(C^5)+(D^5)+(E^5) = (F^5) has an integral solution that satisfies 0<=A<=B<=C<=D<=E<=F<=N, where N is as small as 75. 

A straightforward approach to solving a 5-1 equation is to first precompute all values of X^5 and store them in an array. Then for each 5 tuple (A,B,C,D,E),
check whether there exists some F such that the equation holds. This would take O(N^5) time which may have trouble finding even one solution on a typical personal computer.

A more efficient algorithm sorts all the values of A^5 + B^5 + C^5 and
F^5 - (D^5 + E^5). The values are compared one at a time (similar to way the pointers work during the merging procedure in mergeSort) to determine if a value in the first group is equal to a value in the second group.

Using Heap-Sort implemented with a  heap-based priority queue, solutions for 5-1 Diophantine equations can be found in O( (N^3)logN ) time. 

WARNING: Inputs of N larger than 100 may take a considerable amount of time, or produce a java.lang.OutOfMemoryError depending on your computer.
