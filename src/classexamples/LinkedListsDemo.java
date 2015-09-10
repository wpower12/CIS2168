/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classexamples;
import java.util.*;

/**
 *
 * @author wpower
 */
public class LinkedListsDemo {
    
    public static void main( String[] args ){
        
        LinkedList<Integer> intlist = new LinkedList<>();
       
        int i = 0;
        while( ++i < 10 ) intlist.add(i);
        
        System.out.println("intlist: ");
        System.out.println( "size(): "+intlist.size() );
        System.out.println( intlist.toString() );
        
        System.out.println( "contains(5): "+intlist.contains(5) );
        
        System.out.println( "\nremove( 5 )");
        intlist.remove(5);
        System.out.println( "size(): "+intlist.size() );
        System.out.println( intlist.toString() );
        System.out.println( "contains(5): "+intlist.contains(5) );
        
        System.out.println( "\nremove( new Integer(5) )");
        intlist.remove(new Integer(5));
        System.out.println( "size(): "+intlist.size() );
        System.out.println( intlist.toString() );
        System.out.println( "contains(5): "+intlist.contains(5) );
        
        System.out.println( "\ncontains(\"two\"):\t"+intlist.contains("two") );
        System.out.println( "contains(\"2\"):\t\t"+intlist.contains("2") );
        System.out.println( "contains(2):\t\t"+intlist.contains(2) );
    }
}
