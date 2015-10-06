package hw1;
//*********************************************************************
// FILE NAME    : Intcoll3.java
// DESCRIPTION  : Intcol version with boolen array 

//*********************************************************************

public class Intcoll3 {

    private boolean[] c;
    private int howmany;

    /* Generic constructor
     * Input: none
     * Return: new Intcoll3 object
     */
    public Intcoll3() {
        c = new boolean[500 + 1];
        for (int i = 0; i < 500; i++) {
            c[i] = false;
        }
        howmany = 0;
    }

    /* Given howmany constructor
     * Input: int i, howmany of container
     * Return: new Intcoll3 object
     */
    public Intcoll3(int i) {
        c = new boolean[i + 1];
        for (int j = 0; j < i + 1; j++) {
            c[j] = false;
        }
        howmany = 0;
    }

    /* Overwrites the contents of the collection with those in obj
     * Input: Intcoll3 obj, the collection to be copied
     * Return: void
     */
    public void copy(Intcoll3 obj) {
        if (this != obj) {
            c = new boolean[obj.c.length];
            //Made changes from submitted 
            howmany = obj.get_howmany();
            int j = 0;
            while (j < obj.c.length) {
                c[j] = obj.c[j];
                j++;
            }
        }
    }

    /* Checks if the value is in the collection
     * Input: int i, value to search for
     * Return: boolean
     */
    public boolean belongs(int i) {
        return (i > 0) && (i < c.length) && c[i];
    } 

    /* Inserts the value into the list if not already present.  Handles resizing.
     * Input: int i, value to insert
     * Return: void
     */
    public void insert(int i) {
        if (i > 0) {
            if (i >= c.length) {
                //resize, deep copy, and set true
                boolean[] d = new boolean[i * 2];
                for (int j = 0; j < i * 2; j++) {
                    d[j] = false;
                    if (j < c.length) {
                        d[j] = c[j];
                    }
                }
                d[i] = true;
                c = d;
                howmany++;
            } else if (!c[i]) {
                c[i] = true;
                howmany++;
            }
        }
    }

    /* Removes i from the collection if it is present.
     * Input: int i, value to omit
     * Return: void
     */
    public void omit(int i) {
        if ((i > 0) && (i < c.length)) {
            if (c[i]) {
                c[i] = false;
                howmany--;
            }
        }
    }

    /* Returns the number of ints in the collection.
     * Input: none
     * Return: int, number of ints in collection
     */
    public int get_howmany() {
        return howmany;
    }

    /* Prints contents of collection to System.out
     * Input: none 
     * Return: void
     */
    public void print() {
        int j = 0;
        System.out.print("(");
        while (j < c.length) {
            if( c[j] ){
                System.out.print(j+" ");
            }
            j++;
        }
        System.out.print(")");
    }

    /* Checks if given collection contains the same ints.
     * Input: Intcoll3 obj, the collection to be checked
     * Return: boolean, do they match?
     */
    public boolean equals(Intcoll3 obj) {
        int j = 1;
        boolean result = (obj.get_howmany() == howmany);
        while ((j < c.length) && result) {
            result = (obj.belongs(j) == c[j]);
            j++;
        }
        return result;
    }
}
