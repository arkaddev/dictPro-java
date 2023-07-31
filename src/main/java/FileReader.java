import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FileReader {


    public static List<String> readFile(String nameOfFile) {

        List<String> listWithWords = new ArrayList<>();

        try {
            File file = new File(nameOfFile); // reading the file
            Scanner readWordFile = new Scanner(file);
            System.out.println("Zaladowano plik: " + nameOfFile);

            while (readWordFile.hasNextLine()) {
                String oneWord = readWordFile.nextLine();
                listWithWords.add(oneWord); // adding to the list
            }

            System.out.println("W pliku znajduje sie: " + listWithWords.size() + " wyrazow");
            readWordFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        return listWithWords;
    }

    public static List<String> sortList(List<String> listToSort) {

        List<String> sortedList = new ArrayList<>();

        for (int i = 0; i < listToSort.size(); i++) {
            if (listToSort.get(i).contains("-")) {
                sortedList.add(listToSort.get(i));
            }
        }
        System.out.println("Posortowana lista zawiera: " + sortedList.size() + " wyrazow");
        return sortedList;
    }

    public static String randomWord(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Lista nie zawiera elementow");
        }

        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index);
    }

    public static List<String> openFileToSave(String nameOfFile) throws FileNotFoundException {
        List<String> statisticsList = new ArrayList<>();

        try {
            File resultsFile = new File(nameOfFile);
            Scanner readResults = new Scanner(resultsFile);
            while (readResults.hasNextLine()) {
                String userData = readResults.nextLine();
                statisticsList.add(userData);
            }
            readResults.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku.");
            throw new FileNotFoundException();
        }
        return statisticsList;
    }

    public static void saveListToFile(String nameOfFile, List<String> statisticsList) {
        try {
            FileWriter saveFile = new FileWriter(nameOfFile);
            for (int i = 0; i < statisticsList.size(); i++) {
                String name = statisticsList.get(i);
                saveFile.write(name + "\n");
            }

            saveFile.write(Word.results(Word.goodBadAnswers));
            saveFile.close();
            System.out.println("Wynik zostal zapisany");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDateAndTime() {
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        return date + " " + time;
    }


}
