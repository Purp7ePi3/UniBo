package it.unibo.collections.sets;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
            TreeSet<String> treeSet = new TreeSet<>();

        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for(int i = 1; i <= ELEMS; i++){
            treeSet.add(String.valueOf(i));
        }
        /*
         * 3) Prints its content
         */
        System.out.println(treeSet);
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        TreeSet<String> ToRemove = new TreeSet<>();

        for(String c : treeSet){
            int value = Integer.parseInt(c);
            if(value % 3 == 0){
                ToRemove.add(c);
            }
        }
        treeSet.removeAll(ToRemove);
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        System.out.println(treeSet);

        /*
         * 6) Verifies whether all the numbers left in the set are even
        */
        for (String c : treeSet) {
            int num = Integer.parseInt(c);
            if(num % 3 == 0){
                System.out.println("Sono pari");
            }
        }
    }
}
