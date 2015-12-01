package hw7;

import java.util.*;
import java.awt.Point;
import java.util.LinkedList;

public class YourMazeWithPath {

    private InputGraphicMaze maze;
    private int R, C;
    private int[][] V; //To track visited status.
    private Point[][] P; //Parents array, cell [r][c] is the 'parent' of cell rc

    public YourMazeWithPath() {
        // an R rows x C columns maze
        maze = new InputGraphicMaze();
        R = maze.Rows();
        C = maze.Cols();

        V = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                V[i][j] = 0;
            }
        }
        P = new Point[R+1][C+1];
        P[1][1] = new Point(0, 0);

        // Path holds the cells of the path
        LinkedList<Point> Path = new LinkedList<Point>();
        // Create the path
        CreatePath(maze, 1, 1, R, C, Path);
        // show the path in the maze
        maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze maze,
            int srow, int scol, int erow, int ecol, LinkedList<Point> L) {

        //First we fill the V and P arrays, then we track back
        depthFirstSearch(maze, srow, scol, erow, ecol);

        //Now starting at the end, we trace back to fill L
        int r, c;
        L.add(new Point(erow, ecol));
        Point u = P[erow][ecol];
        while (!u.equals(P[srow][scol])) {
            r = (int) u.getX();
            c = (int) u.getY();
            L.addFirst(u);
            u = P[r][c];
        }

        return true;
    }

    public static void main(String[] args) {
        new YourMazeWithPath();
    }

    private void depthFirstSearch(InputGraphicMaze maze, int srow, int scol, int erow, int ecol) {
        int r = srow, c = scol;

        if (!(r == erow && c == ecol)) {
            //Visit the node
            V[r][c] = 1;
            
            //Recursivly search all non visited neighbors.
            if ((r > 1) && (V[r - 1][c] != 1) && (maze.can_go(r, c, 'U'))) {
                P[r - 1][c] = new Point(r, c);
                depthFirstSearch(maze, r - 1, c, erow, ecol);
            }
            if ((c < C) && (V[r][c + 1] != 1) && (maze.can_go(r, c, 'R'))) {
                P[r][c + 1] = new Point(r, c);
                depthFirstSearch(maze, r, c + 1, erow, ecol);
            }
            if ((r < R) && (V[r + 1][c] != 1) && (maze.can_go(r, c, 'D'))) {
                P[r + 1][c] = new Point(r, c);
                depthFirstSearch(maze, r + 1, c, erow, ecol);
            }
            if ((c > 1) && (V[r][c - 1] != 1) && (maze.can_go(r, c, 'L'))) {    
                P[r][c - 1] = new Point(r, c);
                depthFirstSearch(maze, r, c - 1, erow, ecol);
            }
        } 
    }
}
