/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw1;
//**********************************************************
// FILE: NAME   : intcoll1client.java
// DESCRIPTION  : This is a client of class Intcoll1.
//**********************************************************

import java.util.*;

public class Intcoll1client {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {

        //All 0
        Intcoll1 P = new Intcoll1(), N = new Intcoll1(), L = new Intcoll1();
        System.out.println("T1 - All Lists 0");
        P.insert(0);
        N.insert(0);
        L.insert(0);
        P.print();
        N.print();
        L.print();
        System.out.println("T1 - No printout = pass");

        //Test Insert
        P = new Intcoll1();
        N = new Intcoll1();
        L = new Intcoll1();
        System.out.println("T2 - Testing Insert");

        P.insert(10);
        N.insert(10);
        L.insert(10);
        P.insert(10);
        N.insert(10);
        L.insert(10);
        P.insert(0);
        N.insert(0);
        L.insert(0);
        P.insert(20);
        N.insert(20);
        L.insert(20);

        P.print();
        N.print();
        L.print();

        //Test Omit
        P = new Intcoll1();
        N = new Intcoll1();
        L = new Intcoll1();
        System.out.println("T3 - Testing Omit");

        P.insert(10);
        P.insert(20);

        P.print();

        P.omit(10);

        P.print();
        System.out.println("Should remove 10");

        //Test Equals - Not Equal
        P = new Intcoll1();
        N = new Intcoll1();
        L = new Intcoll1();
        System.out.println("T4 - Testing Equal (False)");

        P.insert(10);
        N.insert(10);
        P.insert(20);
        N.insert(20);
        P.insert(30);
        N.insert(40);

        P.print();
        N.print();
        if (P.equals(N)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
        
        //Test Equals - Equal
        P = new Intcoll1();
        N = new Intcoll1();
        L = new Intcoll1();
        System.out.println("T5 - Testing Equal (True)");

        P.insert(10);
        N.insert(10);
        P.insert(20);
        N.insert(20);
        P.insert(30);
        N.insert(30);

        P.print();
        N.print();
        if (P.equals(N)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
