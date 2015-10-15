/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw6;

/**
 * Replace all needed elements to make intcoll6 work while storing strings,
 * not integers.
 * 
 * Also, we now want to account for multiples of the same String.  We can have 
 * more than one of the same String.
 *
 * To do this, we add a count field to the btNode class.  When we insert, we 
 * traverse as normal, but now if we find a node with the same string, we increment
 * its count instead of doing nothing.  If we find nothing, we insert a new leaf
 * node with a starting count of 1.
 * 
 * omit(String)  we want to remove just one of the copies, if there's only 1 then remove it
 * 
 * belongs(String) will return how many times the string is in the collection
 * 
 * print() will return all the strings, and their count next to them.
 * 
 * get_howmany() should return the total number of strings, including duplicates.
 * 
 * @author wpower
 */
public class Stringcoll {
    
}
