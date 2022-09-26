package leetcodetest.datastructure.duplicatetest.one;

import leetcode.datastructure.duplicate.one.Duplicate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DuplicateTest {
    @Test
    void shouldPassWithExample1() {
        Duplicate duplicate = new Duplicate();
        Assertions.assertTrue(duplicate.containsDuplicate( new int[]{1, 2, 3, 1}));
    }

    @Test
    void shouldFailWithExample2() {
        Duplicate duplicate = new Duplicate();
        Assertions.assertFalse(duplicate.containsDuplicate( new int[]{4, 2, 3, 1}));
    }

    @Test
    void shouldPassWithExample3() {
        Duplicate duplicate = new Duplicate();
        Assertions.assertTrue(duplicate.containsDuplicate( new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

}