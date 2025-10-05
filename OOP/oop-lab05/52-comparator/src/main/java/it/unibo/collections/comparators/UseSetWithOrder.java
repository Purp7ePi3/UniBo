package it.unibo.collections.comparators;

import java.util.Set;
import java.util.TreeSet;

import it.unibo.collections.comparators.order.StringToDoubleComparator;

/**
 * 
 */
public final class UseSetWithOrder {

    private UseSetWithOrder() {
    }

    /**
     * @param s
     *            ignored
     */
    public static void main(final String[] s) {

        /*
         * Write a program which:
         * 
         * 1) Creates a new ORDERED TreeSet of Strings.
         * To order the set, define a new Comparator in a separate class.
         * The comparator must convert the strings to double, then compare the doubles to find the biggest.
         * The comparator does not need to deal with the case of Strings which are not parseable as doubles.
         */

        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0; i < 15; i++) {
            int randomValue = (int) (Math.random() * 101);
            treeSet.add(Integer.toString(randomValue));
        }

        TreeSet<String> order = new TreeSet<>(new StringToDoubleComparator());

        order.addAll(treeSet); // Aggiunge gli stessi elementi
        
        // Stampa del set ordinato
        System.out.println("Elementi non ordinati: " + treeSet);
        System.out.println("Elementi che ordinati: " + order);
    }
}
