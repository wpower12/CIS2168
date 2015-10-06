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
public class Example {
    
    public static void example( int a, int b, Intcoll1 C){
        a = a+b; b = a*b;
        C.insert(20);
        Intcoll1 D = new Intcoll1();
        C = D;
    }
    
    public static void main(String[] args){
        
        int a = 5;
        int b = 10;
        Intcoll1 C = new Intcoll1();
        C.insert(3); C.insert(5); C.insert(30);
        
        
        example( a, b, C );
        System.out.print( "A: "+a+"  B:"+b );
        C.print();
        
    }
}
