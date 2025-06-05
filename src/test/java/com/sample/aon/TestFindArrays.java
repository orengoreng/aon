package com.sample.aon;

import com.sample.aon.exercise.FindArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TestFindArrays {

    @Test
    public void testFindStartIndex() {
        FindArrays test1 = new FindArrays(new int[]{4,9,3,7,8}, new int[]{3,7});
        FindArrays test2 = new FindArrays(new int[]{3,3,3,9,8,3,7,6}, new int[]{3,7});

        Assertions.assertEquals(2, test1.findStartingIndex());

        Assertions.assertEquals(5, test2.findStartingIndex());
    }


}
