MazeConstruct
By Steven Gerhard

compile src and run MazeConstruct.class

Sample inputs and outputs are given in .txt files.

MazeConstruct creates an n by n size text based maze based on the input n, and the weights of each maze wall. The maze is constructed by finding a minimum spanning tree T for input G and removing all the walls corresponding to edges in T. The minimum spanning tree is found using the Prim-Jarnik MST algorithm.