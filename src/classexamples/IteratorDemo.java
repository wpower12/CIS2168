/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */package classexamples;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author wpower
 */
public class IteratorDemo {

    public static void main( String[] args) {
        LinkedList<Integer> intlist = new LinkedList<>();
        int i = 0;
        while (++i < 10) {
            intlist.add(i);
        }
        
        //We get the iterator for a collection FROM the collection
        //We can't construct our own w.o an existing collection
        ListIterator<Integer> iter = intlist.listIterator();
        
        System.out.println("Iterating and printing: ");
        while( iter.hasNext() ){
            // next() pulls a value from the iterator
            System.out.print(iter.next().toString()+" ");
            //Afterwards, the iterator will check to see if it has a next int left
            //Each call to next() will pull a new int until the end of 
            //the collection has been reached.
        }
        
        System.out.println("\nOther iterator methods: ");
        //We reset the iterator by getting a new one from the collection
        iter = intlist.listIterator();
        while( iter.hasNext() ){
            Integer m = iter.next();
            System.out.print(m+" ");
            Integer n = new Integer( 2*m.intValue() );

            iter.set(n);
            iter.add(m);
        }
    }

}
