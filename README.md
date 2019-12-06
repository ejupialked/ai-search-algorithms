# Blocks world tile puzzle - AI Search Methods
This puzzle consists of three tiles "A", "B" and "C" and the agent which can only move up, down, left and right.
The agent's goal is to place the tiles in a specific pattern.
### Example Agent moves
![Example](https://raw.githubusercontent.com/ejupialked/ai-search-algorithms/master/screenshots/moves.png?token=AKPXOF7PGSMSKLGNXLYPFGK56MHQO)

## The problem to solve
This is by the default the problem used to test the four search methods. The final position of the agent does not matter.
![H](https://raw.githubusercontent.com/ejupialked/ai-search-algorithms/master/screenshots/problem.png?token=AKPXOFYXZRWYUYL6JWT2HBS56MHSQ)
## Project Structure (Java)
The way I have structured my code is described in the UML diagram down below. 
![Example](https://raw.githubusercontent.com/ejupialked/ai-search-algorithms/master/screenshots/uml.png?token=AKPXOFZO7KZQDSWXAO5BLPC56MHNS)
### Dependencies
* Encoding UTF-8 supported on your terminal, the output is displayed using box-drawings characters.
* Java installed on your machine.
### Executing one of the four algorithms
* compile main class
```
> javac Main.java
```
* run Main class with one argument defining the strategy ("BFS", "IDS", "DFS" or "AStar"). For example,
```
> java Main "IDS"
```
### A* on operation 🚀

![astarGif](https://raw.githubusercontent.com/ejupialked/ai-search-algorithms/master/screenshots/AStarOnOperation.gif?token=AKPXOFZVD6P3NK254XRVIIC56MHJA)

## Issues
When running BFS you might get an error like this:
```
java.lang.OutOfMemoryError: Java heap space
```   
To overcome this issue increase the Java heap memory size by at least 10GB passing these parameters:

```
> java -Xms10000m -Xmx15000m  Main "BFS"
```   
## Author
Alked Ejupi Copyright (2019). All rights reserved.
## Reference
Peter Norvig Stuart Russel. Artificial Intelligence - A modern approach (3rd edition). Prentice Hall Press Upper
Saddle River, NJ, USA, 2009.
