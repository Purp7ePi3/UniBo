package it.unibo.mvc;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Controller {

    /**
     * 
     * @param next string to be printed
     * @throws IOException 
     */
    void nextString(String next) throws IOException;

    /**
     *@return next string to print
     */
    String printNextString();

    /**
     * 
     * @return all old strings
     */
    List<String> getAllStrings();

    /**
     *   @throws Current string
     */
    void printCurret();
}
