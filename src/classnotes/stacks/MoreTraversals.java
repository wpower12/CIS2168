/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.stacks;

import java.util.Stack;

/**
 * <Recursive Traversals vs Imperative Traversals>
 * 
 * We have a standard recursive traversal of the tree, how could we traverse
 * in other orders, a binary tree without recursing?
 * 
 * It turns out we can't just track a visit node and a pred, we might not have 
 * the info to do pre or post order traversals.
 * 
 * We instead use a stack!  We've been talking about them in class, so this 
 * should be straight forward.
 * 
 * To traverse a tree with a stack, we push pointers to nodes as we traverse a 
 * tree.  This stores them so we can later go back and see if there are other
 * links to traverse.
 * 
 * @author wpower
 */
public class MoreTraversals {
    
    private static class BTNode {
        int info;
        BTNode left, right;

        private BTNode(int i) {
            info = i;
            left = null;
            right = null;
        }

        private BTNode(int i, BTNode l, BTNode r) {
            info = i;
            left = l;
            right = r;
        }
    }
    private static Stack<BTNode> stack;  //Pretend you have a container with the stack api
    
    public static void preorder_traverse( BTNode t ){
    /**
     * preorder traversal is RtLR
     * 
     * This means, we visit the root, then push root to a stack, then move 
     * left.
     * 
     * If we have no node to the left, we pull a node from the stack, and go
     * right.
     * 
     */
        stack = new Stack();
        BTNode p = t;
        while( (p != null) || !stack.empty()){
            //visit( p ); If we had something to do. 
            stack.push(p);              //Add it to the stack
            if( p.left == null ){       //If theres no left
                p = stack.pop().right;  //Pop and go right.
            } else {
                p = p.left;             //Else just go left.
            }
        }
    }
    
}
