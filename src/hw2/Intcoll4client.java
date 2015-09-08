/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
