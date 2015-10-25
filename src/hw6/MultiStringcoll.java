/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw6;

import java.util.HashMap;

/**
 * Extend the Stringcoll client to track multiple entries for the same
 * string.
 * 
 * You dont have access to the BTNode internal class.  You have to track
 * the counts for entries using some other structure
 * 
 * we now want to account for multiples of the same String. We can have
 * more than one of the same String.
 *
 * To do this, we add a count field to the btNode class. When we insert, we
 * traverse as normal, but now if we find a node with the same string, we increment
 * its count instead of doing nothing. If we find nothing, we insert a new leaf
 * node with a starting count of 1.
 *
 * omit(String) we want to remove just one of the copies, if there's only 1 then remove it
 *
 * belongs(String) will return how many times the string is in the collection
 *
 * print() will return all the strings, and their count next to them.
 *
 * get_howmany() should return the total number of strings, including duplicates.
 *
 * 
 * @author wpower
 */
public class MultiStringcoll extends Stringcoll {
    
    private HashMap<String, Integer> counts;
    private int total_howmany;
    
    public MultiStringcoll(){
        total_howmany = 0;
        counts = new HashMap<>();
    }
    
    public MultiStringcoll( int i ){
        total_howmany = 0;
        counts = new HashMap<>();
    }
    
    public int get_howmany(){
        return total_howmany;
    }
    
    public void insert( String s ){
        total_howmany++;
        if( counts.containsKey(s) ){
            //Increment counter for s
            counts.replace(s, counts.get(s)+1);
        } else {
            //Add s to counter 
            counts.put(s, 1);
            super.insert(s);
        }
    }
    
    public void omit( String s ){
        if( counts.containsKey(s) ){
            total_howmany--;
            int v = counts.get(s);
            if( v > 1 ){
                counts.replace(s, v-1);
            } else {
                counts.remove(s);
                super.omit(s);
            }
        }
    }
    
    public int belongs( String s ){
        if( counts.containsKey(s) ){
            return counts.get(s);
        } else {
            return 0;
        }
    }
    
    public void print(){
        
    }
    
    public static void main(String a[]){
        
        MultiStringcoll A = new MultiStringcoll();
        
        A.insert("a");
        A.insert("a");
        A.insert("a");
        A.insert("b");
        A.insert("b");
        
        System.out.println("A.belongs(a)="+A.belongs("a"));
        System.out.println("A.get_howmany="+A.get_howmany());
        A.omit("a");
        System.out.println("A.belongs(a)="+A.belongs("a"));
        System.out.println("A.belongs(d)="+A.belongs("d"));
        
        System.out.println("A.get_howmany="+A.get_howmany());
        
    }
}
