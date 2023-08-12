import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
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
        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(20,"Jan","02-08-2023 19:34:18"));
        resultList.add(new Result(10,"Jan","02-08-2023 19:34:18"));
        resultList.add(new Result(30,"Jan","02-08-2023 19:34:18"));

        Result result = new Result();
        result.sortObjectList(resultList);

        assertEquals(30, resultList.get(0).getOutcome());
        assertEquals(20, resultList.get(1).getOutcome());
        assertEquals(10, resultList.get(2).getOutcome());
    }

    @Test
    void bestResults() throws FileNotFoundException {
        List<Result> resultList = new ArrayList<>();
        resultList.add(new Result(20,"Jan","02-08-2023 19:34:18"));
        resultList.add(new Result(10,"Jan","02-08-2023 19:34:18"));
        resultList.add(new Result(30,"Jan","02-08-2023 19:34:18"));


        OutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Result result = new Result();
        result.bestResults("test",5);

        String expected = "";
        String output = outputStream.toString().trim();

        assertEquals(expected, output);
    }
}