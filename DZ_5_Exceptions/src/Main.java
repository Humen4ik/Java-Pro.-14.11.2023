public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"5", "3", "2", "8"},
                        {"2", "1", "6", "4"},
                        {"8", "3", "7", "9"},
                        {"3", "8", "2", "5"}};

        // Масив з неправильним розміром
        String[][] arr1 = {{"5", "3", "2", "8"},
                {"2", "1", "6", "4"},
                {"8", "3", "7", "9"},};

        // Масив з помилковим типом у комірці
        String[][] arr2 = {{"5", "3", "2", "8"},
                {"2", "1", "6", "4"},
                {"8", "3", "abc", "9"},
                {"3", "8", "2", "5"}};

        ArrayValueCalculator calc = new ArrayValueCalculator();
        try {
            int sum = calc.doCalc(arr);
            System.out.println("Сума масиву = " + sum);
        } catch (ArrayDataException | ArraySizeException ex) {
            throw new RuntimeException(ex);
        }
    }
}