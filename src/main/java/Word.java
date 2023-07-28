import java.util.Scanner;

public class Word {

    static int[] goodBadAnswers = new int[2];

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
            goodBadAnswers[0]++;
            return "ok";
        }
        goodBadAnswers[1]++;
        return "zle, poprawna odpowiedz to : " + separatedWord[1];

    }

    public static String results(int[] answers) {

        return answers[0] + " - odpowiedzi poprawne\n" + answers[1] + " - odpowiedzi bledne";
    }
}
