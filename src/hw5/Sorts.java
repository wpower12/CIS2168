/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw5;

import java.util.Random;
import java.util.Stack;

/**
 * Sorts!
 *
 * This file holds all 3 of the HW sorts as static methods. The static main
 * includes part 4 of the homework. Running it will show the tables for each
 * sort.
 *
 * @author wpower
 */
public class Sorts {

    /**
     * Merge Sort
     */
    public static int calls, m, mcount;

    public static void mergesort(int a[]) {
        calls = 0;
        m = 0;
        mcount = 0;
        mergesort(a, 0, a.length - 1);
    }

    private static void mergesort(int a[], int top, int bottom) {
        calls++;
        if (top != bottom) {
            int middle = (top + bottom) / 2;
            mergesort(a, top, middle);
            mergesort(a, middle + 1, bottom);
            merge(a, top, bottom);
        }
    }

    private static void merge(int[] a, int top, int bottom) {
        int t = top;
        int middle = (top + bottom) / 2;
        int b = middle + 1;
        int i = 0;
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
            mcount++;
            m++;
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
     */
    public static int qcount;

    public static void quicksort(int a[]) {
        qcount = 0;
        quicksort(a, 0, a.length - 1);
    }
    //Stack Based Quicksort
    private static void quicksort(int[] data, int i, int j) {
        int p, top, bottom;
        Stack<Integer> s = new Stack<>();
        
        //we start by pushing the inital top, then bottom.
        s.push(j);
        s.push(i);
        while (!s.empty()) {
            //Each loop through pops off two values, representing 
            //an obligation to sort between those indicies
            top = s.pop();
            bottom = s.pop();
            while (top < bottom) {
                //Partition the current sub array
                p = partition(data, top, bottom);
                //Push the larger sub array that is formed to the stack as
                //an obligation to sort.
                if ((p - top) > (bottom - p)) {
                    s.push(p - 1);
                    s.push(top);
                    top = p + 1;    //
                } else {
                    s.push(bottom); //Same as above, but looking at the other 'half'
                    s.push(p + 1);
                    bottom = p - 1;
                }
            }
        }
    }
    
    /**
     * Partitioning - The key part of quicksort
     * 
     * After a partition, the element at location p (the returned value) is in
     * its correct place between i and j.  
     * 
     * All elements between i and j that are less than the element at p are to
     * its left, and all to its right.
     * 
     */
    private static int partition(int[] data, int i, int j) {
        int upper, lower, save;
        upper = i;
        lower = j;
        save = data[i]; //This is our pivot, the element we are moving/comparing to.
        
        /**
          Here we 'flip flop' between comparing the pivot to the upper and the lower
          * element and swapping if they are out of place wrt each other
          * 
          * We stop when upper and lower are equal, because this is the location
          * p, where the saved element should be.
         */
        while (upper != lower) {
            //Compare to and move lower until a swap
            while ((upper < lower) && (save <= data[lower])) {
                lower--; qcount++;
            }
            if (upper != lower) {
                data[upper] = data[lower];
            }
            //Compare to and move upper until a swap
            while ((upper < lower) && (save >= data[upper])) {
                upper++; qcount++;
            }
            if (upper != lower) {   
                data[lower] = data[upper];
            }
        }
        data[upper] = save;
        return (upper); //Upper is the proper location for the pivot value
    }

    /**
     * Insertion Sort
     */
    public static int icount;

    public static void insertionsort(int a[]) {
        icount = 0;
        insertionsort(a, 0, a.length - 1);
    }

    private static void insertionsort(int a[], int start, int end) {
        for (int i = 1; i < end; i++) {
            int j = i;
            int temp;
            //Iterate over sorted part of array and swap until you hit something
            //you dont need to swap with.  Now youre in the right place in the
            //sorted subarray [a0-aj]
            while ((j > 0) && (a[j - 1] > a[j])) {
                //swap
                temp = a[j - 1];
                a[j - 1] = a[j];
                a[j] = temp;
                j--;
                icount++; //The count only increments when we have a comparison
                          //Once the cmoparison fails, no more happen.
            }
        }
    }

    /**
     * Convience Methods
     */
    public static Random rand;

    public static void fill_random_array(int a[], int size, int max) {
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(max);
        }
    }

    public static void main(String args[]) {
        int MAXINT = 5000;
        int k = 10;
        int s;
        int sizes[] = {2048, 4096, 8192, 16384};
        Sorts.rand = new Random();

        int a[];
        int sum, max = 0, min = Integer.MAX_VALUE;
        float ave;
        String line;

        //Merge Table
        System.out.println("  Sort  |  Size | mcountmin | mcountmax |  mcountave  |");
        System.out.println("---------------------------------------------------------");
        for (s = 0; s < 4; s++) {
            a = new int[sizes[s]];

            sum = 0;
            max = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                fill_random_array(a, sizes[s], MAXINT);
                Sorts.mergesort(a);
                sum += Sorts.mcount;
                if (Sorts.mcount > max) {
                    max = Sorts.mcount;
                } else if (Sorts.mcount < min) {
                    min = Sorts.mcount;
                }
            }
            ave = (float) sum / (float) k;

            line = String.format(" merge  | %5d | %8d  | %8d  | %10.1f  |", sizes[s], min, max, ave);
            System.out.println(line);
        }

        //Insertion Table
        System.out.println("");
        System.out.println("  Sort  |  Size | icountmin | icountmax |  icountave  |");
        System.out.println("---------------------------------------------------------");
        for (s = 0; s < 4; s++) {
            a = new int[sizes[s]];

            sum = 0;
            max = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                fill_random_array(a, sizes[s], MAXINT);
                Sorts.insertionsort(a);
                sum += Sorts.icount;
                if (Sorts.icount > max) {
                    max = Sorts.icount;
                } else if (Sorts.icount < min) {
                    min = Sorts.icount;
                }
            }
            ave = (float) sum / (float) k;

            line = String.format(" insert | %5d | %8d  | %8d  | %10.1f  |", sizes[s], min, max, ave);
            System.out.println(line);
        }

        //Quick Table
        System.out.println("");
        System.out.println("  Sort  |  Size | qcountmin | qcountmax |  qcountave  |");
        System.out.println("---------------------------------------------------------");
        for (s = 0; s < 4; s++) {
            a = new int[sizes[s]];

            sum = 0;
            max = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                fill_random_array(a, sizes[s], MAXINT);
                Sorts.quicksort(a);
                sum += Sorts.qcount;
                if (Sorts.qcount > max) {
                    max = Sorts.qcount;
                } else if (Sorts.qcount < min) {
                    min = Sorts.qcount;
                }
            }
            ave = (float) sum / (float) k;

            line = String.format(" quick  | %5d | %8d  | %8d  | %10.1f  |", sizes[s], min, max, ave);
            System.out.println(line);
        }
    }
}
