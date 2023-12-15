import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        FileData fd1 = new FileData("file1.txt", 64, "C:/");
        FileData fd2 = new FileData("file2.txt", 128, "D:/");
        FileData fd3 = new FileData("file3.jpg", 1024, "C:/");
        FileData fd4 = new FileData("file4.pdf", 512, "D:/");
        FileData fd5 = new FileData("file5.docx", 256, "C:/");
        FileData fd6 = new FileData("file6.txt", 128, "C:/");

        fileNavigator.add("C:/", fd1);
        fileNavigator.add("D:/", fd2);
        fileNavigator.add("C:/", fd3);
        fileNavigator.add("D:/", fd4);
        fileNavigator.add("C:/", fd5);

        // TODO: перевірка шляху та шляху-ключа
//        fileNavigator.add("TestPath", fd6);

        // TODO: Метод find
//        fileNavigator.find("C:/").forEach(file -> System.out.println(file));

        // TODO: Метод filterBySize
        // Цей метод бере всі файли, які задовільняють розмір, незалежно від шляху
//        fileNavigator.filterBySize(256).forEach(file -> System.out.println(file));

        // TODO: Метод remove
//        fileNavigator.remove("C:/");
//        fileNavigator.showAllFiles();

        // TODO: sortBySize
//        fileNavigator.sortBySize().forEach(file -> System.out.println(file));
    }
}