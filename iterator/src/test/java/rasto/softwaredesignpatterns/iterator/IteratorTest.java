package rasto.softwaredesignpatterns.iterator;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rastislav Zlacky (rastislav.zlacky@inventi.cz) on 19.08.2018.
 */
public class IteratorTest {

    private static final Integer[] testArray = {1, 2, 6, 10, 12, 60, 55};

    @Test
    public void iteratorTest() {
        IterableArray<Integer> iterableArray = new IterableArray<>(testArray);

        List<Integer> values = new ArrayList<>();
        for (Integer i : iterableArray) {
            values.add(i);
        }

        Assert.assertEquals(testArray, values.toArray());
    }
}
