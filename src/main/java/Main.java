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

                break;
            case 2:

            case 3:
                List<Result> resultList = result.sortObjectList(result.resultsListToObjectList(FileReader.openFileToSave("results")));
                for (int i = 0; i < resultList.size(); i++) {
                    System.out.println((i + 1) + ". " + resultList.get(i).getOutcome() + "% " + resultList.get(i).getName() + " " + resultList.get(i).getDate());
                }
                break;
            default:
                System.out.println("Nieprawidlowy numer");
        }


    }
}