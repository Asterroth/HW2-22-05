import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyData {

    FileReader reader = new FileReader();
    DataPaths paths = new DataPaths();
    Path dataDir = Path.of("./resources/");

    public HashMap<String, HashMap<String, Integer>> getMonthData (ArrayList dataPath) throws IOException {
        HashMap<String, HashMap<String, Integer>> result = new HashMap<>();
        ArrayList<Path> monthPaths;
        monthPaths = paths.listFiles(dataDir, "m");
        for (Path path : monthPaths) {
            String content = reader.readFile(path);
            String[] lines = content.split("\r\n");
            File file = new File(String.valueOf(path));
            String monthkey = file.getName().substring(6, 8) + "/" + file.getName().substring(2, 6);
            HashMap<String, Integer> dataArrItem = new HashMap<>();
            Integer revOrExp = null;
            //Integer expense = null;
            //Integer keyMonth = null;
            for (int j = 1; j < lines.length; j++) {

                String line = lines[j];
                String[] parts = line.split(",");
                String keyItem = parts[0];
                Integer value = null;
                if (!Boolean.parseBoolean(parts[1])) {
                    value = Integer.parseInt(parts[2]) * Integer.parseInt(parts[3]);
                } else {
                    value = -Integer.parseInt(parts[2]) * Integer.parseInt(parts[3]);
                }
                dataArrItem.put(keyItem, value);
            }
            result.put(monthkey, dataArrItem);
        }
        return result;

    }
}
