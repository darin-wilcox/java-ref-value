package org.zoikks.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * An example of Java as a pass-by-value and not pass-by-reference.
 *
 * Pass by Value: The method parameter values are copied to another variable and then the copied object is passed, that
 *  is why it's called pass by value.
 *
 * Pass by Reference: An alias or reference to the actual parameter is passed to the method, that's by it is called
 *  pass by reference.
 *
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private Balloon red = new Balloon("Red");
    private Balloon blue = new Balloon("Blue");

    public static void main(String... args) {

        new Main();
    }

    private Main() {

        LOG.debug("Red: " + red);
        LOG.debug("Blue: " + blue);

        // Try swapping red and blue and see if the values are actually different...
        swap(red, blue);
        LOG.debug("red color=" + red.getColor());   // Still outputs "Red"
        LOG.debug("blue color=" + blue.getColor()); // Still outputs "Blue"

        foo(blue);
        LOG.debug("blue color=" + blue.getColor());
    }

    /**
     * Example of a new Balloon being instantiated but is done on the Stack while the
     * @param balloon
     */
    private void foo(Balloon balloon) {
        balloon.setColor("Red");
        balloon = new Balloon("Green");
        balloon.setColor("Blue");
    }

    /**
     * Demonstrates the pass-by-value concept in that the original values aren't changed.  The two arguments are copies
     *  of the original values pointing at the same objects.  However, changes happening in the method changes the
     *  copies in the method not the original values.
     * @param b1
     * @param b2
     */
    private void swap(Balloon b1, Balloon b2) {

        LOG.debug("Red Copy: " + b1);
        LOG.debug("Blue Copy: " + b2);

        Balloon tmp = b1;
        b1 = b2;
        b2 = tmp;
    }
}