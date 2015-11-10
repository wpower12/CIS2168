/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.heaps;

/**
 *
 * @author wpower
 */
public class OtherTraversals {
    /**
     * <Level Traversal> or breadth first traversal.
     * 
     * The same order as our heap sequential labeling.  Root first, then go across
     * each level.
     * 
     * No way to write a recursive level traversal.  To implement it you
     * typically use a stack or queue.
     * 
     * 
     * <Generic Trees>  Not all trees are complete or binary.  If we have a 
     * general tree w/ no ordering, we can generalize our other raversals, but 
     * no order would be gaurenteed.  Ordered nodes will still work.
     * 
     * The <pre order traversal>, when generalized like this, is known as a 
     * <depth first traversal>.  
     * 
     * rtN1N2...Nn  where the N's are the ordered nodes of children
     * 
     * We can generalize post order in a similar way.  In order cannot be
     * generalized due to an ambiguous 'middle'
     */
}
