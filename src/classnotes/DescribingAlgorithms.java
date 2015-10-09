/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes;

/**
 *
 * @author wpower
 * 
 * <Describing Algorithms>
 * 
 * <Paren Matching>
 * 
 * Suppose we have a problem like paren matching.  For a given set of parens
 * determine if the parens are all matched, or valid.
 * 
 * We need to succinclty describe a process that solves that.  A loose definition
 * of one such algorithm is to track a single int variable.  As you read through
 * the string of parens, add 1 for all left parens, subtract 1 for all right
 * parens.  If the value is ever less than 0, invalid.  If you reach the end
 * and value is 0, you have a valid paren string.
 * 
 * SUppose we have multiple paren types
 * 
 *  ([{{}[]}])[{}]
 * 
 * How do we match then?  3 counters wont work, because ([)] situations.  So
 * we need to track the 'obligations' we make as we read left parens.  each left
 * paren we match will mean we need a right paren of that type.  However,
 * the most recent left paren seen must hit its matching right paren or only
 * other left parens.  If it sees another, different, right paren, non valid.
 * 
 * I bet its a stack!  I bet we use a stack. Or queue?  maybe queue.
 * 
 * Stack.
 * 
 * 
 */
public class DescribingAlgorithms {
    
}
