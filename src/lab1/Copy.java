/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
