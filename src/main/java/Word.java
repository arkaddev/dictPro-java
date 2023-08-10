import java.util.List;
import java.util.Scanner;

public class Word {

    static int[] goodBadAnswers = new int[2];

    public static String[] splitWord(String word) {

        String[] result = new String[2];
        result[0] = word.substring(0, word.indexOf("-") - 1);
        result[1] = word.substring(word.indexOf("-") + 2, word.length());

        return result;
    }


    public static String scanner(String[] separatedWord) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj znaczenie slowa: " + separatedWord[0]);
        String input = scanner.nextLine();

        return input;
    }

    public static String getPrompt(String[] separatedWord) {
        String output = "";
        char[] word = separatedWord[1].toCharArray();

        for (int i = 0; i < word.length; i++) {
            if (Character.isLetter(word[i])) {
                output = output + "-";
            } else {
                output = output + " ";
            }
        }
        return output;
    }

    public static String checkAnswer(String[] separatedWord, String input) {

        if (separatedWord[1].equals(input)) {
            goodBadAnswers[0]++;
            return "ok";
        }
        goodBadAnswers[1]++;
        return "zle, poprawna odpowiedz to : " + separatedWord[1];
    }

    public static int results(int[] answers) {

        return (answers[0] * 100) / (answers[0] + answers[1]);
    }

}
