# Chapter 6 - Linked Lists
* They store values in memory differently than arrays.
  * Arrays store values in sequence - which is not the case for linked lists

## Representation
* Linked lists work like this:
<pre>
  HEAD                          TAIL
  3 (7) --> 7 (2) --> 2 (9) --> 9 (none) --> none
  ^  ^
  |  7 = next value
  3 = data
</pre>
* Every slot stores both the actual data and information about the next pointer (singly)

## Type
* Singly list
  * Same as the example above
* Doubly list
  * Every element holds information both of the previous and of the next element. E.g.:
<pre>
        HEAD                                      TAIL
  (none) 3 (7) --> (3) 7 (2) --> (7) 2 (9) --> (2) 9 (none) --> none  
</pre>

## Linked List Complexities
* Access
  * Since we only truly have information about the head of the list, we have to go element by element -> O(n)
* Search
  * Worst case scenario = n, so -> O(n)
* Insert
  * At the start
    * After creating a new value we first store it into a node value, then store reference of the old head's as .next, and then update 'head' reference to the new value
    * Time Complexity: O(1)
  * At the end
    * We create a node structure for the new value, store reference to none as .next, and then update the old tail's .next to the new value. Afterwards, we update the 'tail' reference to the new value.
    * If we already have information about the tail's location, the Time Complexity is O(1). If not, it's O(n), since we'd have to traverse the whole list until we know where the tail is
  * At the middle
    * We create a node structure for the new value, then we store the .next value of the element that the new value is going to be inserted after
    * If we have information of the value that comes before the insertion, TC = O(1). Otherwise, TC = O(n)
* Delete
  * At the start
    * We just have to delete the head and update head.next to be refered as head
    * O(1)
  * At the end
    * O(1) if we have information about the location of the last value, O(n) if we don't.
  * At the middle
    * O(1) if we have information about the location of the value we want to delete, O(n) if we don't.