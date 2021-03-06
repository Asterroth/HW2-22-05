import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearlyData {

    FileReader reader = new FileReader();
    DataPaths paths = new DataPaths();
    Path dataDir = Path.of("./resources/");

    //public void getYearData (ArrayList dataPath) throws IOException {
   public HashMap<String, HashMap<Integer, Integer[]>> getYearData (ArrayList dataPath) throws IOException {
        HashMap<String, HashMap<Integer, Integer[]>> result = new HashMap<>();
        ArrayList<Path> yearPaths;
        yearPaths = paths.listFiles(dataDir, "y");
        for (Path path : yearPaths) {
            String content = reader.readFile(path);
            String[] lines = content.split("\r\n");
            File file = new File(String.valueOf(path));
            String yearkey = file.getName().substring(2, 6);
            HashMap<Integer, Integer[]> dataArrMonth = new HashMap<>();
            //Integer[] dataInMonth = new Integer[2];
            Integer revenue = null;
            Integer expense = null;
            Integer keyMonth = null;
            for (int j = 1; j < lines.length; j++) {

                String line = lines[j];
                String[] parts = line.split(",");

                //dataArray[0] = Integer.parseInt(parts[0]);
                //for (int k =0; k < 2; k++) {
                    if (!Boolean.parseBoolean(parts[2])) {
                        //dataInMonth[0] = Integer.parseInt(parts[1]);
                        revenue  = Integer.parseInt(parts[1]);
                    } else {
                        //dataInMonth[1] = Integer.parseInt(parts[1]);
                        expense = Integer.parseInt(parts[1]);
                    }
                //}
                if (j % 2 == 0) {
                    Integer[] dataInMonth = new Integer[2];
                    dataInMonth[0] = revenue;
                    dataInMonth[1] = expense;
                    keyMonth = Integer.parseInt(parts[0]);
                    dataArrMonth.put(keyMonth, dataInMonth);
                    //dataArrMonth.c
                }

                //result.put(yearkey, dataArrMonth);
            }
            result.put(yearkey, dataArrMonth);
        }
        return result;
    }

    private String monthName (String monthID) {
        String nameOfMonth = "";
        switch (monthID) {
            case "01":
                nameOfMonth = "????????????";
                break;
            case "02":
                nameOfMonth = "??????????????";
                break;
            case "03":
                nameOfMonth = "????????";
                break;
            case "04":
                nameOfMonth = "????????????";
                break;
            case "05":
                nameOfMonth = "??????";
                break;
            case "06":
                nameOfMonth = "????????";
                break;
            case "07":
                nameOfMonth = "????????";
                break;
            case "08":
                nameOfMonth = "????????????";
                break;
            case "09":
                nameOfMonth = "????????????????";
                break;
            case "10":
                nameOfMonth = "??????????????";
                break;
            case "11":
                nameOfMonth = "????????????";
                break;
            case "12":
                nameOfMonth = "??????????????";
                break;
        }
        return nameOfMonth;
    }
}
