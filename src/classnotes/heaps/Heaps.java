/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.heaps;

/**
 * @author wpower
 *
 * <Heaps>
 *
 * We remember that a complete tree is one where all levels have as many nodes as
 * possible, and the final row only has to be filled from the left to the right
 * with no gaps.
 *
 * There are a variety of ways we can constrain the structure of a tree to
 * create some functionality.
 *
 * Another such constraint is one where we make it so all nodes have a path
 * back to the root that only visits nodes in decreasing order. IOW, all paths
 * from the root to a leaf will visit nodes of increasing value.
 *
 * IOW - For any subtree, the root of that subtree is the smallest element in
 * that subtree.
 * 
 * We say this type of tree exhibits the properties of a <Minimum Heap>
 *
 * The <Maximum Heap> is the complement, where all nodes are the largest node
 * in their subtree.
 *
 * In addition, to be considered a heap (we'll find out why later?), the tree
 * must be complete.
 *
 * 80
 *             / \
 * 20 90
 *          / \ / \
 * 50 70 25 100
 *       / \ / \ \
 * 90 85 30 500 10
 *
 * We'd like an algo that can take a tree and turn it into a complete min or
 * max tree.
 *
 * We can label the nodes, starting at the root, going from left to right, then
 * down, as if you were reading line by line.
 */
public class Heaps {

    public static Tree makeHeap(Tree t) {
        Tree b;
        int N = t.size();
        //For each node, starting at 2
        for (int i = 2; i < N; i++) {
            //Move node into correct place on path back to root.
        }
        return b;
    }
    /**
     * This is a well defined algorithm. It should always return a valid
     * min/max tree.
     *
     * After each iteration, we have added a node to a sub section of the
     * tree that is in 'Min/Max-Heap Order'. As we add more nodes to this
     * sub section, the tree gets closer to a min/max-tree. Once all nodes are
     * in the sub section, the tree must be in the correct layout.
     *
     * <Modeling This Algorithm>
     * 
     * Best Case - If the input tree is already a min tree and you are looking 
     * for a min tree, or max tree for a max tree, then only 1 comparison is
     * necessary for each node.  
     * 
     * Worst Case - If your input tree is the 'opposite' of the tree you are
     * working for, you need to make depth(n)*n many comparisons, or:
     * 
     *      O(nlogn)
     *
     * <Another Min/Max Tree Algo>
     * 
     */
    public static void makeHeap2( Tree t ){
        //Label the nodes as before
        
        int N = t.size();
        //Starting at the 'middle' node
        for( int i = (N/2); i > 0; i-- ){
            //Push node 'down' until it is in the correct place
            //Compare node to its subtrees
                //If less than both, done.
                //If not, swap node and smallest subtree root then check again
                //Loop until done
        }
    }
    /**
     * We can start in the middle because beyond that point in a complete tree,
     * all nodes have no children, and are already roots of correct min/max-trees
     * 
     * A null tree or a single node are both correct min/max-trees.
     * 
     * In this case, we are creating the sorted sub section from the leaves up.
     * We start with the 'correct set' of the leaves.  Each leaf starts as a 
     * correct subtree.  
     * 
     * While iterating, we create larger correct subtrees. 
     * 
     * Building from the bottom is super fast.  It leads to an algorithm that
     * can convert the tree in O(n).  
     * 
     * Its important to note that these two algorithms do not have to
     * produce the same min/max-heap.  
     *
     * <Inserting Into A Heap>
     * 
     * 
     * <Removing From A Heap>
     * We can remove in O(n) by taking the last element and replacing the
     * node to omit with it.  Then we preform our shift down make Tree algo
     * on that node.  This places the node in the correct place in O(n) time.
     * 
     */
    
}
