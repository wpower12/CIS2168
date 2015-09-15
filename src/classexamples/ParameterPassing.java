/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classexamples;

import hw2.Intcoll4;

/**
 *
 * @author wpower
 */
public class ParameterPassing {

    public static void example( int a, int b, float x, Intcoll4 A ){
        //Parameters a, b, x, A are dummy parameters.
        //The 'actual' parameters are the values passed by the client code
        
        //Each call to a method creates slots in memory for each parameter
        //These slots only hold primatives.  You can consider a pointer a primative.
        
        //So, there are two ways the actual parameters can be copied over into
        // the dummy parameters:
        
        //1) Primatives - just copy over their value
        //2) Objects    - copy over the pointer to their memory <--!!!!
        
        //When we call the method, the values are copied into the dummy parameter
        //slots in memory. To be exact, any expressions in the actual parameters are evaluated 
        //then copied into the slot in memory.
        
        //Now we can look at what happens in memory as the function executes.
        
        a = a*b+10;                 //This overwrites the value in the dummy parameter slot with a new one
        x = (float) ((3*x)/8.5);    //This overwrites the value in the dummy parameter slot with a new one
            
        A.insert(50);               //This follows the pointer to the object, calls the method
                                    //and inserts a 50 into the actual parameter object
        
        A = new Intcoll4(50);       //Overwrites the pointer in the dummy parameter slot with a pointer
                                    //to a new Intcoll4 object.  DOES NOT CHANGE THE ORIGINAL OBJECT AT ALL
                                    //Just means the function is playing with a new object, pointed to by the
                                    //value in the dummy parameter slot for A.
        
    }
    
    public static void main( String[] args ){
        
        //So now if we pass all this stuff to the function, we should see how things
        //persist or change after the function executes
        
        int test_a = 1;
        int test_b = 2;
        float test_x = 3;        
        Intcoll4 test_A = new Intcoll4();
        test_A.insert(1);
        System.out.println("a: "+test_a+" b: "+test_b+" x: "+test_x);
        test_A.print();
        
        example( test_a, test_b, test_x, test_A );
        
        //These should stay the same
        System.out.println("a: "+test_a+" b: "+test_b+" x: "+test_x);
        
        //This will have been changed.
        test_A.print();
    }    
}
