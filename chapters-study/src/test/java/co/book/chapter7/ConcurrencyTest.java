package co.book.chapter7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConcurrencyTest {

    @Test
    @DisplayName("Smoke Test")
    void test1(){
        assert(true);
    }



    @Test
    @DisplayName("get values  ")
    void getMapFromLengthKeyToValStr1(){
        //lions,bears
        ConcurrentMap<Integer, String> mp1 = Concurrency.getMapFromLengthKeyToValStr("lions","tigers","bears");
        assertThat(mp1.get(5), is("lions,bears"));
    }
}
