/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw2;
/**
 *
 * @author wpower
 */
public class Intcoll4client {
    
    public static void main( String[] args ){
        Intcoll4 C = new Intcoll4();
        C.insert(1);
        C.insert(2);
        C.insert(20000);
        C.print();
        System.out.println("C has this many "+C.get_howmany());
        C.omit(2);
        C.omit(1);
        C.omit(20000);
        C.print();
        
        System.out.println("C has this many "+C.get_howmany());
        
        Intcoll4 D = new Intcoll4();
        
        C.insert(1);
        C.insert(2);
        C.insert(20000);
        C.print();
        D.copy(C);
        D.print();
        if( C.equals(D) ) System.out.println("Theyre equal!");
        C.omit(20000);
        if( !C.equals(D) ) System.out.println("Theyre not equal!");
        D.copy(C);
        D.print();
        System.out.println( D.get_howmany() );
    }
    
}
