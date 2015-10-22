/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes;

/**
 * <Hash Table>
 * 
 * Consider an array of some size, that we'd like to store integers in.  
 * 
 * We could create some function that given any int, will produce some value
 * in the range of the array, representing where in the array to store that
 * integer.
 * 
 * One example of such a function is:
 * 
 *     pos = <key> mod <size>
 * 
 * For any given int, taking modulo size of the array will always yield a 
 * number between 0 and size-1.
 * 
 *      ex/  key = 48, size = 13
 *          48mod13 = 6, store 48 in slot 6 in the array
 * 
 * We notice that this can lead to <collisions>.  When two different keys map to
 * the same integer, we have a collision, and need to handle the situation.
 *      
 *      ex/ keys 42, 29.  Both mod 13 = 3
 * 
 * <Linear Probing> is a technique to deal with collisions.  Each time we find a
 * 'candidate' slot in the storage, we consider it a 'probe'.  The first probe
 * just finds the slot corresponding to the hash function.  If we find a full
 * slot there, increment the pointer you are using to address the array, and 
 * check there.  Continue until a slot is found for the value.
 * 
 * Once a table becomes dense, linear probing is often and costly.  Therefore, 
 * its important to keep size and spareness into account when crafting a 
 * hash table.
 * 
 * First lets consider how we check if a value is in the hash table.
 * 
 * To answer the 'belongs' question, we act similarly to insertion.  Look at the
 * location found from the hash function, and see if the value is there.  If the
 * slot is empty, then the value is def. not in the collection.  If a value not
 * equal to the value is there, linear probe until an empty spot or the value is
 * found.
 * 
 * How about remove?
 * 
 * If we simply remove an entry, we then mess up our system for searching.  We
 * need to be able to store a value that represents 'not a value, but not empty'
 * This lets us, in our search, still know to continue probing, while also leaving
 * the correct empty space.
 * 
 * <Sizing Hash Tables>
 * 
 * With a modular hash function, choosing a size that is a prime number will
 * lead to a sparsely populated hash table, limiting collisions at a given size.
 * 
 * <ListNode Hash Tables>
 * 
 * We have just been looking at storing integers.  What if we'd like to store
 * pointers to objects?  We if we used ListNode objects?
 * 
 * We can still do the same process, the nodes have an integer value member that
 * we can use as a key.  The hash function gives us an entry in the array, and
 * we then store a pointer to that listnode in that slot in the array.
 * 
 * In this listnode case, we can handle collisions in a better way.  If a collision
 * is found, we can add the listnode we are adding to the list found in that slot.
 * When doing so, we should traverse the list, and make sure the item isnt already
 * present.  If we reach the end, we append it to the list.
 * 
 * We call this type of collision resolution <Chaining>
 * 
 * Searching in this list type hash table is also simple.  Hash the nodes value,
 * then traverse the list found there to check for the node.
 * 
 * @author wpower
 */
public class HashTable {
    
}
