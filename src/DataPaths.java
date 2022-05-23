import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.util.stream.Collectors.toList;

public class DataPaths {

    public static ArrayList<Path> listFiles (Path path, String mORy) throws IOException {
        try {
            ArrayList<Path> result = new ArrayList<>();
            ArrayList<Path> totalList;
            try (var walk = Files.walk(path)) {
                totalList = (ArrayList<Path>) walk.filter(Files::isRegularFile).collect(toList());
            }
            //return result;
            for (Path filePath : totalList) {
                File file = new File(String.valueOf(filePath));
                if (file.getName().matches(mORy + "(.*)")) {
                    result.add(filePath);
                }
            }
            return result;
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом.\nВозможно, файл не находится в нужной директории.");
            //e.printStackTrace();
            return null;
        }

    }
/*
    public static ArrayList<Path> monthsFiles (ArrayList<Path> filesList) throws IOException {
        ArrayList<Path> result = new ArrayList<>();
        for (Path path : filesList) {
            File file = new File(String.valueOf(path));
            if (file.getName().matches("m(.*)")) {
                result.add(path);
            }
        }
        return result;
    }*/
}
