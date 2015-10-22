/*
 * **** Classwork for CIS2168 at Temple University ****
 * File created and owned by William Power.
 * No license.  It is against the academic honesty policy to
 * copy the code in this file, or any file in the repo.
 */
package classnotes.stacks;

import java.util.LinkedList;

public class Stacks {

    /**
     * <Stacks>
     *
     * History - stuff. idk.
     *
     * Stacks are a data structure that performs two basic operations:
     *
     * push()
     *
     * pop()
     *
     * A stack starts empty, and we can push items to it, then pop them off.
     * A push always increases the size of the stack, and adds the item to the 'top'
     * A pop always reduces the size of the stack and removes the item at the 'top'
     *
     * <Application>
     *
     * We can use them to solve the multi type paren matching problem. As you read
     * a paren string, you push left parens onto a stack. Everytime you hit a right
     * paren, pop a paren off the stack, if its type matchs, continue, if not, you
     * have an invalid paren string.
     *
     * <Implementing Stacks>
     *
     * As a data structure, there are many ways to implement it. We first consider
     * a fixed size array.
     *
     * <Fixed Size Array>
     *
     * Maintain an array that can hold values, and track a pointer to the top item.
     *
     */
    private static class stack_array {

        int[] data;
        int top;

        public stack_array() {
            data = new int[500];
            top = -1;
        }

        public int pop() {
            //Need to check underflow
            return data[top--];
        }

        public void push(int n) {
            //Need to check overflow
            data[++top] = n;
        }

        /**
         * These are sometimes also provided by a stack api
         */
        public int peek() {
            return data[top];
        }

        public boolean overflow() {
            return false;
        }

        public boolean underflow() {
            return true;
        }

        public void print() {
            System.out.print("( ");
            for (int i = 0; i < top; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.print(")\n");
        }
    }
    
    /**
     * <Linked List>
     * 
     * Track the items in a linked list.  Push and pop add, remove nodes.
     */
    private static class stack_linkedlist {
        
        private static class btnode{
            int info;
            btnode link;
            public btnode(){
                
            }
        }
        
        btnode data;
        
        public stack_linkedlist(){
            data = null;
        }
        
        public int pop(){
            //Save the info for root. 
            
            //Make roots link the new root
            
            //Return the info
            return 1;
        }
        public void push( int n ){
            //Make a new node with n
            
            //Make its link point to the root
            
            //Make it the new root.
        }
        /**
         * Underflow, overflow could be more easily managed by tracking a
         * size variable, then checking that against some parameters.
         * 
         * Peek would just return the value at root.
         */
        public int peek(){
            return data.info;
        }
    }
    
    /**
     * <Linked List w/ API>
     * Shows how easy the API makes things.  Also, Java treats its linked lists
     * like stacks already.  The familiar methods are in the API.
     */
    private static class stack_linkedlist_api {
        
        LinkedList<Integer> data;
        
        public stack_linkedlist_api(){
            data = new LinkedList<Integer>();
        }
        
        public int pop(){
            return data.pop();
        }
        public void push( int n ){
            data.push(new Integer(n));
        }
        public int peek(){
            return data.peek();
        }
        
    }
    
    
    
    public static void main(String[] args) {

        stack_array s = new stack_array();
        for (int i = 0; i < 10; i++) {
            s.push(i * 10);
        }
        s.print();

    }
}
