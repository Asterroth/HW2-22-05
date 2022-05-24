import java.util.HashMap;

public class Statistic {

    public static void getProfitOrLoss (HashMap<String, HashMap<Integer, Integer[]>> yearData) {
        for (String year : yearData.keySet()) {
            System.out.println("По данным отчета за " + year + " год:");
            for (Integer monthNo : yearData.get(year).keySet()) {
                System.out.println("Прибыль за " + monthName(monthNo) + ": " + (yearData.get(year).get(monthNo)[0] - yearData.get(year).get(monthNo)[1]));
            }
            System.out.println("Средний расход за все месяцы: " + avgOfExpense(yearData.get(year)));
            System.out.println("Средний доход за все месяцы: " + avgOfRevenue(yearData.get(year)));
        }
    }

    private static double avgOfRevenue (HashMap<Integer, Integer[]> data) {
        //double avgValue = 0;
        int sum = 0;
        for (Integer[] dataSet : data.values()) {
            sum += dataSet[0];
        }
        //avgValue = sum / data.keySet().size();
        return sum / data.values().size();
    }

    private static double avgOfExpense (HashMap<Integer, Integer[]> data) {
        //double avgValue = 0;
        int sum = 0;
        for (Integer[] dataSet : data.values()) {
            sum += dataSet[1];
        }
        //avgValue = sum / data.keySet().size();
        return sum / data.values().size();
    }

    private static String monthName(int monthID) {
        String nameOfMonth = "";
        switch (monthID) {
            case 1:
                nameOfMonth = "январь";
                break;
            case 2:
                nameOfMonth = "февраль";
                break;
            case 3:
                nameOfMonth = "март";
                break;
            case 4:
                nameOfMonth = "апрель";
                break;
            case 5:
                nameOfMonth = "май";
                break;
            case 6:
                nameOfMonth = "июнь";
                break;
            case 7:
                nameOfMonth = "июль";
                break;
            case 8:
                nameOfMonth = "август";
                break;
            case 9:
                nameOfMonth = "сентябрь";
                break;
            case 10:
                nameOfMonth = "октябрь";
                break;
            case 11:
                nameOfMonth = "ноябрь";
                break;
            case 12:
                nameOfMonth = "декабрь";
                break;
        }
        return nameOfMonth;
    }

    public static int getSumOfExpense (HashMap<String, Integer> itemList) {
        int sum = 0;
        for (Integer value : itemList.values()){
            if (value < 0) {
                sum += value;
            }
        }
        return sum;
    }

    public static int getSumOfRevenue (HashMap<String, Integer> itemList) {
        int sum = 0;
        for (Integer value : itemList.values()){
            if (value >= 0) {
                sum += value;
            }
        }
        return sum;
    }

    public static void getMaxOfRevenue (HashMap<String, Integer> itemList) {
        int max = 0;
        String itemName = "";
        for (String item : itemList.keySet()){
            if (itemList.get(item) > max) {
                max += itemList.get(item);
                itemName = String.valueOf(item);
            }
        }
        System.out.println("Макс. доход: " + itemName + ", сумма - " + max);
    }

    public static void getMaxOfExpense (HashMap<String, Integer> itemList) {
        int min = 0;
        String itemName = "";
        for (String item : itemList.keySet()){
            if (itemList.get(item) < min) {
                min += itemList.get(item);
                itemName = String.valueOf(item);
            }
        }
        System.out.println("Макс. расход: " + itemName + ", сумма - " + -min);
    }
}
