1. An array is a grouping of data elements of the same data type (String, Double etc)
   A linked list is a group of entities called a node. The node includes two segments: data and address

   I would use an array if I needed to access specific elements as it is much faster and easier
   If I needed to do any operations such as deletion, insertion, I would utilize a linked list as it is much quicker in response times

2. Stack: A stack is a data structure that is linear that is used to store a collection of objects. It uses a system where as if you put plates in a pile on top of each other, the last one you add on top is the first one      you will take off to use it. You can use stacks for a go back button in your software or mobile application, as you can then access the last page you were on as it will be on the top of the stack.

   Dictionary: A dictionary is a general-purpose data structure for storing a group of objects.A dictionary has a set of keys and each of those keys will have a single value that is associated with that key, when the key is presented, their associated value with be returned. You could use a dictionary when you want to store the Movie name as the key and the rating as its value.
   
   Queue: A queue is a data structure that is linear which is open on both ends. It works like standing in a queue at a Spar or Checkers, the first person at the til will be the first person to leave, the 2nd person in the queue will be the 2nd person to leave etc. You could use a queue when trying to sell tickets for a concert, depending on when you click to join the queue or click by now, it can put you in a queue, instead of it being a lucky draw.

3. 
   A: You can use the actual number as the hash value if the input is always a number. You don't need to perform any further conversions because the input is already in the integer space. To save or retrieve data in a hash table, just use the integer as the index.
   
   B: I would use the djb2 algorithm as it has a hashing function for string.
   
   C: Cuckoo hashing can be used to assist in addressing collision resolution. Through the maintenance of two hash tables, each with its own hashing function, the collision is resolved. The collided slot is then filled with the given item, and the preoccupied element of the slot is moved into the other hash table. If the procedure enters an infinite loop, which is detected by keeping track of the threshold loop counter, both hash tables are rehashed with newer hash functions, and the process is repeated until each key has its own space in the empty buckets of the tables.

4. A skip list is a type of data structure that makes it easy to insert, remove, and search for elements in a sorted list. It is a probabilistic data structure, which means that a probabilistic analysis is used to determine its average time complexity.

   In a skip list, the elements are arranged in layers, with the number of elements in each layer decreasing as it descends. The layers above the bottom layer, which is a regular linked list, contain "skipping" links that enable quick access to the bottom layer's far away elements. This reduces the typical number of steps required to get to the desired element by enabling quick navigation to it.

   Concurrent Operations: Skip lists naturally support concurrency. As long as different levels of the skip list are modified independently, concurrent modifications can be carried out without the use of locks or complicated synchronization mechanisms.

   The method used to implement skip lists is known as "coin flipping." For each insertion in this method, a random number is generated to determine how many layers the new element will take up. As n is the number of elements in the bottom layer, this means that, on average, each element will be in log(n) layers.

   I could use a skip list in priority queues, for instance giving a higher priority to an admin or manager of a website, can be accessed more quickly or more frequently requested data can be accessed much quicker.
