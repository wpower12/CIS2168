 /*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.graphs;

import java.util.LinkedList;
import java.util.List;

/**
 * <Graphs>
 *
 * Graphs are a generalization of trees. They are a data structure that
 * contains vertices and edges that can connect them. We've looked at these
 * ad nauseum in discrete math.
 *
 * We denote the collection of vertices and edges as V, and E.
 *
 * We will only look at simple graphs for now, no loops or multi edges.
 *
 * Graphs can be weighted, un/directed
 *
 * There are common tasks for graphs that we'd like algos for:
 *
 * isConnected(), search(), findShortestPath(), and moreeeeeee
 *
 *
 * @author wpower
 */
public class Graph {

    private class Vertex {

        private boolean visited;
        private int distance;
        private Object parent;
    }

    private void resetVDP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Iterable<Vertex> adjacent(Vertex curr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int NODES = 10;
    int EDGES = 10;
    /**
     * There are a few ways to represent graphs
     *
     * <Adjacency Matrix>
     */
    int[][] adj_matrix = new int[NODES][NODES];
    /**
     * Each entry [i][j] is 0 if there is no edge, 1 if there is, from i to j
     *
     * For a Weighted graph, the edge weights could be stored in the entry.
     *
     * Takes O(|V|^2) storage space
     *
     * <Successor Lists>
     */
    List[] succ_lists = new List[NODES];
    /**
     * Each entry [i] is a list representing the nodes that can be immediatly
     * reached from the node i.
     *
     * Takes about n^2 again.
     */

    /**
     * <Traversing>
     *
     * We want to do BFS and DFS in our graph. In s tree we could assume that
     * only one path exists from some root to a node. This let us avoid
     * visiting the same node twice.
     *
     * In graphs we need to explicitly track this visited state because there
     * may be more than one path between any two nodes.
     *
     * To do this we'll use a FIFO Queue. To implement the queue we can make
     * use of the LinkedList Data Structure
     */
    private LinkedList<Vertex> queue = new LinkedList<>();

    public void BFS(Graph g, Vertex s) {
        g.resetVDP(); //Set all nodes Visited, Distance, and Parent to 0-values
        s.visited = true;
        s.distance = 0;
        s.parent = null;
        queue.add(s);
        Vertex curr;
        while (!queue.isEmpty()) {
            curr = queue.pop();
            for (Vertex a : g.adjacent(curr)) {
                if (!a.visited) {
                    a.visited = true;
                    a.distance = curr.distance + 1;
                    a.parent = curr;
                    //Visit the node!
                    queue.add(a);
                }
            }

        }
    }

    /**
     * A BFS of a graph from a node will give you a tree representing all
     * the paths from the node to all the others it can reach.
     *
     * If unconnected, there will be multiple trees. A forest.
     *
     * A connected graph will only have 1 tree for any chosen start node.
     *
     * For a connected graph, we call this the <spanning tree> from that root.
     *
     *
     * A BFS will also give you the minimum path from the source to all
     * connected nodes if there are no weights. Also works for directed and undirected.
     *
     * You still need DSP to do weighted search.
     * <DSP> - Use notes from Discrete.
     *
     * <Depth First Search>
     *
     * For DFS, we can use a recursive solution. Analagous to preorder traversal.
     *
     * Start at the root, go as far as you can. Then back up until you can
     * traverse farther.
     *
     */
    //Need to init all visiteds/parents/distances first.
    public void DFS(Graph g, Vertex s) {
        s.visited = true;
        for (Vertex a : g.adjacent(s)) {
            if (!a.visited) {
                a.parent = s;
                DFS(g, a);
            }
        }
    }
    /**
     * This takes O(n+e) time to build the depth-first tree from the root.
     */

    public static void main(String args[]) {

    }

}
