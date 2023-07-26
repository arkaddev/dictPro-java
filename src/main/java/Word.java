import java.util.Scanner;

public class Word {

    public static String[] splitWord(String word) {

        String[] result = new String[2];
        result[0] = word.substring(0, word.indexOf("-") - 1);
        result[1] = word.substring(word.indexOf("-") + 2, word.length());

        return result;
    }


    public static String checkAnswer(String[] separatedWord) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj znaczenie slowa: " + separatedWord[0]);
        String input = scanner.nextLine();

        if (separatedWord[1].equals(input)) {
            return "ok";
        }
        return "zla odpowiedz";

    }
}
