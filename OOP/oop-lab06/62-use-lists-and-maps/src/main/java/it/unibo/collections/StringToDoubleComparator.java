package it.unibo.collections;

import java.util.Comparator;

public class StringToDoubleComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
    boolean isS1Numeric = isNumeric(s1);
    boolean isS2Numeric = isNumeric(s2);

    if (isS1Numeric && isS2Numeric) {
        Double d1 = Double.parseDouble(s1);
        Double d2 = Double.parseDouble(s2);
        return d1.compareTo(d2);
    } else if (isS1Numeric) {
        return 1; // s1 is greater (numeric) than s2 (non-numeric)
    } else if (isS2Numeric) {
        return -1; // s2 is greater (numeric) than s1 (non-numeric)
    } else {
        return 0; // both are non-numeric
    }
}

private boolean isNumeric(String str) {
    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }
}
