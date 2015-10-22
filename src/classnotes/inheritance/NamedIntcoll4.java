/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.inheritance;

import hw2.Intcoll4;
import java.util.Random;

/**
 * <Class Inheritance>
 * 
 * A class may <Extend> another class.  By using the extend keyword in a class
 * definition, you are saying you want the current class to also contain all
 * the methods and members of the extended class.
 * 
 * @author wpower
 */
public class NamedIntcoll4 extends Intcoll4 {
/**
 * Now the NamedIntcoll4 has access to all the methods and fields in Intcoll4.
 * 
 * Suppose we'd like the extended Intcoll4 class to track a name for the 
 * collection.  We can declare specific members for it.
 */
    private String name;
 /**
  * We can also add new constructors.
  * 
  * Note here, the new method super(). Super() calls the constructor method
  * of the extended class.  It will accept all parameter signatures that
  * are accepted by the constructors of the extended class.
  * 
  */
    public NamedIntcoll4(){
        super();
        name = "unnamed";
    }
    public NamedIntcoll4(int i){
        super(i);
        name = "unnamed";
    }
    public NamedIntcoll4(String s){
        super();
        name = s;
    }
    public NamedIntcoll4(String s, int i){
        super(i);
        name = s;
    }
    
    /**
     * We can add methods with new behavior and reimplement methods from the
     * base class.
     * 
     * We see here the super object.  Similar to this, super refers to the base
     * class 'object'.  This allows you to call the original base class method
     * inside your overriding methods.
     */
    public void print(){
        System.out.print(name + ":");
        super.print(); 
    }
    public String getName(){
        return name;
    }
    
    public static void main(String args[]){
        NamedIntcoll4 namedIntcoll = new NamedIntcoll4("I have name!");
        Random rand = new Random();
        for( int i = 0; i < 10; i++ ){
            namedIntcoll.insert( rand.nextInt(300) );
            
        }
        
        namedIntcoll.print();
        
    }
}
