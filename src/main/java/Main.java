import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj w programie wordsApp 0.1");

        List<String> sortedList = FileReader.sortList(FileReader.readFile("slowa.txt"));

        while (true) {
            String randomWord = FileReader.randomWord(sortedList);
            String[] meaning = Word.splitWord(randomWord);

            System.out.println(Word.checkAnswer(meaning));

        }


    }
}