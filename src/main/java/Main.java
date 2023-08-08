import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static int amountOfQuestion = 20;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Witaj w programie wordsApp 0.1");

        Result result = new Result();

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

                for (int i = 0; i < amountOfQuestion; i++) {
                    String randomWord = FileReader.randomWord(sortedList);
                    String[] arrayOfWords = Word.splitWord(randomWord);

                    System.out.println(Word.checkAnswer(arrayOfWords));
                }
                // message about outcome
                System.out.println("----------------------------------\n" + Word.results(Word.goodBadAnswers) + " %");
                // save outcome to file
                FileReader.saveListToFile("results", FileReader.openFileToSave("results"));
                // show best results
                result.bestResults(10);
                break;
            case 2:
                break;
            case 3:
                result.bestResults(100);
                break;
            default:
                System.out.println("Nieprawidlowy numer");
        }


    }
}