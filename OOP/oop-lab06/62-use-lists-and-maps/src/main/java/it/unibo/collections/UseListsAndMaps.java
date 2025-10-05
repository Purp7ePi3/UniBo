package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> list= new ArrayList<>();
        for(int i = 1000; i < 2000; i++){
            list.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linked = new LinkedList<>(list);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        list.set(0, linked.getLast());
        list.set(linked.size() - 1, linked.get(0));

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        /*for (int i : list){
            System.out.print(i + "->");
        }*/

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

        measureInsertionTime(list, "ArrayList");
        measureInsertionTime(linked, "LinkedList");

         /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        measureReadingTime(list, "ArrayList");
        measureReadingTime(linked, "LinkedList");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        
        Map<String, Long> continentPopulation = new HashMap<>();
        continentPopulation.put("Africa", 1_110_635_000L);
        continentPopulation.put("Americas", 972_005_000L);
        continentPopulation.put("Antarctica", 0L);
        continentPopulation.put("Asia", 4_298_723_000L);
        continentPopulation.put("Europe", 742_452_000L);
        continentPopulation.put("Oceania", 38_304_000L);

        for (Entry<String, Long> entry : continentPopulation.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*
         * 8) Compute the population of the world
         */
        
        Long TotalPouplation = 0L;

        for(Long people : continentPopulation.values()){
            TotalPouplation += people; 
        }
        System.out.println("Total World Population -> " + TotalPouplation);


        List<Entry<String, Long>> entryList = new ArrayList<>(continentPopulation.entrySet());

        // Sort the list by values (population)
        entryList.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));

        // Store the sorted entries in a LinkedHashMap to maintain order
        Map<String, Long> sortedMap = new LinkedHashMap<>();
        for (Entry<String, Long> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        // Print the sorted map entries
        
    }

    private static void measureInsertionTime(List<Integer> list, String listType) {
        final int Elem = 100000;
    
        long time = System.nanoTime();
        for (int i = 0; i < Elem; i++) {
            list.add(0, i);
        }
        time = System.nanoTime() - time;
    
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to insert " + (list.size() - 1000) + " elements at the beginning of " + listType + ": " + millis + " ms");
    }

    private static void measureReadingTime(List<Integer> list, String listType){
        final int ToRead = list.size() / 2;

        long time = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            list.get(ToRead);
        }
        time = System.nanoTime() - time;
        long millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time to read 1000 times element at position: " + ToRead + ": " + millis + " ms");

    }
}