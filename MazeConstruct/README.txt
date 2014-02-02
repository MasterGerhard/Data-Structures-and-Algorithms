5-1 Diophantine Equation Solver
By Steven Gerhard

compile src and run EquationSolver.class

The Diophantine equations have long attracted the attention of mathematiciansand computer scientists. Many fifth-order Diophantine equations do have integral solutions. For example, the 5-1 fifth-order equation (A^5)+(B^5)+(C^5)+(D^5)+(E^5) = (F^5) has exactly one integral solution that satisfies 0<=A<=B<=C<=D<=E<=F<=N, where N is as small as 75. 

Using Heap-Sort implemented with a  heap-based priority queue, solutions for 5-1 Diophantine equations can be found in O( (N^3)logN ) time. 

WARNING: Inputs of N larger than 100 may take a considerable amount of time, or produce a java.lang.OutOfMemoryError