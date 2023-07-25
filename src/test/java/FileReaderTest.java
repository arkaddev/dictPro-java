import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileReaderTest {

    @Test
    void readFile() {
        String path = "src/test/java/ReadFileTest";
        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        FileReader fileReader = new FileReader();
        List<String> outputList = new ArrayList<>();
        outputList = FileReader.readFile(path);


        Assertions.assertEquals(expectedList, outputList);
    }

    @Test
    void sortList() {
        List<String> list = Arrays.asList(
                "yes - tak",
                "where - gdzie",
                "A"
        );

        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        List<String> outputList = new ArrayList<>();
        outputList = FileReader.sortList(list);

        Assertions.assertEquals(expectedList, outputList);
    }
}