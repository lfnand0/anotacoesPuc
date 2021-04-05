# Arrays

## Types of Arrays
* Static:
  * Fixed number of memory slots
  * C language, for example, uses this type of array
* Dynamic:
  * Flexible number of memory slots
  * Both Python and Javascript, for example, use this type of array 

## Common Operations
* OBS: always consider either the average case or the worst case
* Access:
  * Time Complexity: O(1)

* Update
  * Time Complexity: O(1)

* Traversal:
  * Visiting each and every element of the array
  * Time Complexity: O(n)

* Search
  * Find a particular element
  * Time Complexity: O(n)

* Copy
  * Copying a complete array over to a new memory address
  * Time Complexity: O(n)

* Insert
  * In this case, the system copies the array over to another place that has enough slots for the inserted elements.
  * Time Complexity: O(1) or O(n) - depends on the amount of elements in the array before the insertion

* Delete
  * If you are deleting the last element, it's O(1)
    * You only have to acess the slot and delete it
  * If you are deleting the first element, it's O(n)
    * You have to access the element, delete it and then move the rest of the array one slot 
  * If you are deleting an element in the middle, it's also O(n)