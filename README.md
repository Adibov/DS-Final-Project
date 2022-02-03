# DS-Final-Project
Date Location, Data Structures and Algorithms final project implemented in Java

# Description
Date Location is the final project of Data Structures and Algorithms course in fall 2021 semester at AUT.  
In this project we had to implement a system which would get a modeled graph of a city junctions besides the nodes of candidate people whom wanted to go to the best cafe (by best, we mean the cafe which the sum of differences between the distance to be traveled by candidates is minimized).

To solve this problem, we had to implement three phase in which we solve some part of the problem.

## Phase 0
In this phase, first we need to input a modeled graph and store it in our system. To do this, we use hash map to map each node label to its corresponding node. Then by using an dynamic list (specifically ArrayList in Java), we store adjacent edges to each node.  
After that, we needed to run DFS algorithm to achieve DFS sequence.

## Phase 1
After saving graph and accomplishing DFS algorithm, we had to iterate over all nodes in the order of DFS sequence and for each node, calculate the score of the corresponding node, based on a given formula. To calculate this score, we had to have distance between candiadte nodes and current node. To achieve this, we ran a dijkstra algorithm to compute these distances.  

After calculating score for each node, we chose the one with highest score and report it to the user.

## Phase 2
