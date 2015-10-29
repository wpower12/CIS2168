/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package hw6;

import java.util.Scanner;

/**
 * Replace all elements in an intcollclient so that it uses Strings instead of
 * integers.
 *
 * Also, user input has to be changed.
 * +<word> adds word to P, L
 * -<word> adds word to N, removes word from P
 *
 * @author wpower
 */
public class StringcollClient {

    public static final String SENTINEL = "0";

    public static void main(String[] args) {
        String word;
        Scanner keyboard = new Scanner(System.in);
        MultiStringcoll P = new MultiStringcoll(), N = new MultiStringcoll(), L = new MultiStringcoll();

        System.out.println("Enter String or Strings to be inserted or 0 to quit:");
        word = keyboard.next();
        while (!word.equals(SENTINEL)) {
            System.out.println(word);
            if (word.charAt(0) != '-') {
                P.insert(word);
                L.insert(word);
            } else {
                N.insert(word.substring(1));
                L.omit(word.substring(1));
            }
            System.out.println("Enter String or Strings to be inserted or 0 to quit:");
            if (keyboard.hasNext()) {
                word = keyboard.next();
            }
        }
        System.out.println("\nThe values in collection P are: size: "+P.get_howmany());
        P.print();
        System.out.println("\nThe values in collection N are: size: "+N.get_howmany());
        N.print();
        System.out.println("\nThe values in collection L are: size: "+L.get_howmany());
        L.print();
        
        if (P.equals(N)) {
            System.out.println("\nP and N are equal.");
        } else {
            System.out.println("\nP and N are NOT equal.");
        }
        MultiStringcoll A = new MultiStringcoll();
        A.copy(L);
        System.out.println("\nThe values in the copy of L are:\n");
        A.print();
    }
}
