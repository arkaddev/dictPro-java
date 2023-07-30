import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Witaj w programie wordsApp 0.1");

        System.out.println("-----------------");
        System.out.println("1. Test");
        System.out.println("2.");
        System.out.println("3. Lista wynikow");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz menu:");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                List<String> sortedList = FileReader.sortList(FileReader.readFile("slowa.txt"));

                for (int i = 0; i < 10; i++) {
                    String randomWord = FileReader.randomWord(sortedList);
                    String[] arrayOfWords = Word.splitWord(randomWord);

                    System.out.println(Word.checkAnswer(arrayOfWords));
                }

                // System.out.println(Word.results(Word.goodBadAnswers));

                FileReader.saveListToFile("results", FileReader.openFileToSave("results"));
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Nieprawidlowy numer");
        }


    }
}