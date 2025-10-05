package it.unibo.collections.comparators.order;

import java.util.Comparator;

public class StringToDoubleComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        try {
            // Convert strings to doubles and compare
            Double d1 = Double.parseDouble(s1);
            Double d2 = Double.parseDouble(s2);
            return d1.compareTo(d2);
        } catch (NumberFormatException e) {
            // If parsing fails, consider both strings equal (return 0)
            return 0;
        }
    }
}
