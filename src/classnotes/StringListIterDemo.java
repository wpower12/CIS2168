/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author wpower
 */
public class StringListIterDemo {
 
    public static void main( String[] args) {
        LinkedList<String> strlist = new LinkedList<>();
        
        strlist.add("Hello");
        strlist.add("Goodbye");
        
        ListIterator<String> iter = strlist.listIterator();
        
        while( iter.hasNext() ){
            System.out.println(iter.next());
        }
    }
}
