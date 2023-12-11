import phonebook.PhoneDirectory;
import phonebook.Record;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.printf("Кількість повторень: %d%n", countOccurence(generateRandomWords(), "Dragon"));
        System.out.println("-".repeat(100));
        // Task 2   convert array to list
        String[] stringArr = {"Apple", "Chair", "Dragon", "Fire", "Banana"};
        System.out.println(toList(stringArr));
        Integer[] intArr = {1, 2, 3, 4, 5};
        System.out.println(toList(intArr));
        System.out.println("-".repeat(100));
        // Task 3   Find unique numbers
        List<Integer> task3List = new ArrayList<>(List.of(9,9,2,2,2,5,5,6,3,5,5,4,4,1,1,8));
        System.out.println(findUnique(task3List));
        System.out.println("-".repeat(100));
        // Task 4   **
        List<String> task4List = generateRandomWords();
        printMap(calcOccurence(task4List));
        System.out.println("-".repeat(100));
        // Task 4   ***
        System.out.println(findOccurence(task4List));
        System.out.println("-".repeat(100));

        // Last tasks
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        Record record1 = new Record("Dmytro", "098 111 11 11");
        Record record2 = new Record("Dmytro", "098 222 22 22");
        Record record3 = new Record("Jake", "098 333 33 33");
        Record record4 = new Record("Robert", "098 444 44 44");
        phoneDirectory.add(record1);
        phoneDirectory.add(record2);
        phoneDirectory.add(record3);
        phoneDirectory.add(record4);
        System.out.println(phoneDirectory.find("Robert"));
        System.out.println(phoneDirectory.findAll("Dmytro"));
    }

    public static int countOccurence(List<String> list, String str) {
        int count = 0;
        for (String s : list)
            if (str.equals(s))
                count++;
        return count;
    }
    public static List<String> generateRandomWords() {
        List<String> list = new ArrayList<>();
        String[] words = {
                "Apple", "Chair", "Dragon", "Fire", "Banana",
                "Jazz", "Penguin", "Star", "Tiger", "Rain"
        };
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(words[rand.nextInt(words.length)]);
        }
        return list;
    }
    public static <T> List<T> toList(T[] arr) {
        return List.of(arr);
    }
    public static List<Integer> findUnique(List<Integer> originalList) {
        List<Integer> resultList = new ArrayList<>();
        Collections.sort(originalList);
        int size = originalList.size();
        int i = 0;
        while (i < size - 1) {
            int currentNum = originalList.get(i);
            if (i + 1 != size) {
                int nextNum = originalList.get(++i);
                if (currentNum != nextNum)
                    resultList.add(currentNum);
                else {
                    while (i < size - 1 && currentNum == nextNum) {
                        nextNum = originalList.get(++i);
                    }
                }
            }
            else
                resultList.add(currentNum);
        }
        return resultList;
    }
    public static Map<String, Integer> calcOccurence(List<String> list) {
        Map<String, Integer> wordsNumber = new HashMap<>();
        for (String s : list) {
            wordsNumber.put(s, wordsNumber.getOrDefault(s, 0) + 1);
        }
        return wordsNumber;
    }
    public static List<WordOccurence> findOccurence(List<String> list) {
        List<WordOccurence> wordOccurences = new ArrayList<>();
        for (String s : list) {
            int indexOfExistence = checkExistence(wordOccurences, s);
            if (indexOfExistence >= 0) {
                int newNum = wordOccurences.get(indexOfExistence).getNum() + 1;
                wordOccurences.get(indexOfExistence).setNum(newNum);
            }
            else
                wordOccurences.add(new WordOccurence(s));
        }
        return wordOccurences;
    }
    public static int checkExistence(List<WordOccurence> wordOccurences, String s) {
        for (int i = 0; i < wordOccurences.size(); i++)
            if (s.equals(wordOccurences.get(i).getName()))
                return i;
        return -1;
    }
    public static void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d,%n", entry.getKey(), entry.getValue());
        }
    }
}