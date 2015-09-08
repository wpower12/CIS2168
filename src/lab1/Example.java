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
