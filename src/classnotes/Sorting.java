/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes;

import java.util.Random;

/**
 * <Bubble Sort>
 *
 * O(n^2) sort. Iterate over subsequent pairs in the array, flipping if out of
 * order.
 *
 * That means worst case, at each step, we have to look at one less item, or
 * for a list of n items, the number of total checks is a triangular number.
 *
 * sum = n-1 + n-2 + ... + 2 + 1 = n*(n-1)/2
 *
 * The above is O(n^2), so our time complexity wrt comparisons is O(n^2)
 *
 * For a million item list, with a cpu that can do 10^13 operations a year, that
 * means an execution time on the order of a month. <- Wow.
 *
 * There are slow/slower algorithms than these
 *
 * <Insertion Sort>
 *
 * Iterate over array, insert next element into sorted sub array, shifting entries
 * as needed.
 *
 * Same deal. At each step, the worst case is comparing to every member of the
 * sorted sub array. For n items, at step a, there are n-a comparisons.
 *
 * O(insertion) = O( # of comparisons) = O( sum ) = O(n^2)
 *
 * sum = n-1 + n-2 + ... + (n-a-2) + (n-a-1) = n*(n-1)/2
 *
 * We have to write this sort, while tracking comparisons.
 *
 * 
 * <Quick Sort> 
 * 
 * Fast sorting!  
 * @author wpower
 */
public class Sorting {

    private static int numcalls = 0;
    private static int count = 0, m = 0;
    
    
    /**
     * Merge Sort
     * 
     * When we trace the execution of a recursive function, we can see that
     * it forms a tree of sorts.  The tree shows what inputs the recursive call 
     * is working on.
            
     For an array with 8 items, the tree would look like:
    
                       (0,7)
           (0,3)                  (4,7)
      (0,1)      (2,3)      (4,5)      (6,7)
    (0,0)(1,1) (2,2)(3,3) (4,4)(5,5) (6,6)(7,7)
    
    Where (x,y) means mergesort(from_x, to_y) of Array
    
    That means the # of calls we actually make is the depth of the tree times
    2 times the 'width' of the tree.  Or
        f(n) = 2*n*log(n) , O(f(n)) = nlogn
    
    
     */
    public static void sort_merge(int[] a, int top, int bottom) {
        numcalls++;
        if (top != bottom) {
            int middle = (top + bottom) / 2;
            sort_merge(a, top, middle);
            sort_merge(a, middle + 1, bottom);
            merge(a, top, bottom);
        }
    }

    public static void merge(int[] a, int top, int bottom) {
        int t = top, middle = (top + bottom) / 2, b = middle + 1, i = 0;
        int[] s = new int[bottom - top + 1];
        while ((t <= middle) && (b <= bottom)) {
            if (a[t] < a[b]) {
                s[i] = a[t];
                t++;
            } else {
                s[i] = a[b];
                b++;
            }
            i++;
            m++;
            count++;
        }
        int last = middle;
        if (b <= bottom) {
            t = b;
            last = bottom;
        }
        while (t <= last) {
            s[i] = a[t];
            t++;
            i++;
            m++;
        }
        for (i = 0; i < s.length; i++) {
            a[i + top] = s[i];
            m++;
        }
    }
    
    /**
     * Quick Sort
     * 
     * Sorts by selecting a pivot from a set of data, where everything greater
     * than the pivot is above it, and everything lower is below it.
     * 
     * The selection of the pivot involves some manipulation of the array, but
     * is done in a way that rapidly speeds up the sorting process.
    
     * The invariant, or thing that is always the same from call to call, is 
     * that the partition function always places one element, the pivot, into
     * its sorted place in the array.  By definition, the array is organized
     * such that the pivot has only elements smaller than it to its 'left' and
     * only elements larger than it to its 'right'.  We'll see how this is done
     * quickly in the actual partition function, but if you take it for granted
     * now, you can see how simple the logic of the sort is.
    
     * We pick an element, and place it in its correct place in the array, and 
     * by doing so, create two other sub arrays that are out of order wrt to
     * each other, but are in the correct area of the original array.
      
     * Because these are now seperated by an element that is in its correct place,
     * we can just call quicksort on these subarrays!  
    
     * Put on thing in order, Sort the things lower than it, sort the things 
     * higher than it.  Thats all thats happening!  The magic comes from 
     * moving the pivot into place.  If we do that while 'kinda' sorting the
     * array, we can make our input smaller, which is the heart of recursive
     * programming.
     */
    public static void sort_quick( int[] data, int i, int j ){
        int p;
        if( i < j ){
            p = partition( data, i , j );   //Calculate the pivot of the section
            sort_quick( data, i , p-1 );    //Sort the things above/below pivot
            sort_quick( data, p+1, j);
        }
    }
    /**
     * Partitioning involves selecting an element for a pivot, in our class
     * we are doing a simple pivot selection.  The first element, the top,
     * is always the pivot.  
     * 
     * We need to then place it in its correct position by swapping it with
     * elements that are alternativly smaller or larger than it. 
     
     * As these swaps happen, the pivot will get closer to its actual place in
     * the array, and the other elements will be place, correctly, either
     * above or below the pivot.
    
     * We alternate comparing the pivot to the 'bottom' and 'top'.  If it is
     * ever greater or smaller (respectivly), we exchange the pivot and that item
     * We then increment the pointer we exchanged with.
     * 
     * We then return the index of the final position of the pivot.  This is so
     * we know where the sub arrays start and end when we recursivly call 
     * quicksort()
     */
    public static int partition( int[] data, int i, int j ){
        int upper = i, lower = j, save;
        save = data[i];
        
        while( upper != lower ){
            while( (upper < lower) && (save < data[lower]) ) lower--;
            if(upper != lower){
                data[upper] = data[lower];
            }
            while( (upper < lower) && (save > data[upper])) upper++;
            if( upper!= lower ){
                data[lower] = data[upper];
            }
        }
        data[upper] = save;
        return upper;
    }
    
    
    
    /**
     * 
     */
    public static void sort_insertion() {

    }
    
    
    /**
     * Easy pretty print
     */
    public static void print_array(int[] a, int size) {
        System.out.print("( ");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(")\n");
    }

    public static void main(String args[]) {

        Random gen = new Random();

        System.out.println("   n   | numcalls | comparisons");
        System.out.println("-------------------------------");
        int SIZE;
        
        int[] a;
        String line;
        for (int i = 1; i < 6; i++) {
            SIZE = (int)Math.pow(10, i);
            a = new int[SIZE];
            for (int j = 0; j < SIZE; j++) {
                a[i] = gen.nextInt(5000) + 1;
            }

            numcalls = 0;
            count = 0;
            m = 0;
            sort_merge(a, 0, SIZE - 1);
            //sort_quick(a, 0, SIZE - 1);
            line = String.format("%6s | %8d | %8d ", SIZE, numcalls, count);
            System.out.println( line );
        }

    }

}
