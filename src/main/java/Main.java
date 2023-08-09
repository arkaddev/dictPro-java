import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static int amountOfQuestion = 25;
    final static String fileWithWords = "slowa.txt";
    final static String fileWithResults = "results";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Witaj w programie wordsApp 0.1");

        Result result = new Result();

        System.out.println("-----------------");
        System.out.println("1. Test");
        System.out.println("2. Lista wynikow");
        System.out.println("3. Wyjscie");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wybierz menu:");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                List<String> sortedList = FileReader.sortList(FileReader.readFile(fileWithWords));

                for (int i = 0; i < amountOfQuestion; i++) {
                    String randomWord = FileReader.randomWord(sortedList);
                    String[] arrayOfWords = Word.splitWord(randomWord);

                    System.out.println(Word.checkAnswer(arrayOfWords));
                }
                // message about outcome
                System.out.println("----------------------------------\n" + Word.results(Word.goodBadAnswers) + " %");
                // save outcome to file
                FileReader.saveListToFile(fileWithResults, FileReader.openFileToSave(fileWithResults));
                // show best results
                result.bestResults(fileWithResults, 10);
                break;
            case 2:
                result.bestResults(fileWithResults, 100);
                break;
            case 3:
                System.out.println("Program zakonczony");
                break;
            default:
                System.out.println("Nieprawidlowy numer");
        }


    }
}