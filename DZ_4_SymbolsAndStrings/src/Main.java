import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        String symbolOccurance = "aabbbc";
//        System.out.println(findSymbolOccurance(symbolOccurance, 'a'));
//        String source = "Hello world";
//        String target = "world";
//        System.out.println(findWordPosition(source, target));
//        System.out.println(stringReverse("Hello"));
//        System.out.println(isPalindrome("abcdefedcba"));
//        guessTheWord();
    }

    public static int findSymbolOccurance(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == c)
                count++;
        return count;
    }

    public static int findWordPosition(String first, String second) {
        if (first.contains(second))
            return first.indexOf(second);
        return -1;
    }

    public static String stringReverse(String str) {
        // Не знаю чи так нормально робити, то ж пропишу інший метод
        // return new StringBuilder(str).reverse().toString();

        StringBuilder builder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--)
            builder.append(str.charAt(i));
        return builder.toString();
    }

    public static boolean isPalindrome(String str) {
//        Використовуючи попередньо створені методи
//        String reverse = stringReverse(str);
//        return str.equals(reverse);
        int length = str.length();
        for (int start = 0, end = length - 1; start != length / 2; start++, end--)
            if (str.charAt(start) != str.charAt(end))
                return false;
        return true;
    }

    public static void guessTheWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                    "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive", " pea", "peanut", "pear",
                    "pepper", "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String randomWord = words[random.nextInt(words.length)];
        String dashes = "#".repeat(15);
        Scanner scanner = new Scanner(System.in);
        boolean isGuessed = false;
        StringBuilder mistakesBuilder = new StringBuilder("#".repeat(15));
        while (!isGuessed) {
            System.out.print("Уведіть слово, щоб відгадати: ");
            String guessedWord = scanner.nextLine();
            if (guessedWord.equals(randomWord)) {
                System.out.println("Вітаю, ви відгадали!");
                isGuessed = true;
            } else {
                int loopBound = Math.min(guessedWord.length(), randomWord.length());

                for (int i = 0; i < loopBound; i++) {
                    char c = guessedWord.charAt(i);
                    if (c == randomWord.charAt(i))
                        mistakesBuilder.setCharAt(i, c);
                }

                System.out.println("Відповідь неправильна, але ви на шляху до перемоги - " + mistakesBuilder);
            }

        }
        scanner.close();
    }
}