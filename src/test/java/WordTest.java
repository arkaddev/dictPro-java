import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.SimpleTimeZone;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void splitWord() {
        String input = "yes - tak";

        String[] separatedWord = Word.splitWord(input);

        assertEquals(2, separatedWord.length);

        assertEquals("yes", separatedWord[0]);
        assertEquals("tak", separatedWord[1]);
    }

    @Test
    void checkAnswerWhenGoodAnswer() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        InputStream inputStream = new ByteArrayInputStream("tak".getBytes());
        System.setIn(inputStream);

        String output = Word.checkAnswer(inputArray);
        String expectedOutput = "ok";

        assertEquals(expectedOutput, output);
        assertEquals(1, Word.goodBadAnswers[0]);
        assertEquals(0, Word.goodBadAnswers[1]);

        Word.goodBadAnswers[0] = 0;
        Word.goodBadAnswers[1] = 0;
    }

    @Test
    void checkAnswerWhenBadAnswer() {
        String[] inputArray = new String[2];
        inputArray[0] = "yes";
        inputArray[1] = "tak";

        InputStream inputStream = new ByteArrayInputStream("t".getBytes());
        System.setIn(inputStream);

        String output = Word.checkAnswer(inputArray);
        String expectedOutput = "zle, poprawna odpowiedz to : " + inputArray[1];

        assertEquals(expectedOutput, output);
        assertEquals(0, Word.goodBadAnswers[0]);
        assertEquals(1, Word.goodBadAnswers[1]);

        Word.goodBadAnswers[0] = 0;
        Word.goodBadAnswers[1] = 0;
    }

    @Test
    void results() {
        int[] goodBadAnswers = new int[2];
        goodBadAnswers[0] = 7;
        goodBadAnswers[1] = 3;

        String output = Word.results(goodBadAnswers);
        String expectedOutput = "7 - odpowiedzi poprawne\n3 - odpowiedzi bledne";

        assertEquals(expectedOutput, output);
    }
}