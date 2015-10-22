/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw5;

import java.util.Random;

/**
 *
 * @author wpower
 */
public class QuickSortTest {
    
    public static void main(String[] args)
   {
      Random gen=new Random(); int[] a=new int[25];
      int i; for (i=0; i<a.length; i++) a[i]=gen.nextInt(5000)+1;
      
      System.out.println("Initial array:");
      for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
      System.out.println();
      
      Sorts.quicksort(a);
      
      System.out.println("Sorted array:");
      for (i=0; i<a.length; i++) System.out.println(a[i] + " ");
      
      System.out.println("Done!");
      System.out.println(" qcount: "+Sorts.qcount);
   }
}
