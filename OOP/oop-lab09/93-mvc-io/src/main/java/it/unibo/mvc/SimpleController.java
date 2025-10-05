package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> stringHistory = new LinkedList<>();
    private String nextString;

    @Override
    public void nextString(final String nextString) {
        this.nextString = Objects.requireNonNull(nextString, "This method does not accept null values.");
    }

    @Override
    public String printNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getAllStrings() {
        return Collections.unmodifiableList(stringHistory);
    }

    @Override
    public void printCurret() {
        if (this.nextString == null) {
            throw new IllegalStateException("Non c'è nessuna stringa");
        }
        stringHistory.add(this.nextString);
        System.out.println(this.nextString); // NOPMD: allowed in exercises
    }
}
