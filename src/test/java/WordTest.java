import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.SimpleTimeZone;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void splitWord() {
        String input = "yes - tak";

        String[] separatedWord = Word.splitWord(input);

        Assertions.assertEquals(2, separatedWord.length);

        Assertions.assertEquals("yes", separatedWord[0]);
        Assertions.assertEquals("tak", separatedWord[1]);
    }

    @Test
    void checkAnswer() {
    }
}