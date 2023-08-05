import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {


    @Test
    void resultsListToObjectList() {
        Result result = new Result();
        List<String> stringList = Arrays.asList("20%Jan@02-08-2023 19:34:18");
        List<Result> resultList = result.resultsListToObjectList(stringList);

        assertEquals(20, result.getOutcome());
        assertEquals("Jan", result.getName());
        assertEquals("02-08-2023 19:34:18", result.getDate());
    }

    @Test
    void sortObjectList() {
    }
}