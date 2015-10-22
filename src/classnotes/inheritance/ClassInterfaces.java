/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.inheritance;

/**
 * <Class Interfaces>
 * We've seen how we need to type all the data that we store in somethign like
 * intcoll.  How would we change our code to handle storing other types?
 * 
 * We know that all the methods do the same thing, regardless of type.  They need
 * to compare one instance of a type to another instance, and be able to say 
 * "greater or smaller or equal". 
 * 
 * If there was a way to make sure that different data types could still answer
 * those questions, we wouldnt need to change our code much!  If things other 
 * than int are allowed to be passed to a comparison, we dont have to change
 * our actual comparisons!
 * 
 * This is the reasons OOP based languages like Java use Interfaces!  Interfaces
 * are a way to say to the compiler "I can answer the following questions".  If
 * a class can answer all the questions of a given interface, then any client
 * that uses just those questions it.  
 * 
 * This means we can have many different classes, all able to answer the same
 * questions, all able to be used by the same client.  
 * 
 * Consider the power of this.  If you have many similar things, all answering
 * the same question, but doing so in very different ways, you can still write
 * a single chunk of client code to interact with them!  
 * 
 * Ok nvm.  I wrote this all myself, and apparently we arent gonna use interfaces
 * for the next assignment.  Ignore this for now, but it'll eventually be helpful
 * @author wpower
 */
public class ClassInterfaces {
    
    public static void main(){
        String in = "HELLOA";
        String in2 = "HELLOB";
        
        in.compareTo( in2 );
    }
    
}
