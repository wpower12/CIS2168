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
public class Increaser {
    
    public static void increase( Intcoll1 C, int by ){
        int max = C.get_howmany();
        int count = 0; 
        int i = 1;
        
        int values[] = new int[max];
        
        while( count < max ){
            if( C.belongs(i) ){
                values[count] = i;
                count++;
                C.omit(i);
            }
            i++;
        }
        for( int j = 0; j < max; j++ ){
            C.insert(values[j] + by);
        }
    }
    
    public static void main(String[] args){
        Intcoll1 A = new Intcoll1();
        A.insert(1); A.insert(2); A.insert(3);       
        A.print();
        
        increase( A, 1 );
        
        A.print();
    }
}
