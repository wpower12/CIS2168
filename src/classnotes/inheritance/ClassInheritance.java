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
public class ClassInheritance extends Intcoll4 {
/**
 * Now the ClassInheritance has access to all the methods and fields in Intcoll4.
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
    public ClassInheritance(){
        super();
        name = "unnamed";
    }
    public ClassInheritance(int i){
        super(i);
        name = "unnamed";
    }
    public ClassInheritance(String s){
        super();
        name = s;
    }
    public ClassInheritance(String s, int i){
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
        ClassInheritance namedIntcoll = new ClassInheritance("I have name!");
        Random rand = new Random();
        for( int i = 0; i < 10; i++ ){
            namedIntcoll.insert( rand.nextInt(300) );
            
        }
        
        namedIntcoll.print();
        
    }
}
