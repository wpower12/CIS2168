/***** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw6;

/**
 * Just undo what we did.  The insert needs to not increment the map?
 * 
 * @author wpower
 */
public class NewStringcoll extends MultiStringcoll {
    
    public void insert( String s ){
        if( super.belongs(s) == 0 ){
            super.insert(s);
        }
    }
    
    public static void main(){
        
    }
}
                