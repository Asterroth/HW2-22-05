import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path dataDir = Path.of("./resources/");
        DataPaths data = new DataPaths();
        YearlyData years = new YearlyData();
        MonthlyData months = new MonthlyData();
        Statistic statistic = new Statistic();

        while (true) {
            printMenu();
            switch (checkMenuInput()) {
                case 1:
                    if (months.getMonthData(data.listFiles(dataDir, "m")).size() != 0) {
                        System.out.println("Данные месячных отчетов загружены!");
                    }
                    break;
                case 2:
                    if (years.getYearData(data.listFiles(dataDir, "y")).size() != 0) {
                        System.out.println("Данные годового отчета загружены!");
                    }
                    break;
                case 3:
                    System.out.println("Данные не загружены. Выберите п. №1 и п. №2 меню.");
                    break;
                case 4:
                    HashMap<String, HashMap<String, Integer>> dataMonths = months.getMonthData(data.listFiles(dataDir, "m"));
                    for (String period : dataMonths.keySet()) {
                        System.out.println("По данным отчета за " + period);
                        statistic.getMaxOfRevenue(dataMonths.get(period));
                        statistic.getMaxOfExpense(dataMonths.get(period));
                    }
                    //System.out.println("Данные не загружены. Выберите \"1 - Считать все месячные отчеты\"");
                    break;
                case 5:
                    Statistic.getProfitOrLoss(years.getYearData(data.listFiles(dataDir, "y")));
                    //System.out.println("Данные не загружены. Выберите \"2 - Считать годовой отчет\"");
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Такого пункта нет. Выберете 1,2,3,4 или 5, для выхода введите 0.");
                    break;
            }
        }

    }

    // Вывод основного меню.
    private static void printMenu() {
        System.out.println("\nПожалуйста, выберете, что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчеты.");
        System.out.println("2 - Считать годовой отчет.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию о всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("0 - Выйти из приложения");
    }

    private static Integer checkMenuInput () {
        System.out.println("Введите число 1, 2, 3, 4 или 5, для выхода введите 0: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Введите число 1, 2, 3, 4 или 5, для выхода введите 0: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}