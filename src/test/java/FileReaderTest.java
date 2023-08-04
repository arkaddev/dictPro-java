import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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


        assertEquals(expectedList, outputList);
    }

    @Test
    void sortList() {
        List<String> list = Arrays.asList(
                "yes - tak",
                "where - gdzie",
                "A",
                "empty",
                "12345"
        );

        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        List<String> outputList = new ArrayList<>();
        outputList = FileReader.sortList(list);

        assertEquals(expectedList, outputList);
    }

    @Test
    void randomWord() {
        List<String> list = Arrays.asList(
                "element",
                "element2",
                "element3"
        );

        String word = FileReader.randomWord(list);

        assertTrue(list.contains(word));
    }

    @Test
    void randomWordWithEmptyList() {
        final List<String> list = Arrays.asList();

        assertThrows(IllegalArgumentException.class, () -> FileReader.randomWord(list));
    }

    @Test
    void openFileToSave() throws FileNotFoundException {
        String path = "src/test/java/ReadFileTest";
        List<String> expectedList = Arrays.asList(
                "yes - tak",
                "where - gdzie"
        );

        FileReader fileReader = new FileReader();
        List<String> outputList = new ArrayList<>();
        outputList = FileReader.openFileToSave(path);

        assertEquals(expectedList, outputList);
    }

    @Test
    void openFileToSaveWhenFileNotExist() {
        String path = "badPath";

        assertThrows(FileNotFoundException.class, () -> FileReader.openFileToSave(path));
    }

    @Test
    void saveListToFile() {

    }

    @Test
    void getDateAndTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        assertEquals(simpleDateFormat.format(date), FileReader.getDateAndTime());
    }
}