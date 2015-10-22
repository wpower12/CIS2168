/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.stacks;

/**
 * <Expressions>
 * 
 * Consider a paren enclosed sequence of operations, like these two
 * 
 *  a+(b*c)    (a+b)*c
 * 
 * We can represent them as a tree:
 *     
 *     *          *
 *    / \         / \
 *   a  +        +  c
 *     / \      / \
 *    b   c    a  b
 * 
 * The above paren string matches the in order traversal of this tree.  Lets
 * look at the other traversals.  
 * 
 * pre : +a*bc   *+abc  Operators First
 * in  : a+b*c   a+b*c
 * post: abc*+   ab+c*  Operands First
 * 
 * Notice that the inorder notation is ambiguous!  These two are the same, but
 * show different trees.  This shows that inorder traversal requires parens.
 * 
 * However, both pre and post order notations are paren free, we need no parens
 * to make sure we are describing a unique order of operations.  In fact, the
 * calculation method of RPN is basically just preorder notation of a paren
 * string.
 * 
 * We use the -fix phrasing to denote we are talking about notation. So
 * prefix, postfix, infix refer to notation that mimics the above traversals
 * 
 * 
 * @author wpower
 */
public class StackApplications {

}
