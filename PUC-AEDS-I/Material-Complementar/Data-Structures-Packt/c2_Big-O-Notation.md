# Big O Notation
  * Big O notation is used in CS to describe the performance or complexity of an algorithm. It's used to describe the execution time required or the space used (e.g. in memory or on disk) by an algorithm.
  * To measure the efficiency of an algorithm, we need to consider two things:
    * Time Complexity: How much time does it take to run completely?
    * Space Complexity: How much extra space does it require in the process?

## Complexity Analysis
  * Foundation of Data Structures and Algorithms
  * There are MULTIPLE ways of coding an algorithm, and even though they might give the same output, they are different when it comes to efficiency and complexity.
  * How to define good code?
    * Readable
    * Scalable
      * Time Complexity
        * Amount of time it takes to run an algorithm.
        * EXAMPLES:
          * [timestamp: For Loop](./c2/forloop.py)
          * [timestamp: While Loop](./c2/whileloop.py)
      * Space Complexity
        * Amount of extra space our algorithm requires.
  
## Why do we need Big O?
  * We require Big O to give a performance rating to our program for time and space.
  * We cannot depend on our system clock time as well as hardware for each program.
  * Big O DOES NOT DEPEND ON TIME, it depends on how many steps we are performing.
  * The main focus is to calculate the amount of work we do or the number of comparisons we perform.


## Simplifying
  * To simplify Big O, we follow 5 rules:
    * RULE 1: FOCUS ON SCALABILITY
    * RULE 2: CONSIDERING WORST CASE SCENARIO
    * RULE 3: REMOVE ALL POSSIBLE CONSTANTS
    * RULE 4: CONSIDER DIFFERENT VARIABLES FOR DIFFERENT INPUTS
    * RULE 5: REMOVE ALL NON-DOMINANTS
      * Example: O(7n + 8n²) => O(n²) 

### Big O(n)
  * [Big O Search](./c2/bigO-search.py)
    * If the list has n people in it, the program will check all n names (worst case scenario)
    * It's a linear pattern - Complexity = O(n)

### Big O(1)
  * [Big O(1)](./c2/bigO-1.py)
    * In this case, it doesn't depend on the amount of elements on the list, since it always prints the first element
    * It will always only perform one operation
    * Complexity = O(1)
  * OBS: every Big O that indicates a CONSTANT value is indicated as O(1), even if the program executes 2, 3, etc amount of times

### Big O(n) - Simplification
  * [countingOperations](./cs/countingOperations.py)
    * The function depends on the length of the array
    * Because of that dependence, even though the complexity is actually O(6+2n), we just consider it to be O(n)

### Big O(n²)
  * [bigO(n²)](./c2/bigO-nSquared.py)

### Big O(n!)
  * The worst algorithm possible


## Space Complexity
  * Represents the amount of extra memory space the algorithm needs in its life cycle.
    * PROPER DEFINITION: How much additional memory do we need to allocate in order to run our code.
  * We usually have 2 types of space requirement:
    1. To store our input data;
    2. Extra space that we need to execute our program.