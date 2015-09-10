/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw1;
//**********************************************************
// FILE: NAME   : intcoll1client.java
// DESCRIPTION  : This is a client of class Intcoll3.
//**********************************************************

import java.util.*;

public class Intcoll3client {

    public static final int SENTINEL = 0;

    public static void main(String[] args) {

        //All 0
        Intcoll3 P = new Intcoll3(), N = new Intcoll3(), L = new Intcoll3();
        System.out.println("T1 - All Lists 0");
        P.insert(0);
        N.insert(0);
        L.insert(0);
        P.print();
        N.print();
        L.print();
        
        //Test Insert
        P = new Intcoll3();
        N = new Intcoll3();
        L = new Intcoll3();
        System.out.println("T2 - Testing Insert");

        P.insert(10);
        P.insert(10);
        P.insert(0);
        P.insert(20);

        P.print();

        //Test Omit
        P = new Intcoll3();
        N = new Intcoll3();
        L = new Intcoll3();
        System.out.println("T3 - Testing Omit");

        P.insert(10);
        P.insert(20);

        P.print();

        P.omit(10);

        P.print();
        System.out.println("Should remove 10");

        //Test Equals - Not Equal
        P = new Intcoll3();
        N = new Intcoll3();
        L = new Intcoll3();
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
        P = new Intcoll3();
        N = new Intcoll3();
        L = new Intcoll3();
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
        
        //Testing resizing
        System.out.println("T6 - Testing Resizing");

        P = new Intcoll3( 20 );
        P.insert(1); P.insert(20);
        P.print();
        P.insert(25);
        P.print();
        P = new Intcoll3( 3 );
        P.insert(1); P.insert(2); P.insert(3);
        P.print();
        P.insert(4);
        P.print();
    }
}
