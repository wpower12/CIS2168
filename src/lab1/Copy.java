/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package lab1;
import hw1.Intcoll1;

/**
 *
 * @author wpower
 */
public class Copy {
    
    public static void main( String[] args ){
        Intcoll1 A = new Intcoll1();
        A.insert(1);
        A.insert(2);
        A.print();
        A.copy(A);
        System.out.println("Copied");
        A.print();
        System.out.println( A.get_howmany() );
    }
}
