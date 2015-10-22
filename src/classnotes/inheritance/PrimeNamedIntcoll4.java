/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.inheritance;

/**
 * <Another Inheritance Example>
 * 
 * We are extending a class that is extending a class.  Therefore we have access
 * 
 * @author wpower
 */
public class PrimeNamedIntcoll4 extends NamedIntcoll4 {
    
    public PrimeNamedIntcoll4(){
        super();
    }
    
    public PrimeNamedIntcoll4( String s){
        super(s);
    }
    
    /**
     * Here we are overriding the insert method to check for primality.  Notice
     * how we use the super object again to call the original insert method.
     * 
     */
    public void insert( int i ){
        if( (i > 1) && isPrime(i) ){
            super.insert(i);
        } else {
            System.out.println("Not a prime");
        }
    }
    
    private static boolean isPrime( int n ){
       int i = 2; boolean result = true;
       while( i <= n && result){
           result = (i%n == 0);
           i++;
       }
       return result;
    }
    
    public static void main( String args[] ){
        /**
         * The methods and members we have access to in a variable are set when
         * we define its type.  
         * 
         * This means we can assign a subclass of a base class to a variable
         * that holds a member of the base class, but we cannot assign a
         * base class object to a variable containing an extended class
         * 
         * IOW:
         */
        NamedIntcoll4 base = new NamedIntcoll4();
        PrimeNamedIntcoll4 sub = new PrimeNamedIntcoll4();
        
        /**
         * This is legal.  
         * 
         * If base has all the methods and members of just NamedIntcoll4, then
         * if we assign sub to it, we ok!  sub still has all of those methods
         * and members.  The client thinks its a base class, so it wont ever 
         * try, or be able to, call the methods and members that are added in 
         * the sub class.
         * 
         */
        base = sub;
        
        /**
         * This is not legal!  If you take the comments off you'll see your
         * IDE yell at you about incompatible types.
         * 
         * sub expects methods and members that are defined in the extended 
         * class.  The base class doesn't have these, so we would get null
         * pointers when a client tried to call them, expecting the behavior 
         * of the extended class.
         */
        //sub = base;
        
        /**
         * This seems contrived, but there are times when you want to do lots
         * of similar things to slightly different things.  In these situations,
         * sometimes a solution is to have a base class with the common behavior,
         * and extensions that have specific behavior.  
         * 
         * When it comes time to do the common thing with the disimilar classes,
         * we could cast to the base class (which the above technically does), 
         * and have methods that work just on the base class.
         * 
         */
    }
}
