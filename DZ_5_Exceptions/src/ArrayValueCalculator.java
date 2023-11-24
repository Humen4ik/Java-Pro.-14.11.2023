public class ArrayValueCalculator {
    public int doCalc (String[][] arr) throws ArraySizeException, ArrayDataException {
        validateArray(arr);
        return sumArray(arr);
    }

    private void validateArray(String[][] arr) throws ArraySizeException{
        if (arr.length != 4 || arr[0].length != 4)
            throw new ArraySizeException("Розмір масиву не відповідає очікуваному (4x4)");
    }

    private int sumArray(String[][] arr) throws ArrayDataException{
        int sum = 0;
        for (int row = 0; row < arr.length; row++)
            for (int col = 0; col < arr[row].length; col++) {
                try {
                    sum += Integer.parseInt(arr[row][col]);
                } catch (NumberFormatException ex) {
                    throw new ArrayDataException("Помилка у комірці " + row + ":" + col);
                } catch (ArrayIndexOutOfBoundsException ex) {
                    throw new ArrayDataException("Вихід за межі масиву");
                }
            }
        return sum;
    }
}
