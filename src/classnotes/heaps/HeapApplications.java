/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.heaps;

import static classnotes.heaps.Heaps.makeHeap2;

/**
 * <Applications of Heaps>
 * 
 * @author wpower
 */
public class HeapApplications {
   
    /**
     * <HeapSort!>
     * 
     * We can use the methods we have to create min/max heap to sort an array,
     * or rather have access to the elements in sorted order.
     * 
     * Consider an array with integer values with no apparent ordering.
     * 
     * These slots in the array correspond to a tree, using a sequential ordering
     * and label of the array slots.
     * 
     * IE - The root is slot 0, first child 1, second child 2, next row... (as before)
     * 
     * Phase 1:
     * 
     * We apply our O(n) shift-down method to convert this arbitrary tree
     * into a proper min/max tree.  The implementation of this will need to
     * shift values into other slots.  This requires tracking a 'last' pointer
     * and knowing that:
     *  For a node with atleast a left node, that node is at index 2*p, where p
     * is the index of the parent.  Its right child would be at 2*p+1. (Might not exist on
     * the middle element)
     * 
     * Phase 2:
     * 
     * We abuse the fact that the smallest element in a min heap is always the 
     * root.  So to sort, we track a sorted sub section at the head of the array.
     * 
     * We add the root to this subsection, then replace it with the slot at 'last'
     * We then reheap.  We continue doing this until all values are in the sorted
     * subsection.
     * 
     * To actually implement this, you'd use the 'last' pointer.  Before moving it,
     * the last pointer is pointing to a slot in the array that has had its value
     * moved to root.  So we an store the next sorted value there. 
     * 
     * Basically, keep swapping last with current head, and reheap.  
     * 
     * We note that the order of the sort is opposite to the order of the heap.
     * 
     * A min heap method will yield an array sorted large-small.  A max heap
     * will yield and array sorted small-large.
     * 
     * <Performance>
     * 
     * Phase 1 takes O(n), Phase 2 takes O(nlgn), so the total order for the
     * sort is O(nlgn).
     * 
     */
    public static void heap_sort( Heap h ){
        //1
        makeHeap2(h);
        //2
        //For each node, swap head and last, shift the head down into place. last++
        
    }
    
    /**
     * <Priority Queue>
     * 
     * Assume we have a series of tasks or items to be processed, each one with
     * a value representing its priority.  A priority queue maintains a collection
     * of these objects.  It provides quick access to the next highest priority
     * object, and provides a method to insert an object into the queue given
     * its priority.
     * 
     * In fact we'd like:
     *  insert(), remove(), size(),
     * 
     * We notice that given a certain set of priorities, these queues could 
     * behave like stacks.
     * 
     * Implementing an API like this is possible in many ways, with hugely 
     * varying performance.
     * 
     * <Array Implementation>
     *      insert() - O(1) //Just add it at the next available spot.
     *               - O(n) if we pre sort, and maintain a sort we still have to shift n items
     *      remove() - O(n) //Need to evaluate all items to find highest priority
     *               - O(1) if we pre sort, and maintain a sort we still have to shift n items
     *
     * We see that sorting or not sorting will yield atleast one primary API
     * operation that has to happen in O(1), and one that happens in O(n)
     * 
     * <Linked List Implementation>
     * 
     *      Follows the same pattern as above!  One of the major operations will
     * be slow, the other fast.  What if we wanted a middle range?  
     * 
     * <Heap Implementation>
     * 
     *      If we store our priorities in a heap (that matches the ordering of
     * priority, so either min or max depending on whether a large number or a small
     * number is higher priority), we get access to quick insert and remove.
     * 
     *      insert() - O(lgn) - As per our shift down algos
     *      remove() - O(lgn) - We pop the root, O(1), then reheap, O(lgn)
     * 
     * Both operations are order of log(n)!!!  This is great if you want quick
     * operation for both API methods, not just one.  
     * 
     * 
     * 
     * 
     */
}
