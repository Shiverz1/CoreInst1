import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        List<File> folderList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//savegames"),
                new File("C://Games//temp"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );

        List<File> fileList = Arrays.asList(
                new File("C://Games//src//main//Main.java"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );

        createFolder(folderList);
        createFile(fileList);
        writeLog();

    }
    //Создаем папки
    public static void createFolder (List<File> folderList) {
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
    }
    //создаем файлы
    public static void createFile (List<File> fileList) {
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
    }
    //Запись лога в файл
    public static void writeLog () {
        try (FileWriter log = new FileWriter("C://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
    }
}
