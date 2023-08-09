import java.io.FileNotFoundException;
import java.util.*;

public class Result {
    private int outcome;
    private String name;
    private String date;

    public Result() {
    }

    public Result(int outcome, String name, String date) {
        this.outcome = outcome;
        this.name = name;
        this.date = date;
    }

    public int getOutcome() {
        return outcome;
    }

    public void setOutcome(int outcome) {
        this.outcome = outcome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Result[] resultsListToArray(List listWithAllResults) {
        List<Result> resultList = new ArrayList<>();
        Result[] arrayOfResults = new Result[listWithAllResults.size()];

        for (int i = 0; i < listWithAllResults.size(); i++) {
            String x = String.valueOf(listWithAllResults.get(i));
            outcome = Integer.parseInt(x.substring(0, x.indexOf("%")));
            name = x.substring(x.indexOf("%") + 1, x.indexOf("@"));
            date = x.substring(x.indexOf("@") + 1, x.length());

            arrayOfResults[i] = new Result(outcome, name, date);

        }
        return arrayOfResults;
    }

    public List<Result> resultsListToObjectList(List listWithAllResults) {
        List<Result> resultList = new ArrayList<>();


        for (int i = 0; i < listWithAllResults.size(); i++) {
            String x = String.valueOf(listWithAllResults.get(i));
            outcome = Integer.parseInt(x.substring(0, x.indexOf("%")));
            name = x.substring(x.indexOf("%") + 1, x.indexOf("@"));
            date = x.substring(x.indexOf("@") + 1, x.length());

            resultList.add(new Result(outcome, name, date));
        }
        return resultList;
    }

    public List<Result> sortObjectList(List objectList) {
        Collections.sort(objectList, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return Integer.compare(o2.outcome, o1.outcome);
            }
        });
        return objectList;
    }

    public void bestResults(String nameOfFile, int amount) throws FileNotFoundException {
        List<Result> resultList = sortObjectList(resultsListToObjectList(FileReader.openFileToSave(nameOfFile)));

        for (int i = 0; i < amount; i++) {
            System.out.println((i + 1) + ". " + resultList.get(i).getOutcome() + "% " + resultList.get(i).getName() + " \t" + resultList.get(i).getDate());
        }
    }

    @Override
    public String toString() {
        return outcome +
                "% " + name +
                " " + date + "\n";
    }
}
